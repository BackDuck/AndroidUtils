package helper.utils.rxlocalcacheforrequests

import android.util.Log
import android.util.LruCache
import io.reactivex.Completable
import io.reactivex.Single

class CacheController(val lruCache: LruCache<String, CachedResponse>) {

    companion object {
        const val CACHE_TIMEOUT = (5 * 60 * 1000).toLong()  //5 minute
        const val CACHE_TAG = "CACHE"
    }

    fun <T> sendRequest(
        request: Single<T>,
        useCache: Boolean,
        tagSuffix: String = "",
        timeout: Long = CACHE_TIMEOUT
    ): Single<T> {
        val tag = StringBuilder()
            .append(Throwable().stackTrace[2].methodName)
            .append(tagSuffix)
            .toString()

        var response: T? = null
        Log.i(CACHE_TAG, "request: $tag, from cache: $useCache")
        if (useCache) {
            val cachedData = getCachedResponseIfExist(tag)
            cachedData?.let {
                if (System.currentTimeMillis() - it.cachedTime < timeout) {
                    response = it.response as? T
                    response?.let {
                        Log.i(CACHE_TAG, "request: $tag, data from CACHE")

                        return Single.fromCallable { response }
                    }
                }
            }
        }

        Log.i(CACHE_TAG, "request: $tag, data from NETWORK")
        return request
            .doOnSuccess { resp ->
                tag?.let { t ->
                    putInCache(t, resp as Any)
                }
            }
    }

    private fun getCachedResponseIfExist(tag: String): CachedResponse? {
        return try {
            lruCache.get(tag)
        } catch (e: Exception) {
            null
        }
    }

    fun clearCache(): Completable = Completable.fromAction {lruCache.evictAll()}

    private fun putInCache(tag: String, response: Any) {
        lruCache.put(tag, CachedResponse(System.currentTimeMillis(), response))
    }

    data class CachedResponse(
        val cachedTime: Long,
        val response: Any
    )
}