package Kursovoy_OOP;

import java.util.Scanner;
public class Main {
    static Scanner in = new Scanner(System.in);
    static int os=0;
    public static Scanner scanner;

    public static void main(String[] args) {
        outputMenu();
        inputMenu(inputRestriction(0, 3));
    }
    public static int inputInt() {
        os = in.nextInt();
        return os;
    }

    public static int inputRestriction(int min, int max) {
        while (true) {
            if (in.hasNextLine()) {
                int number = inputInt();
                if (number >= min && number <= max) {
                    return number;
                }
                in.nextLine();
                System.out.print("Введите число от " + min + " до " + max + " : ");
            }
        }
    }

    public static void outputMenu() {
        System.out.print(
                "************************* МЕНЮ **********************:\n" +
                        "Выберете из данного меню цифру \n"+
                        "0.- выход\n"+
                        "1.- добавить задачи\n"+
                        "2.- удалять задачи\n"+
                        "3.- получать список задач на предстоящий день\n"+
                        "**********************************************************\n"+
                        "-Введите число, соответствующее ответу: "
        );
    }
    public static void inputMenu(int menu) {
        //try (Scanner in = new Scanner(System.in)) {
            Label:
           // while (true) {
                //outputMenu();
               // if (scanner.hasNextInt()) {

                    switch (menu) {
                        case 0:
                            System.out.println("Выход\n");
                            break;
                        case 1:
                            System.out.println("Вы выбрали- добавить задачи : ");
                            TaskService.addTask(scanner);
                            break;
                        case 2:
                            System.out.println("Вы выбрали- удалять задачи\n");
                            break;
                        case 3:
                            System.out.println("Вы выбрали- получать список задач на предстоящий день\n");
                            outputMenuPeriod();
                            inputMenuPeriod(inputRestriction(0, 5));
                            break;
                        default:
                            System.out.println("Вы ввели не верное число ");
//                            break Label;
                    }
               // } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка.");
                }
            //}
        //}
    //}
    public static void outputMenuPeriod() {
        System.out.print(
                "************************* МЕНЮ **********************:\n" +
                        "Выберете из данного меню цифру \n"+
                        "0.- выход\n"+
                        "1.- однократная задача\n"+
                        "2.- ежедневная задача\n"+
                        "3.- еженедельная задача\n"+
                        "4.- ежемесячная задача\n"+
                        "5.- ежегодная задача\n"+
                        "**********************************************************\n"+
                        "-Введите число, соответствующее ответу: "
        );
    }
    public static void inputMenuPeriod(int i) {
        switch (i) {
            case 0:
                System.out.println("Выход?\n");
                break;
            case 1:
                System.out.println("Вы выбрали-однократная \n");
                break;
            case 2:
                System.out.println("Вы выбрали- ежедневная\n");
                break;
            case 3:
                System.out.println("Вы выбрали- еженедельная\n");
            case 4:
                System.out.println("Вы выбрали- ежемесячная\n");
                break;
            case 5:
                System.out.println("Вы выбрали- ежегодная\n");
                break;
            default:
                System.out.println("Вы ввели не верное число ");
        }
    }

}