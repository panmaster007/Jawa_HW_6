import java.util.*;
// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
// Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки,
// отвечающие фильтру.

public class Task1 {
 
    public static void main(String[] args) {
        Map<String, String> crete_map;
        System.out.println();
        Catalog nout_1 = new Catalog("Asus MateBook 2021", 8, 1024, "Windows 11", "серебристый");
        Catalog nout_2 = new Catalog("Xiaomi SuperBook 13", 8, 512, "Windows 11 Home", "синий");
        Catalog nout_3 = new Catalog("Huawei Laptop 16", 16, 256, "DOS", "серебристый");
        Catalog nout_4 = new Catalog("Xiaomi RedmiBook 15", 8, 512, "Windows 11 Home", "синий");
        Catalog nout_5 = new Catalog("Apple Makbook Pro", 4, 1024, "DOS", "черный");
        ArrayList noutList = new ArrayList<>();
        noutList.add(nout_1);
        noutList.add(nout_2);
        noutList.add(nout_3);
        noutList.add(nout_4);
        noutList.add(nout_5);

        System.out.println("В наличии следующие ноутбуки: ---------------------------");
        for (var nout : noutList) {
            System.out.println(nout);
        }
        System.out.println();
        crete_map = FindPar();
        FindList(crete_map, noutList);
    }
    static void FindList(Map<String, String> crete_map, ArrayList<Catalog> n_list) {
        ArrayList<Catalog> finalRes = new ArrayList<>();
        System.out.println();
        for (var nout : n_list) {
            if ((crete_map.containsKey("ram")) &&
                    (nout.getRam() < Integer.parseInt(crete_map.get("ram")))) {
                nout.setName("");
            }
            if ((crete_map.containsKey("hd")) &&
                    (nout.getHd() < Integer.parseInt(crete_map.get("hd")))) {
                nout.setName("");
            }

            if ((crete_map.containsKey("os")) &&
                    (!nout.getOs().equals(crete_map.get("os")))) {
                nout.setName("");
            }
            if ((crete_map.containsKey("color")) &&
                    (!nout.getColor().equals(crete_map.get("color")))) {
                nout.setName("");
            }

        }
        for (var i : n_list) {
            if (!i.getName().equals("")) {
                finalRes.add(i);
            }
            System.out.println();
        }
        if (finalRes.size() > 0) {
            System.out.println();
            System.out.println("Выбранным характерстикам соответствуют: ");

            for (var item : finalRes) {
                System.out.println(item);
            }
            System.out.println();
        } else {
            System.out.println("Согласно выбранным параметрам ничего не найдено");
        }

    }
    static Map<String, String> FindPar() {
        String color = "";
        String choice = "";
        String os = "";

        Boolean getOut = false;

        Map<String, String> str = new HashMap<>(); 
        Scanner scan = new Scanner(System.in);
        while (!getOut) {
            System.out.println();
            System.out.println("Введите цифру, соответствующую необходимой характеристике: ");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("Enter - вывод поиска");

            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("Введите минимальный объем ОЗУ в мегабайтах: ");
                    str.put("ram", scan.nextLine());
                    System.out.println("Выбрано: от " + str.get("ram") + " мегабайт ОЗУ");
                    break;
                }
                case "2": {
                    System.out.println("Введите минимальный объем диска в гигабайтах: ");
                    str.put("hd", scan.nextLine());
                    System.out.println("Выбрано: диск от " + str.get("hd") + " гигабайт");
                    System.out.println();
                    break;
                }
                case "3": {
                    System.out.println("Введите название операционной системы ");
                    System.out.println("Доступны следующие ОС:");
                    System.out.println("1 - Windows 11");
                    System.out.println("2 - Windows 11 Home");
                    System.out.println("3 - DOS");
                    System.out.println("Введите соответствующую цвету цифру: ");
                    choice = scan.nextLine();
                    switch (choice) {
                        case "1": {
                            os = "Windows 11";
                            break;
                        }
                        case "2": {
                            os = "Windows 11 Home";
                            break;
                        }
                        case "3": {
                            os = "DOS";
                            break;
                        }

                        default:
                            break;
                    }
                    str.put("os", os);
                    System.out.println("Выбрано: " + str.get("os"));
                    break;
                }
                case "4": {
                    System.out.println("Введите цвет ноутбука. ");
                    System.out.println("Доступны следующие цвета:");
                    System.out.println("1 - белый");
                    System.out.println("2 - серый");
                    System.out.println("3 - серебристый");
                    System.out.println("4 - черный");
                    System.out.println("5 - синий");
                    System.out.println("Введите соответствующую цвету цифру: ");
                    String colorNum = scan.nextLine();
                    switch (colorNum) {
                        case "1": {
                            color = "белый";
                            break;
                        }
                        case "2": {
                            color = "серый";
                            break;
                        }
                        case "3": {
                            color = "серебристый";
                            break;
                        }
                        case "4": {
                            color = "черный";
                            break;
                        }
                        case "5": {
                            color = "синий";
                            break;
                        }
                        default:
                            break;
                    }
                    str.put("color", color);
                    System.out.println("Выбрано: " + str.get("color"));
                    break;
                }
                case "": {
                    getOut = true;

                    System.out.println(str);
                    break;
                }
                default: {
                    System.out.println("Ошибка, попробуйте еще раз.");
                }
            }
        }
        System.out.println("Выбранные критерии поиска:");
        System.out.println(str);
        return str;
    }
}