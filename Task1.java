import java.util.*;
// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
// Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки,
// отвечающие фильтру.

// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook

// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры 
// фильтрации можно также в Map.

// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

// Класс сделать в отдельном файле

// приветствие
// Выбор параметра
// выбор конкретнее
// вывод подходящих

public class Task_01 {
    // Программа реализована на цикле внесения параметров.
    // Внесение одного параметра отбора возвращает программу в меню выбора для внесения других фильтров
    // Переход к фильтрации по критериям - по клавише ввода в том же меню

    // Алгоритм работает следующим образом:
    // - составляется Map-фильтр на основании внесенных пользователем требований;
    // - далее программа перебирает список ноутбуков, находя в экземплярах класса поля,
    //         упомянутые в фильтре, при несоответствии требований в списке-фильтре и списке 
    //         экземпляров имя экземпляра заменяется пустой строкой;
    // - результирующий список ноутбуков заполняется из начального списка, пропуская экземпляры
    //         с пустой строкой вместо названия.

    // ------- основная программа --------
    public static void main(String[] args) {
        Map<String, String> crete_map; // список критериев для отбора
        System.out.println();
        Notebook nout_1 = new Notebook("Huawei MateBook D 14 2021 NbD-WDH9", 8, 1024, "Windows 11", "серебристый");
        Notebook nout_2 = new Notebook("Xiaomi RedmiBook 15 (JYU4525RU)", 8, 512, "Windows 11 Home", "синий");
        Notebook nout_3 = new Notebook("Asus Laptop 15 X515JA-BQ2588", 16, 256, "DOS", "серебристый");
        Notebook nout_4 = new Notebook("Xiaomi RedmiBook 15 (JYU4532RU)", 8, 512, "Windows 11 Home", "синий");
        Notebook nout_5 = new Notebook("Lenovo IdeaPad 3 15IML05 (81WB0072RE)", 4, 1024, "Windows 11 Home", "черный");
        // список ноутбуков в наличии
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

        // ---- вызов меню фильтрации параметров --------
        crete_map = FindPar();
        // ---- вызов метода отсева ноутбуков, не соответствующих фильтрам
        FindList(crete_map, noutList);

    }

    // ----- метод отбора ноутбуков по параметрам -------
    static void FindList(Map<String, String> crete_map, ArrayList<Notebook> n_list) {
        ArrayList<Notebook> finalRes = new ArrayList<>(); // инициализация результирующего списка
        System.out.println();
        // поиск соответствия по параметрам фильтров
        // при несоответствии параметра название ноутбука заменяется на пустую строку
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
        // внесение ноутбуков с непустыми названиями в результирующий список
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
            System.out.println("Соответствий выбранным параметрам не найдено");
        }

    }

    // ----- метод создания списка критериев отбора -----
    static Map<String, String> FindPar() {
        String color = "";
        String choice = "";
        String os = "";

        Boolean getOut = false;

        Map<String, String> str = new HashMap<>(); // список фильтров
        Scanner scan = new Scanner(System.in);
        while (!getOut) {
            System.out.println();
            System.out.println("Введите цифру, соответствующую необходимому критерию: ");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("Enter - вывод полученных результатов");

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
                    System.out.println("Что-то тут не так, попробуйте еще раз.");
                }
            }
        }
        System.out.println("Выбранные критерии поиска:");
        System.out.println(str);
        return str;
    }
}