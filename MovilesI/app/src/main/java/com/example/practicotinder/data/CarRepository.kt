package com.example.practicotinder.data

object CarRepository {
    private val cars = listOf(
        Car(
            id = 1,
            name = "Mustang GT",
            year = 2024,
            brand = "Ford",
            description = "Deportivo clásico americano con motor V8. Perfecto estado y sonido increíble.",
            images = listOf(
                "https://hips.hearstapps.com/hmg-prod/images/2019-ford-mustang-shelby-gt-s-lead2-1566224220.jpg?crop=0.808xw:0.881xh;0.0743xw,0.00847xh&resize=1200:*",
                "https://acroadtrip.blob.core.windows.net/catalogo-imagenes/s/RT_V_8a256cee2c51489a9b2d7f7144d5645c.webp",
                "https://www.ford.cz/content/dam/guxeu/rhd/central/cars/S650-Mustang/ford-eu-3_MUS_M_L_83699-1000x667.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZ2pQApCGXZ4o1wjXGJhDTwSvmDQerFc65KCrpFVp5RRniYyQiJULOVmndzLFVnYwgnPo&usqp=CAU"
            )
        ),
        Car(
            id = 2,
            name = "911 Carrera",
            year = 2023,
            brand = "Porsche",
            description = "Deportivo alemán de alta gama. Manejo excepcional y diseño icónico.",
            images = listOf(
                "https://images.unsplash.com/photo-1503376780353-7e6692767b70?w=400",
                "https://cdn.motor1.com/images/mgl/Oo0PRY/s3/0840_nevada_coupe_u-crane_akos0607_edit_v03-cielo.jpg",
                "https://images.unsplash.com/photo-1611651338412-8403fa6e3599?w=400",
                "https://images.unsplash.com/photo-1614162692292-7ac56d7f7f1e?w=400"
            )
        ),
        Car(
            id = 3,
            name = "Model S",
            year = 2024,
            brand = "Tesla",
            description = "Sedán eléctrico de alto rendimiento. Tecnología de punta y autonomía excepcional.",
            images = listOf(
                "https://i.blogs.es/a83342/tesla-model-s-1/450_1000.jpg",
                "https://images.unsplash.com/photo-1536700503339-1e4b06520771?w=400",
                "https://i.blogs.es/55c7f7/tesla-model-s-2021/450_1000.jpeg",
                "https://cdn.autobild.es/sites/navi.axelspringer.es/public/media/image/2022/01/tesla-model-s-2580999.jpg?tf=1200x900"
            )
        ),
        Car(
            id = 4,
            name = "M4 Competition",
            year = 2024,
            brand = "BMW",
            description = "Coupé deportivo con prestaciones de competición. Potencia y elegancia en su máxima expresión.",
            images = listOf(
                "https://images.unsplash.com/photo-1555215695-3004980ad54e?w=400",
                "https://hips.hearstapps.com/hmg-prod/images/bmw-m4-2025-8-65ba6e715f6ad.jpg?crop=0.651xw:0.560xh;0.182xw,0.199xh&resize=980:*",
                "https://images.unsplash.com/photo-1580273916550-e323be2ae537?w=400",
                "https://mediapool.bmwgroup.com/cache/P9/202009/P90399245/P90399245-the-new-bmw-m4-competition-coup-09-2020-2250px.jpg"
            )
        ),
        Car(
            id = 5,
            name = "GT-R",
            year = 2023,
            brand = "Nissan",
            description = "Superdeportivo japonés conocido como Godzilla. Rendimiento extraordinario y tecnología avanzada.",
            images = listOf(
                "https://jdmenginezone.com/cdn/shop/articles/2024-nissan-gt-r-tanitildi-iste-tasarimi-ve-ozellikleri-7952-18_60e170cf-bfd6-47e5-b09e-5fec15d8fe7d.jpg?v=1693926718",
                "https://es.nissanusa.com/content/dam/Nissan/us/vehicles/gtr/2024/site-simp/overview/carousel/2024-nissan-gt-r-white.jpg",
                "https://wieck-nissanao-production.s3.amazonaws.com/photos/0f1f7c57cbc0c093ecd008d5c8f973bd2c9c8bb5/preview-928x522.jpg",
                "https://i.pinimg.com/736x/90/29/e1/9029e1726e584ccb7086a2086cd411ab.jpg"
            )
        ),
        Car(
            id = 6,
            name = "Huracán",
            year = 2024,
            brand = "Lamborghini",
            description = "Superdeportivo italiano con diseño radical. Velocidad y exclusividad garantizada.",
            images = listOf(
                "https://www.shutterstock.com/image-photo/dubai-uae-01-2021-lamborghini-260nw-1990007540.jpg",
                "https://images.unsplash.com/photo-1566473965997-3de9c817e938?w=400",
                "https://static.motor.es/fotos-jato/lamborghini/uploads/lamborghini-huracan-6824e23712aaf.jpg",
                "https://hips.hearstapps.com/es.h-cdn.co/cades/contenidos/47425/performante.jpg"
            )
        ),
        Car(
            id = 7,
            name = "F8 Tributo",
            year = 2023,
            brand = "Ferrari",
            description = "El arte de la ingeniería italiana. Diseño y prestaciones extraordinarias.",
            images = listOf(
                "https://images.unsplash.com/photo-1583121274602-3e2820c69888?w=400",
                "https://images.unsplash.com/photo-1592198084033-aade902d1aae?w=400",
                "https://images.unsplash.com/photo-1583121274602-3e2820c69888?w=400",
                "https://images.unsplash.com/photo-1592198084033-aade902d1aae?w=400"
            )
        ),
        Car(
            id = 8,
            name = "AMG GT",
            year = 2024,
            brand = "Mercedes-Benz",
            description = "Coupé deportivo alemán de lujo. Combina rendimiento y confort de manera excepcional.",
            images = listOf(
                "https://images.unsplash.com/photo-1618843479313-40f8afb4b4d8?w=400",
                "https://images.unsplash.com/photo-1615106806531-183c16d45573?w=400",
                "https://images.unsplash.com/photo-1617814076367-b759c7d7e738?w=400",
                "https://images.unsplash.com/photo-1615106806241-6a2a5b2e0b7f?w=400"
            )
        ),
        Car(
            id = 9,
            name = "RS e-tron GT",
            year = 2024,
            brand = "Audi",
            description = "Sedán eléctrico deportivo con tecnología de vanguardia. Rendimiento sostenible.",
            images = listOf(
                "https://www.wsupercars.com/thumbnails-wide/Audi/2025-Audi-RS-E-Tron-GT-002.jpg",
                "https://4kwallpapers.com/images/wallpapers/audi-rs-e-tron-gt-7680x4320-17295.jpg",
                "https://images.unsplash.com/photo-1614026480209-cd9934144671?w=400",
                "https://images.unsplash.com/photo-1612911912304-22bde2dc7bf0?w=400"
            )
        ),
        Car(
            id = 10,
            name = "Vantage",
            year = 2023,
            brand = "Aston Martin",
            description = "Deportivo británico de lujo. Elegancia y deportividad en perfecta armonía.",
            images = listOf(
                "https://images.unsplash.com/photo-1605515298946-d062f2e9da53?w=400",
                "https://images.unsplash.com/photo-1605515298946-d062f2e9da53?w=400",
                "https://images.unsplash.com/photo-1605515298946-d062f2e9da53?w=400",
                "https://images.unsplash.com/photo-1605515298946-d062f2e9da53?w=400"
            )
        )
    )

    fun getAllCars(): List<Car> = cars
}
