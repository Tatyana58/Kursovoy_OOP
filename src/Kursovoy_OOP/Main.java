package Kursovoy_OOP;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    static int os=0;
    public static void main(String[] args) {
       outputMenu();
       inputMenu();
    }
    public static void outputMenu() {
        System.out.print(
                "************************* МЕНЮ **********************:\n" +
                        "Выберете из данного меню цифру \n"+
                        "0.- выход\n"+
                        "1.- добавить задачи\n"+
                        "2.- удалять задачи\n"+
                        "3.- получать список задач на день\n"+
                        "4.- редактировать задачу\n"+
                        "**********************************************************\n"+
                        "-Введите число из меню : "
        );
    }

    public static void inputMenu() {
        if (scanner.hasNextInt()) {
            int menu = scanner.nextInt();
            switch (menu) {
                case 0:
                    System.out.println("Выход\n");
                    break;
                case 1:
                    System.out.println("Вы выбрали- добавить задачи : ");
                    TaskService.addTask(scanner);
                    outputMenu();
                    inputMenu();
                    break;
                case 2:
                    System.out.println("Вы выбрали- удалять задачи\n");
                    TaskService.deleteTask(scanner);
                    outputMenu();
                    inputMenu();
                    break;
                case 3:
                    System.out.println("Вы выбрали- получать список задач на день\n");
                    TaskService.getReceiveTaskDay(scanner);
                    outputMenu();
                    inputMenu();
                    break;
                case 4:
                    System.out.println("Вы выбрали- редактировать задачу\n");
                    TaskService.editTask(scanner);
                    outputMenu();
                    inputMenu();
                    break;
                default:
                    System.out.println("Вы ввели не верное число. Повторите ввод. ");
                    System.out.println("Выберите пункт меню из списка.");
                    outputMenu();
                    inputMenu();
                    break;
            }
        }
    }
}