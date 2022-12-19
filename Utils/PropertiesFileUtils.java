package com.epam.java.education.lesson_1.Utils;

import com.epam.java.education.lesson_1.classes.Flower;
import com.epam.java.education.lesson_1.enums.EFlowerCategory;
import com.epam.java.education.lesson_1.enums.EFlowerColor;
import com.epam.java.education.lesson_1.classes.FlowersBasket;

import java.io.*;
import java.util.Properties;

/**
 * Служебный класс для автоматической загрузки данных из файла определенного формата типа Properties
 */
public class PropertiesFileUtils {

    /**
     * Метод загружает данные для дальнейшего использования из файла определенного формата
     * @param fileName параметр указывает имя файла с которого будут загружаться данные
     * @param flowersToBasket содержит ссылку на объект - корзина цветов в которую будут загружаться данные из файла
     * @param rowValue содержит в себе значение(целое число в текстовом виде) номера строки из файла.
     *                 Указывается в каждом поле для каждой строки данных в файле (к примеру flowerCategory1
     *                 это 1 строка данных, которые будут загружены в корзину цветов и т.д.)
     */
    public static void loadFlowersToBasketByPropertiesFile (String fileName, FlowersBasket flowersToBasket, String rowValue) {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(fileName);

            prop.load(input);

            autoLoadFlowersToBasket(prop, flowersToBasket, rowValue);
            flowersToBasket.calculateBasketCost();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Метод загрузки данных(цветов) в корзину цветов из файла
     * @param prop содержит в себе данные упорядоченные по категориям цветов
     * @param rowValue Служебный параметр для загрузки данных построчно (к примеру = 1, тогда грузятся все
     *                 ключевые параметры которые заканчиваются на 1 в файле параметров автозапуска)
     */
    private static void autoLoadFlowersToBasket (Properties prop, FlowersBasket flowersToBasket, String rowValue) {
        // инициализация переменных для загрузки
        Integer fCount = Integer.valueOf(prop.getProperty("flowerCount" + rowValue));

        Integer fCategory = 4;
        Integer fColor = 4;

        Flower flw;
        EFlowerCategory flowerCategory;
        EFlowerColor flowerColor;

        int tmpFirstIndex = flowersToBasket.getFlowersBasketList().size() + 1;
        fCount = (tmpFirstIndex - 1) + fCount;

        for (int i = tmpFirstIndex; i <= fCount; i++) {

            fCategory = Integer.valueOf(prop.getProperty("flowerCategory" + rowValue));
            switch (fCategory) {
                case 0:
                    flowerCategory = EFlowerCategory.ROSE;
                    break;
                case 1:
                    flowerCategory = EFlowerCategory.LILIA;
                    break;
                case 2:
                    flowerCategory = EFlowerCategory.FIALKA;
                    break;
                case 3:
                    flowerCategory = EFlowerCategory.ASTRA;
                    break;
                case 4:
                    flowerCategory = EFlowerCategory.OTHER_CATEGORY;
                    break;
                default:
                    flowerCategory = EFlowerCategory.OTHER_CATEGORY;
            }

            fColor = Integer.valueOf(prop.getProperty("flowerColor" + rowValue));
            switch (fColor) {
                case 0:
                    flowerColor = EFlowerColor.WHITE;
                    break;
                case 1:
                    flowerColor = EFlowerColor.BLACK;
                    break;
                case 2:
                    flowerColor = EFlowerColor.RED;
                    break;
                case 3:
                    flowerColor = EFlowerColor.YELLOW;
                    break;
                case 4:
                    flowerColor = EFlowerColor.OTHER_COLOR;
                    break;
                default:
                    flowerColor = EFlowerColor.OTHER_COLOR;
            }

            // используем для загрузки конструктор, который реализован в классе Flower
            flw = new Flower(i, prop.getProperty("flowerName" + rowValue),
                    prop.getProperty("flowerColorName" + rowValue),
                    flowerColor,
                    prop.getProperty("flowerCategoryName" + rowValue),
                    flowerCategory,
                    Float.valueOf(prop.getProperty("flowerCost" + rowValue)));

            // добавим цветок в указанную корзину
            flowersToBasket.addFlower(flw);
        }
    }

    /**
     * Метод подготовки данных для сохранения в файл (для дальнейшей загрузки из файла)
     * @param prop параметр указывает на контейнер с данными для сохранения в файл
     * @param rowData параметр содержит данные в виде массива для сохранения в файл
     * ("flowerName" + rowValue = rowData[0]
     *  "flowerCategory" + rowValue = rowData[1]
     *  "flowerCategoryName" + rowValue = rowData[2]
     *  "flowerColor" + rowValue = rowData[3]
     *  "flowerColorName" + rowValue = rowData[4]
     *  "flowerCount" + rowValue = rowData[5]
     *  "flowerCost" + rowValue = rowData[6]
     * @param rowValue параметр указывает на строку данных, которая будет сохранена в файл
     */
    private static void saveFlowerCategoryForStartup (Properties prop, String[] rowData, String rowValue) {
        prop.setProperty("flowerName" + rowValue, rowData[0].toString());
        prop.setProperty("flowerCategory" + rowValue, rowData[1].toString());
        prop.setProperty("flowerCategoryName" + rowValue, rowData[2].toString());
        prop.setProperty("flowerColor" + rowValue, rowData[3].toString());
        prop.setProperty("flowerColorName" + rowValue, rowData[4].toString());
        prop.setProperty("flowerCount" + rowValue, rowData[5].toString());
        prop.setProperty("flowerCost" + rowValue, rowData[6].toString());
    }

    /**
     * Метод подготавливает и сохраняет данные для автотестов программы в файл
     * @param fileName параметр указывает на имя файла в который будут сохранены данные
     */
    public static void savePropertiesStartupToFile (String fileName) {
        System.out.println("\nСоздаем файл с данными для автозагрузки в приложение");

        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream(fileName);

            String[] row0 = {"Роза голландская", "0", "Роза", "0", "Белая", "10", "500.00"};
            saveFlowerCategoryForStartup(prop, row0, "0");
            prop.store(output, null);
            prop.clear();

            String[] row1 = {"Роза местная", "0", "Роза", "1", "Черная", "20", "350.00"};
            saveFlowerCategoryForStartup(prop, row1, "1");
            prop.store(output, null);
            prop.clear();

            String[] row2 = {"Астра", "3", "Астра", "0", "Белая", "50", "200.00"};
            saveFlowerCategoryForStartup(prop, row2, "2");
            prop.store(output, null);
            prop.clear();

            String[] row3 = {"Лилия китайская", "1", "Лилия", "4", "Бело-розовая", "15", "1000.00"};
            saveFlowerCategoryForStartup(prop, row3, "3");
            prop.store(output, null);
            prop.clear();

            String[] row4 = {"Георгин местный", "4", "Георгин", "4", "Бордо", "30", "450.00"};
            saveFlowerCategoryForStartup(prop, row4, "4");
            prop.store(output, null);
            prop.clear();
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
