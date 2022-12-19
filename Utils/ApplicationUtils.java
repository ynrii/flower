package com.epam.java.education.lesson_1.Utils;

import com.epam.java.education.lesson_1.classes.Flower;
import com.epam.java.education.lesson_1.classes.FlowersBasket;
import com.epam.java.education.lesson_1.classes.FlowersBasketsBouquetsFabric;
import com.epam.java.education.lesson_1.classes.FlowersBouquet;
import com.epam.java.education.lesson_1.enums.EFlowerCategory;
import com.epam.java.education.lesson_1.enums.EFlowerColor;

import java.util.Collections;

import static com.epam.java.education.lesson_1.Utils.PropertiesFileUtils.loadFlowersToBasketByPropertiesFile;
import static com.epam.java.education.lesson_1.classes.FlowersBasketsBouquetsFabric.*;

/**
 * Служебный класс для работы с приложением
 */
public class ApplicationUtils {

    // создает фабрику
    public static FlowersBasketsBouquetsFabric createMyFabric() {
       System.out.println("\nСоздаем фабрику объектов для работы приложения");

       return new FlowersBasketsBouquetsFabric();
    }

    // демонстрирует возможности работы со списком корзин цветов при помощи фабрики
    public static void workBasketsByMyFabric(FlowersBasketsBouquetsFabric myFabric) {
        // создадим корзины цветов из загруженных данных с помощью фабрики
        FlowersBasket flowersBasket1 = myFabric.CreateFlowersBasket(1, "Корзина с розами");
        FlowersBasket flowersBasket2 = myFabric.CreateFlowersBasket(2, "Корзина с астрами");
        FlowersBasket flowersBasket3 = myFabric.CreateFlowersBasket(3, "Корзина с лилиями");
        FlowersBasket flowersBasket4 = myFabric.CreateFlowersBasket(4, "Корзина с георгинами");

        // загрузим цветы в созданные корзины из параметров автозапуска

        // загрузка цветов в 1 корзину
        loadFlowersToBasketByPropertiesFile("load.properties", flowersBasket1, "0");
        loadFlowersToBasketByPropertiesFile("load.properties", flowersBasket1, "1");
        // добавим еще одну розу в эту корзину через фабрику объектов для демонстрации возможностей фабрики
        Flower flowerRose = myFabric.CreateFlower((flowersBasket1.getFlowersBasketList().size() + 1),
                "Роза голландская", "Красная", EFlowerColor.RED,
                EFlowerCategory.getNameByCategory(EFlowerCategory.ROSE), EFlowerCategory.ROSE, 1500.00f);
        flowersBasket1.addFlower(flowerRose);

        // загрузка цветов во 2 корзину
        loadFlowersToBasketByPropertiesFile("load.properties", flowersBasket2, "2");

        // загрузка цветов в 3 корзину
        loadFlowersToBasketByPropertiesFile("load.properties", flowersBasket3, "3");

        // загрузка цветов в 4 корзину
        loadFlowersToBasketByPropertiesFile("load.properties", flowersBasket4, "4");

        // сделаем вывод в консоль загруженных данных
        // в список корзин с цветами
        System.out.println("\nВыводим НЕ отсортированный по цене список корзин цветов");
        myFabric.printBasketsFromListBasket();
        // теперь отсортируем список корзин с цветами по стоимости
        Collections.sort(myFabric.getFlowersBasketList());
        // сделаем вывод списка еще раз
        System.out.println("\nВыводим отсортированный по цене список корзин цветов");
        myFabric.printBasketsFromListBasket();
    }

    // демонстрирует возможности работы со списком букетов цветов при помощи фабрики
    public static void workBouquetsByMyFabric(FlowersBasketsBouquetsFabric myFabric) {

        System.out.println("\nСоздаем букеты цветов при помощи фабрики");

        // Букет 1
        FlowersBouquet flwBouquet1 = myFabric.CreateFlowersBouquet(1);
        int index = myFabric.searchBasketIndexByCode(myFabric.getFlowersBasketList(), 1);
        FlowersBasket flwBasket1 = myFabric.getFlowersBasketList().get(index);
        addFlowerToBouquet(flwBasket1, flwBouquet1, EFlowerCategory.ROSE, "Роза голландская", EFlowerColor.WHITE, "Белая", 500.00f, 3);
        addFlowerToBouquet(flwBasket1, flwBouquet1, EFlowerCategory.ROSE, "Роза местная", EFlowerColor.BLACK, "Черная", 350.00f, 2);

        // Букет 2
        FlowersBouquet flwBouquet2 = myFabric.CreateFlowersBouquet(2);
        index = myFabric.searchBasketIndexByCode(myFabric.getFlowersBasketList(), 2);
        FlowersBasket flwBasket2 = myFabric.getFlowersBasketList().get(index);
        addFlowerToBouquet(flwBasket2, flwBouquet2, EFlowerCategory.ASTRA, "Астра", EFlowerColor.WHITE, "Белая", 200.00f, 3);
        index = myFabric.searchBasketIndexByCode(myFabric.getFlowersBasketList(), 4);
        FlowersBasket flwBasket3 = myFabric.getFlowersBasketList().get(index);
        addFlowerToBouquet(flwBasket3, flwBouquet2, EFlowerCategory.OTHER_CATEGORY, "Георгин местный", EFlowerColor.OTHER_COLOR, "Бордо", 450.00f, 2);

        // Букет 3
        FlowersBouquet flwBouquet3 = myFabric.CreateFlowersBouquet(3);
        index = myFabric.searchBasketIndexByCode(myFabric.getFlowersBasketList(), 3);
        FlowersBasket flwBasket4 = myFabric.getFlowersBasketList().get(index);
        addFlowerToBouquet(flwBasket4, flwBouquet3, EFlowerCategory.LILIA, "Лилия китайская", EFlowerColor.OTHER_COLOR, "Бело-розовая", 1000.00f, 7);

        // сделаем вывод в консоль загруженных данных
        // в список букетов с цветами
        System.out.println("\nВыводим НЕ отсортированный по цене список букетов цветов");
        myFabric.printBouquetFromListBouquet();
        // теперь отсортируем список букетов с цветами по стоимости
        Collections.sort(myFabric.getFlowersBouquetList());
        // сделаем вывод списка еще раз
        System.out.println("\nВыводим отсортированный по цене список букетов цветов");
        myFabric.printBouquetFromListBouquet();

        System.out.println("\nВыводим содержание каждого букета из списка букетов");

        for (FlowersBouquet flwBouquet : myFabric.getFlowersBouquetList()) {
            System.out.println(flwBouquet.toString());
            flwBouquet.printFlowersFromBouquet();
        }

        // вернем 2 цветка розы в корзину flwBasket1 из букета flwBouquet1
        System.out.println("\nВернем 2 цветка розы из 1 букета обратно в корзину");
        backFlowerToBasket(flwBouquet1, flwBasket1, EFlowerCategory.ROSE, "Роза местная", EFlowerColor.BLACK, "Черная", 350.00f, 2);
        flwBouquet1.printFlowersFromBouquet();
        flwBasket1.printFlowersFromBasket();

        // отсортируем цветы в 1 корзине по цене
        System.out.println("\nСортируем цветы в 1 корзине по цене");
        Collections.sort(flwBasket1.getFlowersBasketList());
        flwBasket1.printFlowersFromBasket();
    }


}
