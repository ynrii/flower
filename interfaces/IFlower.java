package com.epam.java.education.lesson_1.interfaces;

import com.epam.java.education.lesson_1.enums.EFlowerCategory;
import com.epam.java.education.lesson_1.enums.EFlowerColor;

public interface IFlower {
    /**
     * Код цветка
     */
    int flowerCode = 0;
    /**
     * Наименование цветка
     */
    String flowerName = "";

    /**
     * Цвет цветка
     */
    EFlowerColor flowerColor = EFlowerColor.OTHER_COLOR;
    /**
     * Цвет цветка в текстовом виде
     */
    String flowerColorName = "";

    /**
     * Категория цветка
     */
    EFlowerCategory flowerCategory = EFlowerCategory.OTHER_CATEGORY;
    /**
     * Категория цветка в текстовом виде
     */
    String flowerCategoryName = "";

    /**
     * Возвращает текстовое значение имени цвета цветка
     * должен возвращать текстовое значение имени цвета цветка
     * @return должен возвращать текстовое значение имени цвета цветка
     */
    public String getFlowerColorName();

    /**
     * Устанавливает текстовое значение имени цвета цветка
     * @param flowerColorName содержит текстовое значение имени цвета цветка
     */
    public void setFlowerColorName(String flowerColorName);


    /**
     * Возвращает текстовое значение имени категории цветка
     * должен возвращать текстовое значение имени категории цветка
     * @return должен возвращать текстовое значение имени категории цветка
     */
    public String getFlowerCategoryName();

    /**
     * Устанавливает текстовое значение имени категории цветка
     * @param flowerCategoryName содержит текстовое значение имени категории цветка
     */
    public void setFlowerCategoryName(String flowerCategoryName);

    /**
     * Метод возвращает наименование категории цветка
     * @param fc параметр содержит значение категории цветка
     * @return имя категории цветка которое должен вернуть метод
     */
    public String getCategoryNameByCategory(EFlowerCategory fc);

    /**
     * Метод возвращает наименование цвета цветка
     * @param fc параметр содержит значение цвета цветка
     * @return имя цвета цветка которое должен вернуть метод
     */
    public String getColorNameByColor(EFlowerColor fc);

}
