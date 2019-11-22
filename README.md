## Утилиты для андроид

Здесь хранится набор утилит которые были созданы при работе над тем или иным проектом.

## FrameByFrameAnimation

Инструмент для работы с покадровой анимацией
Пример:
```kotlin
val anim = animationBuilder
                .setFrameCount(76)
                .setFrameDuration(1000/30)
                .setPrefix("halvenok_tennis")
                .setIndexPattern("00000")
                .build()

        loader.setImageDrawable(anim)
        anim.start()
```
