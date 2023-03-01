package Kursovoy_OOP;

import java.util.Scanner;

public class Main {
    static int os=0;
    public static void main(String[] args) {
        outputMenu();
        inputMenu(input());
    }
    public static int input() {
        Scanner in = new Scanner(System.in);
        int os = 0;
        os = in.nextInt();
        return os;
    }
    public static void outputMenu() {
        System.out.print(
                "************************* МЕНЮ **********************:\n" +
                        "Выберете из данного меню цифру \n"+
                        "0.- выход\n"+
                        "1.- заносить задачи\n"+
                        "2.- удалять задачи\n"+
                        "3.- получать список задач на предстоящий день\n"+
                        "**********************************************************\n"+
                        "-Введите число, соответствующее ответу: "
        );
    }
    public static void inputMenu(int i) {
        switch (i) {
            case 0:
                System.out.println("Вы передумали?\n");
                break;
            case 1:
                System.out.println("Вы выбрали- заносить задачи\n");
                break;
            case 2:
                System.out.println("Вы выбрали- удалять задачи\n");
                break;
            case 3:
                System.out.println("Вы выбрали- получать список задач на предстоящий день\n");
                outputMenuPeriod();
                inputMenuPeriod(input());
                break;
            default:
                System.out.println("Вы ввели не верное число ");
        }
    }
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
                System.out.println("Вы передумали?\n");
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