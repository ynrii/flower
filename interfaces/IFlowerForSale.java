package com.epam.java.education.lesson_1.interfaces;

import com.epam.java.education.lesson_1.enums.EFlowerCategory;
import com.epam.java.education.lesson_1.enums.EFlowerColor;

/**
 * Расширение интерфейса для реализации в классах цветок. Содержит дополнение в виде поля цена цветка
 */
public interface IFlowerForSale extends IFlower {
    // цена цветка
    float flowerCost = 0.00f;

    /**
     * Метод должен возвращать цену цветка
     * @return должен возвращать текстовое значение имени категории цветка
     */
    float getFlowerCost();

    /**
     * Метод должен устанавливать значение цены цветка
     * @param flowerCost содержит значение цены цветка
     */
    void setFlowerCost(float flowerCost);
}
