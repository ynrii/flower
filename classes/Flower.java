package com.epam.java.education.lesson_1.classes;

import com.epam.java.education.lesson_1.enums.EFlowerCategory;
import com.epam.java.education.lesson_1.enums.EFlowerColor;
import com.epam.java.education.lesson_1.interfaces.IFlowerForSale;

/**
 * Основной класс который реализует работу с объектами цветок для букета
 */
public class Flower extends AFlower implements IFlowerForSale, Comparable <Flower> {
    /**
     * Код цветка
     */
    private int flowerCode;
    /**
     * Наименование цветка
     */
    private String flowerName;

    /**
     * Цвет цветка
     */
    private EFlowerColor flowerColor;
    /**
     * Цвет цветка в текстовом виде
     */
    private String flowerColorName;

    /**
     * Категория цветка
     */
    private EFlowerCategory flowerCategory;
    /**
     * Категория цветка в текстовом виде
     */
    private String flowerCategoryName;

    /**
     * Стоимость цветка
     */
    private float flowerCost;

    /**
     * Конструктор для создания объекта цветок
     * @param flowerCode параметр содержит код цветка
     * @param flowerName параметр содержит имя цветка
     * @param flowerColorName параметр содержит наименование цвета цветка
     * @param flowerColor параметр содержит цвет цветка
     * @param flowerCategory параметр содержит категорию цветка
     * @param flowerCategoryName параметр содержит наименование категории цветка
     * @param flowerCost параметр содержит цену цветка
     */
    public Flower (int flowerCode, String flowerName,
                   String flowerColorName, EFlowerColor flowerColor,
                   String flowerCategoryName, EFlowerCategory flowerCategory,
                   float flowerCost) {
        // вызываем родительский конструктор для создания объекта
        super(flowerCode, flowerName, flowerColorName, flowerColor, flowerCategoryName, flowerCategory);

        // заносим значение цены цветка
        this.flowerCost = flowerCost;
    }

    /**
     * Метод возвращает значение цены цветка
     * @return возвращает значение цены цветка
     */
    public float getFlowerCost() {
        return flowerCost;
    }

    /**
     * Метод позволяет занести значение цены цветка
     * @param flowerCost содержит значение цены цветка
     */
    public void setFlowerCost(float flowerCost) {
        this.flowerCost = flowerCost;
    }

    /**
     * Метод позволяет сравнить на идентичность текущий объект класса цветок с переданным для сравнения
     * @param obj параметр содержит объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Flower)) return false;

        Flower flower = (Flower) obj;

        if (this.flowerCode != flower.flowerCode) return false;
        if (this.flowerCategory != flower.flowerCategory) return false;
        if (!this.flowerCategoryName.equals(flower.flowerCategoryName)) return false;
        if (this.flowerColor != flower.flowerColor) return false;
        if (!this.flowerColorName.equals(flower.flowerColorName)) return false;
        if (!this.flowerName.equals(flower.flowerName)) return false;
        if (this.flowerCost != flower.flowerCost) return false;

        return true;
    }

    /**
     * Метод возвращает информацию об объекте класса цветок
     * @return содержит подробную информацию о текущем объекте
     */
    @Override
    public String toString() {
        return getClass().getName() + " "
                + "Code: " + getFlowerCode()
                + " Категория и цвет: " + getFlowerName() + " (" + getFlowerColorName()+ ")"
                + " Цена:" + getFlowerCost();
    }


    /**
     * Метод генерирует HashCode объекта цветок
     * @return возвращает HashCode объекта цветок
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (flowerCost != +0.0f ? Float.floatToIntBits(flowerCost) : 0);
        return result;
    }

    /**
     * Переопределенный метод для сравнения стоимости текущего объекта цветок
     * со стоимостью объекта цветок переданного для сравнения
     * @param obj содержит объект для сравнения с текущим объектом
     * @return возвращает результат сравнения стоимости цветов
     */
    @Override
    public int compareTo(Flower obj) {
        return Float.compare(this.flowerCost, obj.flowerCost);
    }

}
