package com.epam.java.education.lesson_1.classes;

import com.epam.java.education.lesson_1.enums.EFlowerCategory;
import com.epam.java.education.lesson_1.enums.EFlowerColor;
import com.epam.java.education.lesson_1.interfaces.IFlower;

/**
 * Абстрактый класс для наследования объектов Цветок
 */
public abstract class AFlower implements IFlower {
    /**
     * Код цветка
     */
    int flowerCode;
    /**
     * Наименование цветка
     */
    String flowerName;

    /**
     * Цвет цветка
     */
    EFlowerColor flowerColor;
    /**
     * Цвет цветка в текстовом виде
     */
    String flowerColorName;

    /**
     * Категория цветка
     */
    EFlowerCategory flowerCategory;
    /**
     * Категория цветка в текстовом виде
     */
    String flowerCategoryName;

    /**
     * Конструктор по умолчанию
     */
    public AFlower() {
    }

    /**
     * Конструктор для создания объекта цветок
     * @param flowerCode параметр содержит код цветка
     * @param flowerName параметр содержит имя цветка
     * @param flowerColor параметр содержит цвет цветка
     * @param flowerCategory параметр содержит категорию цветка
     */
    public AFlower(int flowerCode, String flowerName, EFlowerColor flowerColor, EFlowerCategory flowerCategory){
        this.flowerCode = flowerCode;
        this.flowerName = flowerName;
        this.flowerColor = flowerColor;
        this.flowerCategory = flowerCategory;
    }

    /**
     * Конструктор для создания объекта цветок
     * @param flowerCode параметр содержит код цветка
     * @param flowerName параметр содержит имя цветка
     * @param flowerColorName параметр содержит имя цвета цветка
     * @param flowerColor параметр содержит цвет цветка
     * @param flowerCategoryName параметр содержит имя категории цветка
     * @param flowerCategory параметр содержит категорию цветка
     */
    public AFlower(int flowerCode, String flowerName,
                   String flowerColorName, EFlowerColor flowerColor,
                   String flowerCategoryName, EFlowerCategory flowerCategory){
        this.flowerCode = flowerCode;
        this.flowerName = flowerName;
        this.flowerColor = flowerColor;
        this.flowerColorName = flowerColorName;
        this.flowerCategory = flowerCategory;
        this.flowerCategoryName = flowerCategoryName;
    }

    /**
     * Возвращает значение кода цветка
     * @return содержит значение кода цветка
     */
    public int getFlowerCode() {
        return flowerCode;
    }

    /**
     * Устанавливает значение кода цветка
     * @param flowerCode содержит значение кода цветка
     */
    public void setFlowerCode(int flowerCode) {
        this.flowerCode = flowerCode;
    }

    /**
     * Возвращает значение имени цветка
     * @return содержит значение имени цветка
     */
    public String getFlowerName() {
        return flowerName;
    }

    /**
     * Устанавливает значение имени цветка
     * @param flowerName содержит значение имени цветка
     */
    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    /**
     * Возвращает значение цвета цветка
     * @return содержит значение цвета цветка
     */
    public EFlowerColor getFlowerColor() {
        return flowerColor;
    }

    /**
     * Устанавливает значение цвета цветка
     * @param flowerColor содержит значение цвета цветка
     */
    public void setFlowerColor(EFlowerColor flowerColor) {
        this.flowerColor = flowerColor;
    }

    /**
     * Возвращает текстовое значение имени цвета цветка
     * @return содержит текстовое значение имени цвета цветка
     */
    public String getFlowerColorName() {
        return flowerColorName;
    }

    /**
     * Устанавливает текстовое значение имени цвета цветка
     * @param flowerColorName содержит текстовое значение имени цвета цветка
     */
    public void setFlowerColorName(String flowerColorName) {
        if (this.flowerColorName == null || this.flowerColorName.isEmpty())
            this.flowerColorName = getColorNameByColor(this.flowerColor);
        else this.flowerColorName = flowerColorName;
    }

    /**
     * Возвращает значение категории цветка
     * @return содержит значение категории цветка
     */
    public EFlowerCategory getFlowerCategory() {
        return flowerCategory;
    }

    /**
     * Устанавливает значение категории цветка
     * @param flowerCategory содержит значение категории цветка
     */
    public void setFlowerCategory(EFlowerCategory flowerCategory) {
        this.flowerCategory = flowerCategory;
    }

    /**
     * Возвращает текстовое значение имени категории цветка
     * @return содержит текстовое значение имени категории цветка
     */
    public String getFlowerCategoryName() {
        return flowerCategoryName;
    }

    /**
     * Устанавливает текстовое значение имени категории цветка
     * @param flowerCategoryName содержит текстовое значение имени категории цветка
     */
    public void setFlowerCategoryName(String flowerCategoryName) {
        if (this.flowerCategoryName == null || this.flowerCategoryName.isEmpty())
            this.flowerCategoryName = getCategoryNameByCategory(this.flowerCategory);
        else this.flowerCategoryName = flowerCategoryName;
    }

    /**
     * Метод может быть переопределен в наследуемых классах
     * Возвращает наименование категории цветка
     * @param fc параметр содержит значение категории цветка
     * @return имя категории цветка которое должен вернуть метод
     */
    public String getCategoryNameByCategory(EFlowerCategory fc) {
        return EFlowerCategory.getNameByCategory(fc);
    }

    /**
     * Метод может быть переопределен в наследуемых классах
     * Возвращает наименование цвета цветка
     * @param fc параметр содержит значение цвета цветка
     * @return имя цвета цветка которое должен вернуть метод
     */
    public String getColorNameByColor(EFlowerColor fc) {
        return EFlowerColor.getColorNameByColor(fc);
    }

    /**
     * Метод позволяет сравнить на идентичность текущий объект класса цветок с переданным для сравнения
     * @param obj параметр содержит объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AFlower)) return false;

        AFlower aFlower = (AFlower) obj;

        if (flowerCode != aFlower.flowerCode) return false;
        if (flowerCategory != aFlower.flowerCategory) return false;
        if (!flowerCategoryName.equals(aFlower.flowerCategoryName)) return false;
        if (flowerColor != aFlower.flowerColor) return false;
        if (!flowerColorName.equals(aFlower.flowerColorName)) return false;
        if (!flowerName.equals(aFlower.flowerName)) return false;

        return true;
    }

    /**
     * Метод генерирует HashCode объекта
     * @return возвращает HashCode объекта
     */
    @Override
    public int hashCode() {
        int result = flowerCode;
        result = 31 * result + flowerName.hashCode();
        result = 31 * result + flowerColor.hashCode();
        result = 31 * result + flowerColorName.hashCode();
        result = 31 * result + flowerCategory.hashCode();
        result = 31 * result + flowerCategoryName.hashCode();
        return result;
    }
}
