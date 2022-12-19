package com.epam.java.education.lesson_1.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс корзина цветов, который используется для формирования букетов цветов
 */
public class FlowersBasket implements Comparable <FlowersBasket> {

    // Код корзины цветов
    private int flowersBasketCode;

    // Наименование корзины цветов
    private String flowersBasketName;

    // список цветов в корзине
    private List<Flower> flowersBasketList = new ArrayList<Flower>();

    // стоимость цветов в корзине
    private float fullCost = 0.00f;

    /**
     * Конструктор по умолчанию
     */
    public FlowersBasket() {
    }

    /**
     * Конструктор для создания объекта корзина цветов
     * @param flowersBasketCode содержит код корзины
     * @param flowersBasketName содержит наименование корзины
     */
    public FlowersBasket(int flowersBasketCode, String flowersBasketName) {
        this.flowersBasketCode = flowersBasketCode;
        this.flowersBasketName = flowersBasketName;
    }

    /**
     * Конструктор для создания объекта корзина цветов
     * @param flowersBasketCode содержит код корзины
     * @param flowersBasketName содержит наименование корзины
     * @param fbl содержит список цветов в корзине
     */
    public FlowersBasket(int flowersBasketCode, String flowersBasketName, List<Flower> fbl) {
        this.flowersBasketList = fbl;
        this.flowersBasketCode = flowersBasketCode;
        this.flowersBasketName = flowersBasketName;
    }

    /**
     * Метод возвращает список объектов цветов в корзине
     * @return возвращает массив объектов цветов, которые содержатся в корзине цветов
     */
    public List<Flower> getFlowersBasketList() {
        return flowersBasketList;
    }

    /**
     * Метод загружает в корзину новый список объектов цветов
     * @param fal параметр содержит список объектов цветов
     */
    public void setFlowerBasketList(List<Flower> fal) {
        this.flowersBasketList = fal;
    }

    /**
     * Метод добавляет цветок в корзину
     * @param flw содержит объект цветок который будет добавлен в корзину
     */
    public void addFlower(Flower flw) {
        flowersBasketList.add(flw);

        calculateBasketCost();
    }

    /**
     * Метод удаляет объект цветок из корзины по индексу в списке
     * @param indexFlower содержит значение индекса объекта в списке который будет удален
     */
    public void removeFlower(int indexFlower) {
        flowersBasketList.remove(indexFlower);

        calculateBasketCost();
    }

    /**
     * Метод возвращает объект цветок из корзины по индексу в списке
     * @param itemIndex содержит значение индекса в списке
     * @return твозвращает объект цветок
     */
    public Flower getFlowerByItemIndex(int itemIndex) {
        return flowersBasketList.get(itemIndex);
    }

    /**
     * Метод подсчитывает общую стоимость цветов в корзине
     */
    public void calculateBasketCost() {
        float tmpCost = 0.00f;

        if (flowersBasketList.size() > 0) {
            for (Flower flower : flowersBasketList) {
                tmpCost += flower.getFlowerCost();
            }
        }

        this.fullCost = tmpCost;
    }

    /**
     * Метод возвращает количество объектов цветов в корзине
     * @return возвращает количество цветов в корзине
     */
    public int getFlowersBasketCount() {
        return this.flowersBasketList.size();
    }

    /**
     * Метод возвращает стоимость цветов в корзине
     * @return возвращает стоимость цветов в корзине
     */
    public float getFullCost() {
        return fullCost;
    }

    /**
     * Переопределенный метод для сравнения стоимости корзины текущего объекта
     * со стоимостью корзины объекта переданного для сравнения
     * @param obj содержит объект для сравнения с текущим объектом
     * @return возвращает результат сравнения стоимости корзин
     */
    @Override
    public int compareTo(FlowersBasket obj) {
        return Float.compare(this.fullCost, obj.fullCost);
    }

    public String getFlowersBasketName() {
        return flowersBasketName;
    }

    public void setFlowersBasketName(String flowersBasketName) {
        this.flowersBasketName = flowersBasketName;
    }

    public int getFlowersBasketCode() {
        return flowersBasketCode;
    }

    public void setFlowersBasketCode(int flowersBasketCode) {
        this.flowersBasketCode = flowersBasketCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlowersBasket)) return false;

        FlowersBasket that = (FlowersBasket) o;

        if (flowersBasketCode != that.flowersBasketCode) return false;
        if (Float.compare(that.fullCost, fullCost) != 0) return false;
        if (!flowersBasketName.equals(that.flowersBasketName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flowersBasketCode;
        result = 31 * result + flowersBasketName.hashCode();
        result = 31 * result + (fullCost != +0.0f ? Float.floatToIntBits(fullCost) : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + " Code: " + getFlowersBasketCode()
                + " Наименование корзины: " + getFlowersBasketName()
                + " Количество цветов в корзине: " + getFlowersBasketCount()
                + " Общая стоимость цветов в корзине: " + getFullCost();
    }

    public void printFlowersFromBasket() {
        StringBuilder printInfo = new StringBuilder();

        printInfo.append("Список цветов в корзине " + getFlowersBasketName() + ": \n");
        for (Flower flower : this.flowersBasketList) {
            printInfo.append("Code: " + flower.getFlowerCode())
                    .append(" Категория и цвет: " + flower.getFlowerName() + " (" + flower.getFlowerColorName() + ")")
                    .append(" Цена:" + flower.getFlowerCost() + "\n");
        }

        System.out.println(printInfo);
    }
}
