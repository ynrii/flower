package com.epam.java.education.lesson_1.enums;

/**
 * Перечисление для цветовых оттенков
 */
public enum EFlowerColor {
    WHITE(0), // Белый
    BLACK(1), // Черный
    RED(2), // Красный
    YELLOW(3), // Желтый
    OTHER_COLOR(4); // Другой цвет

    private int index;

    EFlowerColor (int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    /**
     * Метод возвращает имя цвета
     * @param fc параметр содержит константу по которой надо вернуть имя цвета
     * @return возвращает имя цвета
     */
    public static String getColorNameByColor(EFlowerColor fc) {
        String nameColor = "Не определен";

        switch (fc) {
            case WHITE:
                nameColor = "Белый";
                break;
            case BLACK:
                nameColor = "Черный";
                break;
            case RED:
                nameColor = "Красный";
                break;
            case YELLOW:
                nameColor = "Желтый";
                break;
            case OTHER_COLOR:
                nameColor = "Прочие цвета";
                break;
            default:
        }

        return nameColor;
    }

}
