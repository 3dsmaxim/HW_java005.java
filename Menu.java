import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    public static void addText(HashMap<String, String> numList) {
        try (FileWriter fw = new FileWriter("FoneBook.java", false)) {
            fw.write("import java.util.HashMap;");
            fw.append('\n');
            fw.append('\n');
            fw.append("public class FoneBook {");
            fw.append('\n');
            fw.append("    public static HashMap<String, String> numberList() {");
            fw.append('\n');
            fw.append('\n');
            fw.write("        HashMap<String, String> numberList = new HashMap<>();");
            fw.append('\n');
            for (var item : numList.entrySet()) {
                fw.write("        numberList.put(\"" + item.getKey() + "\", \"" + item.getValue() + "\");");

                fw.append('\n');
            }
            fw.append('\n');
            fw.write("        return numberList;");
            fw.append('\n');
            fw.append('\n');
            fw.write("    }");
            fw.append('\n');
            fw.append('\n');
            fw.write("}");

            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void DelitFoneList(ArrayList<String> numList) {

    }

    public static void Men(HashMap<String, String> numberList) {

        HashMap<String, String> menuList = new HashMap<>();
        menuList.put("1", "Все телефоны");
        menuList.put("2", "Найти телефоны по имени");
        menuList.put("3", "Добавить телефон");
        menuList.put("4", "Удалить телефон");
        menuList.put("5", "Удалить абонента");
        menuList.put("6", "Выйти");

        // HashMap<String, String> numberList = new HashMap<>();
        // numberList.put("89652220014", "Ivan");
        // numberList.put("89652221124", "Koly");
        // numberList.put("89652221112", "Serj");
        // numberList.put("89652221122", "Kate");
        // numberList.put("89652221223", "Serj");
        // numberList.put("89652221113", "Ivan");

        for (var item : menuList.entrySet()) {

            System.out.printf("%s   %s \n", item.getKey(), item.getValue());
        }

        System.out.print("Выберети действие из списка:  ");
        Scanner scan = new Scanner(System.in);
        var numEnter = scan.nextLine();

        switch (numEnter) {
            case "1":
                System.out.println();
                StringBuilder prinList = new StringBuilder();
                LinkedList<String> prinListChek = new LinkedList<>();

                int count = 0;
                for (var items : numberList.entrySet()) {
                    count = 0;
                    for (int i = 0; i < prinListChek.size(); i++) {
                        if (prinListChek.get(i) == items.getValue()) {
                            count++;
                        }
                    }

                    if (count == 0) {
                        prinList.append(items.getValue());
                        prinListChek.add(items.getValue());
                        for (var item : numberList.entrySet()) {
                            if (items.getValue() == item.getValue()) {
                                prinList.append(" ");
                                prinList.append(item.getKey());
                            }
                        }

                        prinList.append("\n");
                    }

                }
                System.out.println(prinList);
                Men(numberList);

                break;
            case "2":
                System.out.println();
                StringBuilder prinListTwo = new StringBuilder();
                System.out.print("Введите имя: ");
                String namFindNum = scan.nextLine();

                for (var items : numberList.entrySet()) {

                    if (items.getValue().equalsIgnoreCase(namFindNum)) {

                        prinListTwo.append(items.getValue());
                        for (var item : numberList.entrySet()) {

                            if (items.getValue() == item.getValue()) {

                                prinListTwo.append(" ");
                                prinListTwo.append(item.getKey());

                            }
                        }

                        break;

                    }

                }
                System.out.println(prinListTwo);
                System.out.println();
                Men(numberList);
                break;
            case "3":
                System.out.println();
                System.out.print("Введите имя: ");
                String name = scan.nextLine();
                System.out.print("Введите телефон: ");
                String fone = scan.nextLine();

                numberList.put(fone, name);
                addText(numberList);

                Men(numberList);
                numberList = FoneBook.numberList();

                break;
            case "4":
                System.out.println();
                System.out.print("Введите имя абонента: ");
                try {

                    String name2 = scan.nextLine();

                    ArrayList<String> delitFon = new ArrayList<>();

                    for (var items : numberList.entrySet()) {

                        if (items.getValue().equalsIgnoreCase(name2)) {

                            delitFon.add(items.getValue());
                            for (var item : numberList.entrySet()) {

                                if (items.getValue() == item.getValue()) {

                                    delitFon.add(item.getKey());

                                }
                            }
                            break;

                        }
                    }
                    System.out.println(delitFon.get(0));
                    for (int i = 1; i < delitFon.size(); i++) {
                        System.out.println(i + " " + delitFon.get(i));

                    }
                    System.out.print("Выберите телефон который необходимо удалить ");
                    int fone2 = scan.nextInt();
                    numberList.remove(delitFon.get(fone2));

                    addText(numberList);

                    Men(numberList);
                    numberList = FoneBook.numberList();

                    break;
                } catch (Exception e) {
                    System.out.println();
                    System.out.println("!!!!!-Такого абонента нет-!!!!");
                    System.out.println();
                    Men(numberList);
                }
                break;
            case "5":
                System.out.println();
                System.out.print("Введите имя абонента: ");
                String name3 = scan.nextLine();
                try {

                    ArrayList<String> delitFon2 = new ArrayList<>();

                    for (var items : numberList.entrySet()) {

                        if (items.getValue().equalsIgnoreCase(name3)) {

                            delitFon2.add(items.getValue());
                            for (var item : numberList.entrySet()) {

                                if (items.getValue() == item.getValue()) {

                                    delitFon2.add(item.getKey());

                                }
                            }
                            break;

                        }
                    }
                    System.out.println(delitFon2.get(0));
                    for (int i = 1; i < delitFon2.size(); i++) {
                        numberList.remove(delitFon2.get(i));

                    }

                    addText(numberList);

                    Men(numberList);
                    numberList = FoneBook.numberList();

                    break;
                } catch (Exception e) {
                    System.out.println();
                    System.out.println("!!!!!-Такого абонента нет-!!!!");
                    System.out.println();
                    Men(numberList);
                }
                break;

            default:
                break;
        }

    }

}