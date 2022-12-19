package com.epam.java.education.lesson_1;

import com.epam.java.education.lesson_1.classes.FlowersBasketsBouquetsFabric;
import static com.epam.java.education.lesson_1.Utils.ApplicationUtils.*;
import static com.epam.java.education.lesson_1.Utils.PropertiesFileUtils.*;

public class Main {
    /**
     * Метод запуска приложения
     * @param args параметр не обрабатывается при запуске приложения
     */
    public static void main(String[] args) {
        // загружаем автопараметры для запуска приложения в файл типа Properties
        savePropertiesStartupToFile("load.properties");

        // создадим фабрику объектов для работы приложения
        FlowersBasketsBouquetsFabric myFabric = createMyFabric();

        // демонстрация работы со списком объектов, содержащего корзины цветов
        workBasketsByMyFabric(myFabric);

        // демонстрация работы со списком объектов, содержащего букеты цветов
        workBouquetsByMyFabric(myFabric);

    }
}
