package com.epam.java.education.lesson_1.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс содержит реализацию для объекта букет цветов
 */
public class FlowersBouquet implements Comparable <FlowersBouquet> {

    // Код букета цветов
    private int flowersBouquetCode;

    // список цветов в букете
    private List<Flower> flowersBouquetList = new ArrayList<Flower>();

    // стоимсоть букета цветов
    private float fullCost = 0.00f;

    /**
     * Конструктор по умолчанию
     */
    public FlowersBouquet() {
    }

    /**
     * Конструктор для создания объекта букет цветов
     * @param flowersBouquetCode содержит код букета цветов
     */
    public FlowersBouquet(int flowersBouquetCode) {
        this.flowersBouquetCode = flowersBouquetCode;
    }

    /**
     * Конструктор для создания объекта букет цветов
     * @param flowersBouquetCode содержит код букета цветов
     * @param fbl                содержит список цветов в букете
     */
    public FlowersBouquet(int flowersBouquetCode, List<Flower> fbl) {
        this.flowersBouquetCode = flowersBouquetCode;
        this.flowersBouquetList = fbl;
    }

    /**
     * Метод возвращает список объектов цветов в букете
     * @return возвращает список цветов в букете
     */
    public List<Flower> getFlowersBouquetList() {
        return flowersBouquetList;
    }

    /**
     * Метод загружает в букет новый список объектов цветов
     * @param fal параметр содержит список объектов цветов
     */
    public void setFlowersBouquetList(List<Flower> fal) {
        this.flowersBouquetList = fal;
    }

    /**
     * Метод добавляет цветок к букету
     * @param flw содержит объект цветок который будет добавлен к букету
     */
    public void addFlower(Flower flw) {
        flowersBouquetList.add(flw);
        calculateBouquetCost();
    }

    /**
     * Метод удаляет объект цветок из букета по индексу в списке
     * @param indexFlower содержит значение индекса объекта в списке который будет удален
     */
    public void removeFlower(int indexFlower) {
        flowersBouquetList.remove(indexFlower);
        calculateBouquetCost();
    }

    /**
     * Метод подсчитывает стоимость букета
     */
    public void calculateBouquetCost() {
        float tmpCost = 0.00f;

        if (flowersBouquetList.size() > 0) {
            for (Flower flower : flowersBouquetList) {
                tmpCost += flower.getFlowerCost();
            }
        }

        this.fullCost = tmpCost;
    }

    /**
     * Метод возвращает объект цветок из корзины по индексу в списке
     * @param itemIndex содержит значение индекса в списке
     * @return твозвращает объект цветок
     */
    public Flower getFlowerByItemIndex(int itemIndex) {
        return flowersBouquetList.get(itemIndex);
    }

    /**
     * Метод возвращает количество объектов цветов в букете
     * @return количество цветов в букете
     */
    public int getFlowersBouquetCount() {

        return this.flowersBouquetList.size();
    }

    /**
     * Метод возвращает стоимость букета
     * @return возвращает стоимость букета
     */
    public float getFullCost() {
        return fullCost;
    }

    public int getFlowersBouquetCode() {
        return flowersBouquetCode;
    }

    public void setFlowersBouquetCode(int flowersBouquetCode) {
        this.flowersBouquetCode = flowersBouquetCode;
    }

    /**
     * Переопределенный метод для сравнения стоимости букета текущего объекта
     * со стоимостью букета объекта переданного для сравнения
     * @param obj содержит объект для сравнения с текущим объектом
     * @return возвращает результат сравнения стоимости корзин
     */
    @Override
    public int compareTo(FlowersBouquet obj) {
        return Float.compare(this.fullCost, obj.fullCost);
    }

    @Override
    public String toString() {
        return getClass().getName()
                + " Code: " + getFlowersBouquetCode()
                + " Количество цветов в букете: " + getFlowersBouquetCount()
                + " Общая стоимость цветов в букете: " + getFullCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlowersBouquet)) return false;

        FlowersBouquet that = (FlowersBouquet) o;

        if (flowersBouquetCode != that.flowersBouquetCode) return false;
        if (Float.compare(that.fullCost, fullCost) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flowersBouquetCode;
        result = 31 * result + (fullCost != +0.0f ? Float.floatToIntBits(fullCost) : 0);
        return result;
    }

    public void printFlowersFromBouquet() {
        StringBuilder printInfo = new StringBuilder().append("\nСписок цветов в букете № " + this.getFlowersBouquetCode() + ": ");

        for (Flower flower : this.flowersBouquetList) {
            printInfo.append("\nCode: " + flower.getFlowerCode())
                    .append(" Категория и цвет: " + flower.getFlowerName() + " (" + flower.getFlowerColorName()+ ")")
                    .append(" Цена:" + flower.getFlowerCost() + "\n");
        }

        System.out.println(printInfo);
    }
}