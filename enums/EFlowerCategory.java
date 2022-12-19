package com.epam.java.education.lesson_1.enums;

/**
 * Перечисление категорий цветов
 */
public enum EFlowerCategory {
    ROSE(0), // Роза
    LILIA(1), // Лилия
    FIALKA(2), // Фиалка
    ASTRA(3), // Астра
    OTHER_CATEGORY(4); // Прочая категория

    private int index;

    EFlowerCategory (int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    /**
     * Метод возвращает имя категории цветов
     * @param fc параметр содержит константу по которой надо вернуть имя категории
     * @return возвращает имя категории цветов
     */
    public static String getNameByCategory(EFlowerCategory fc) {
        String nameCategory = "Не определена";

        switch (fc) {
            case ROSE:
                nameCategory = "Роза";
                break;
            case LILIA:
                nameCategory = "Лилия";
                break;
            case FIALKA:
                nameCategory = "Фиалка";
                break;
            case ASTRA:
                nameCategory = "Астра";
                break;
            case OTHER_CATEGORY:
                nameCategory = "Прочие цветы";
                break;
            default:
        }

        return nameCategory;
    }

}
