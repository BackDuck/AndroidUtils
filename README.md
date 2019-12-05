## Утилиты для андроид

Здесь хранится набор утилит которые были созданы при работе над тем или иным проектом.

## FrameByFrameAnimation

Инструмент для работы с покадровой анимацией
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

Инструмент для локального кеширования http запросов с использованием rx

Пример:
```kotlin
 override fun getTest(useCache: Boolean): Single<TestModel> {
        return cache.sendRequest(halvaRequests.getTestData(), useCache)
    }
```

## BottomSheetDialogBase

Базовый класс и набор стилей для BottomSheetDialog позволяющий отображать диалоговое окно с отступами
![Пример]()
Пример:
```kotlin
class TestDialog : BottomSheetDialogBase() {

    override val layout: Int = R.layout.test_view
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
```

