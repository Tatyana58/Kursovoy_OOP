package Kursovoy_OOP;
import Kursovoy_OOP.Exception.TaskNotFoundException;
import Kursovoy_OOP.Period.DailyTask;
import Kursovoy_OOP.Period.OneTimeTask;
import Kursovoy_OOP.Utilite.ValidateUtils;
import java.lang.invoke.WrongMethodTypeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskService {
    private static final Map<Integer, Repeatable> activeTask = new HashMap<>();
    public static void addTask(Scanner scanner) {
        Scanner scanner1 = new Scanner(System.in);
        try {
            System.out.print("Введите название задачи : ");
            String titleTask = ValidateUtils.checkingString(scanner1.nextLine());
            System.out.print("Введите описание задачи : ");
            String descriptionTask = ValidateUtils.checkingString(scanner1.nextLine());
            System.out.println("Выберите тип задачи : 0 - рабочая, 1 - личная.");
            String typeTask = String.valueOf(Type.values()[scanner1.nextInt()]);
            System.out.println("Введите повторяемость задачи : 0 - однократная, 1 - ежедневная, 2 - еженедельная, 3 - ежемесячная, 4 - ежегодная");
            int appearance = scanner1.nextInt();
            System.out.println("Введите дату dd.MM.yyyy HH.mm");
            scanner1.nextLine();
            createEvent(scanner, titleTask, descriptionTask, typeTask, appearance);
            System.out.print("Для выхода нажмите  - Enter.");
            scanner1.nextLine();
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createEvent(Scanner scanner, String titleTask, String descriptionTask, String typeTask, int appearance) {
        try {
            LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm"));
            Repeatable task = null;
            try {
                task = createTask(appearance, titleTask, descriptionTask, typeTask, eventDate);
                System.out.println("Задача создана. " + task);
            } catch (WrongMethodTypeException e) {
                System.out.println(e.getMessage());
            }
        } catch (DateTimeParseException e) {
            System.out.println("Проверь формат даты dd.MM.yyyy HH.mm");
            createEvent(scanner, titleTask, descriptionTask, typeTask, appearance);
        }
    }

    private static <yield> Repeatable createTask(int appearance, String titleTask, String descriptionTask, String typeTask, LocalDateTime eventDate) throws TaskNotFoundException {
//        switch (appearance) {
//                case 0:
//                    System.out.println("Выход?\n");
//                    break;
//                case 1->{
//                    System.out.println("Вы выбрали-однократная \n");
//                    OneTimeTask oneTimeTask = new OneTimeTask(titleTask,descriptionTask,typeTask,LocalDateTime);
//                    activeTask.put(oneTimeTask.getId(), oneTimeTask);
//                    yield oneTimeTask;
//                }
//                case 2->{
//                        System.out.println("Вы выбрали-однократная \n");
//                    DailyTask dailyTask = new DailyTask(titleTask, descriptionTask, typeTask, LocalDateTime);
//                    activeTask.put(dailyTask.getId(), dailyTask);
//                    yield dailyTask;
//                }
//                case 3:
//                    System.out.println("Вы выбрали- еженедельная\n");
//                case 4:
//                    System.out.println("Вы выбрали- ежемесячная\n");
//                    break;
//                case 5:
//                    System.out.println("Вы выбрали- ежегодная\n");
//                    break;
//                default:
//                    System.out.println("Вы ввели не верное число ");
//            }
//
       return null;
    }
    public static String deleteTask(String task) {
        return task;
    }

    public static String receiveTask(String task) {
        return  task;
    }
}
