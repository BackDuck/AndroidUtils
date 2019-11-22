package helper.utils.framebyframeanimation

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import java.lang.StringBuilder

class FrameByFrameAnimation(val context: Context, private val prefix: String, private val frameCount: Int, private val frameDuration: Int, private val indexPattern: String?) {

    fun createAnimationDrawable(): AnimationDrawable {
        val animation = AnimationDrawable()
        for (i in 0 until frameCount) {
            val rId = "$prefix${getFormattedIndex(i)}"
            animation.addFrame(getDrawableIfExist(rId), frameDuration)
        }

        return animation
    }

    private fun getFormattedIndex(index: Int): String {

        return indexPattern?.let { pattern ->
            val patternLength = pattern.length
            val indexLength = index.toString().length
            val defaultItem = pattern.first()
            if (indexLength < patternLength) {
                val newIndex = StringBuilder()
                for (i in 0 until (patternLength - indexLength)) {
                    newIndex.append(defaultItem)
                }
                newIndex.append(index)
                newIndex.toString()
            } else {
                index.toString()
            }
        } ?: index.toString()
    }

    private fun getDrawableIfExist(id: String): Drawable {
        return try {
            ContextCompat.getDrawable(context, context.resources.getIdentifier(id, "drawable", context.packageName))
                    ?: throw Exception("Frame $id not found!")
        } catch (e: Exception) {
            throw Exception("Frame $id not found!")
        }

    }

    class Builder(private val context: Context) {
        private var prefix: String? = null
        private var frameCount: Int? = null
        private var frameDuration: Int? = null
        private var indexPattern: String? = null

        /**
        * Префикс в названии кадра.
        * Обязательный параметр.
        */

        fun setPrefix(prefix: String): Builder {
            this.prefix = prefix
            return this
        }

        /**
        * Длительность показа одного кадра.
        * Обязательный параметр.
        */

        fun setFrameDuration(frameDuration: Int): Builder {
            this.frameDuration = frameDuration
            return this
        }

        /**
        * Общее количество кадров в анимации.
        * Обязательный параметр.
        */

        fun setFrameCount(frameCount: Int): Builder {
            this.frameCount = frameCount
            return this
        }

        /**
        * Например шаблон 00000 при индексе 2 будет означать что индекс будет дополнен до пяти элементов, дополнительные элементы будут добавлены перед индексом.
        * В качестве дополнительного элемента используется первый элемент шаблона
        *
        * В случае когда разрядность индекса превышает количество элементов в шаблоне индекс будет использован "как есть"
         */

        fun setIndexPattern(indexPattern: String): Builder {
            this.indexPattern = indexPattern
            return this
        }

        fun build(): AnimationDrawable {
            val checkedPrefix = prefix
                    ?: throw Exception("Prefix not found. This field is required!")
            val checkedFrameCount = frameCount
                    ?: throw Exception("Frame count not found. This field is required!")
            val checkedFrameDuration = frameDuration
                    ?: throw Exception("Frame duration not found. This field is required!")
            val fBfAnimation = FrameByFrameAnimation(context, checkedPrefix, checkedFrameCount, checkedFrameDuration, indexPattern)

            return fBfAnimation.createAnimationDrawable()
        }
    }
}