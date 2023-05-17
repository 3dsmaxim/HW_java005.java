
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.HashMap;

import javax.crypto.NullCipher;

public class HW_java_005 {

    public static void main(String[] args) {
        /*
         * 1. Реализуйте структуру телефонной книги с помощью HashMap,
         * учитывая,
         * что 1 человек может иметь несколько телефонов.
         */

        HashMap<String, String> numberList = FoneBook.numberList();
        Menu.Men(numberList);

        /*
         * 2. Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина
         * Белова,
         * Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр
         * Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина
         * Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
         * Написать программу, которая найдет и выведет повторяющиеся имена с
         * количеством
         * повторений. Отсортировать по убыванию популярности. Для сортировки
         * использовать TreeMap.
         */
        System.out.println();
        String peopleString = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        System.out.println(peopleString);
        TreeMap<String, String> peopleCount = new TreeMap<>();
        peopleString.replace(" ", "");
        String[] peopleArrayNames = peopleString.split(", ");
        peopleString = new String();

        for (String itemString : peopleArrayNames) {
        String[] people3 = itemString.split(" ");
        peopleString = peopleString + people3[0] + " ";
        }

        int count = 0;
        peopleString.trim();
        peopleArrayNames = peopleString.split(" ");

        TreeMap<String, String> replaceKeyValue = new TreeMap<>();
        StringBuilder getString = new StringBuilder();

        for (var itemString : peopleArrayNames) {
        for (var item : peopleArrayNames) {
        if (itemString.equals(item)) {
        count++;
        }
        }
        peopleCount.put(itemString, Integer.toString(count));
        count = 0;
        }

        for (var itemString : peopleCount.entrySet()) {
        // String stringKey = itemString.getKey();
        for (var string : peopleCount.entrySet()) {
        if (itemString.getValue().equals(string.getValue())) {

        getString.append(string.getKey());
        getString.append(", ");
        }

        }
        getString.delete(getString.length() - 2, getString.length() - 1);

        replaceKeyValue.put(itemString.getValue(), getString.toString());
        getString = new StringBuilder();
        }

        System.out.println(peopleCount);
        System.out.println(replaceKeyValue.descendingMap());

        for (var string : replaceKeyValue.descendingMap().entrySet()) {

        System.out.printf("У имени %s колличество повторений равно %s\n",
        string.getValue(), string.getKey());
        }

        /*
         * 3*. Реализовать алгоритм пирамидальной сортировки (HeapSort)
         */

       
        System.out.println();
        TreeMap<Integer, Integer> numbersRandom = new TreeMap<>();
        RandomForMap r = new RandomForMap();
        numbersRandom = r.addRandomNum();

        System.out.println(numbersRandom);

        HeapSort hs = new HeapSort();

        numbersRandom = hs.heapSort(numbersRandom);

        System.out.println(numbersRandom);

        
        /*
         * 4** На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
         */

    }

}
