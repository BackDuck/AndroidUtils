## Утилиты для андроид

Здесь хранится набор утилит которые были созданы при работе над тем или иным проектом.

[FrameByFrameAnimation](#FrameByFrameAnimation)  
[CacheController](#CacheController)  
[BottomSheetDialogBase](#BottomSheetDialogBase)  
[ViewPagerHeightWrapContent](#ViewPagerHeightWrapContent)  

## FrameByFrameAnimation

Инструмент для работы с покадровой анимацией
[Прямая ссылка](https://github.com/BackDuck/AndroidUtils/tree/master/app/src/main/java/helper/utils/framebyframeanimation)

Пример:
```kotlin
val animationBuilder = FrameByFrameAnimation.Builder(context)
val anim = animationBuilder
                .setFrameCount(76)
                .setFrameDuration(1000/30)
                .setPrefix("halvenok_tennis")
                .setIndexPattern("00000")
                .build()

        loader.setImageDrawable(anim)
        anim.start()
```

## CacheController
[Прямая ссылка](https://github.com/BackDuck/AndroidUtils/tree/master/app/src/main/java/helper/utils/rxlocalcacheforrequests)

Инструмент для локального кеширования http запросов с использованием rx

Пример:
```kotlin
 override fun getTest(useCache: Boolean): Single<TestModel> {
        return cache.sendRequest(halvaRequests.getTestData(), useCache)
    }
```

## BottomSheetDialogBase
[Прямая ссылка](https://github.com/BackDuck/AndroidUtils/tree/master/app/src/main/java/helper/utils/bottomsheetdialogwithpaddings)

Базовый класс и набор стилей для BottomSheetDialog позволяющий отображать диалоговое окно с отступами
![Пример](https://raw.githubusercontent.com/BackDuck/AndroidUtils/master/repfiles/photo_2019-12-05_15-45-40.jpg)

Пример:
```kotlin
class TestDialog : BottomSheetDialogBase() {

    override val layout: Int = R.layout.test_view
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
```

## ViewPagerHeightWrapContent
[Прямая ссылка](https://github.com/BackDuck/AndroidUtils/tree/master/app/src/main/java/helper/utils/viewpagerwithwrapcontentinheight)

ViewPager поддерживающий wrap_content по высоте


