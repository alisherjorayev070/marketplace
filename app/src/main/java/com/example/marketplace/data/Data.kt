package com.example.marketplace.data

import com.example.marketplace.R
import com.example.marketplace.data.room.entity.AboutProductItemData
import com.example.marketplace.data.room.entity.CategoryEntity
import com.example.marketplace.data.room.entity.ProductEntity

object Data {
    private val products = arrayListOf<ProductEntity>()
    private val categories = arrayListOf<CategoryEntity>(
        CategoryEntity(0, "Женщинам"),
        CategoryEntity(1, "Обувь"),
        CategoryEntity(2, "Детям"),
        CategoryEntity(3, "Мужчинам"),
        CategoryEntity(4, "Дом"),
        CategoryEntity(5, "Красота"),
        CategoryEntity(6, "Аксессуары"),
        CategoryEntity(7, "Электроника"),
        CategoryEntity(8, "Игрушки"),
        CategoryEntity(9, "Мебель"),
        CategoryEntity(10, "Товары для взрослых"),
        CategoryEntity(11, "Продукты"),
        CategoryEntity(12, "Бытовая техника"),
        CategoryEntity(13, "Зоотовары"),
        CategoryEntity(14, "Спорт"),
        CategoryEntity(15, "Автотовары"),
        CategoryEntity(16, "Книги"),
        CategoryEntity(17, "Premium"),
        CategoryEntity(18, "Для ремонта"),
        CategoryEntity(19, "Сад и дача"),
        CategoryEntity(20, "Здоровье"),
        CategoryEntity(21, "Канцтовары"),
    )

    fun getProducts(): List<ProductEntity> {
        return products
    }

    fun getCategories(): List<CategoryEntity> {
        return categories
    }

    fun getByID(productID: Int): ProductEntity? {
        return products.find { it.productId == productID }
    }

    fun initProducts() {
        products.add(
            ProductEntity(
                123642329,
                "iPhone",
                "1200$",
                "Модель представлена для рынка США.iPhone 13 Pro Max. Грандиозный апгрейд камер Pro. Режим \"Киноэффект\" делает из видео настоящее кино. Дисплей Super Retina XDR с технологией ProMotion для более быстрого и плавного взаимодействия. A15 Bionic - самый быстрый чип для iPhone. Прочный корпус и самое долгое время работы без подзарядки среди iPhone.",
                R.drawable.photo_3,
                arrayListOf(
                    AboutProductItemData(
                        "Тактовая частота процессора",
                        "3200 МГц"
                    ),
                    AboutProductItemData(
                        "Процессор",
                        "Apple A15 Bionic"
                    ),
                    AboutProductItemData(
                        "Количество ядер процессора",
                        "6 ядер"
                    ),
                    AboutProductItemData(
                        "Время работы при воспроизведении видео",
                        "28 час"
                    )
                )
            )
        )
        products.add(
            ProductEntity(
                123642312,
                "Apple Наушники Apple AirPods 3 (MME73ZM/A)",
                "299$",
                "1. Представляем абсолютно новые AirPods. Технология пространственного аудио окружает звуком со всех сторон. 2. Адаптивный эквалайзер подстраивает музыку персонально под вас. Аккумулятор работает ещё дольше без подзарядки.",
                R.drawable.photo_2,
                arrayListOf(
                    AboutProductItemData(
                        "Время разговора до",
                        "4 мин"
                    ),
                    AboutProductItemData(
                        "Вес товара с упаковкой (г)",
                        "180 г"
                    ),
                    AboutProductItemData(
                        "Ширина упаковки",
                        "9.9 см"
                    ),
                    AboutProductItemData(
                        "Высота упаковки",
                        "3.4 см"
                    )
                )
            )
        )
        products.add(
            ProductEntity(
                123642328,
                "Computer",
                "1299$",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                R.drawable.photo_1,
                arrayListOf(
                    AboutProductItemData(
                        "Тактовая частота процессора",
                        "1 МГц"
                    ),
                    AboutProductItemData(
                        "Количество ядер процессора",
                        "4"
                    ),
                    AboutProductItemData(
                        "Линейка процессоров",
                        "Core i5"
                    ),
                    AboutProductItemData(
                        "Процессор",
                        "Core i5 1035G1"
                    )
                )
            )
        )
        products.add(
            ProductEntity(
                123642324,
                "Sneakers",
                "122$",
                "Внимание: Кроссовки маломерят на один размер. Мужские зимние кроссовки на кедной подошве отличаются максимально удобной колодкой, гибкой подошвой и облегающей эргономичной формой.",
                R.drawable.photo_4,
                arrayListOf(
                    AboutProductItemData(
                        "Вес",
                        "300 г"
                    ),
                    AboutProductItemData(
                        "Ширина упаковки",
                        "22 см"
                    ),
                    AboutProductItemData(
                        "Высота упаковки",
                        "13 см"
                    ),
                    AboutProductItemData(
                        "Оптимальная скорость спортсмена",
                        "40 мин/км"
                    )
                )
            )
        )

    }
}