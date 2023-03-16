package Kursovoy_OOP;
import Kursovoy_OOP.Exception.TaskNotFoundException;
import Kursovoy_OOP.Period.*;
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
            System.out.print("Для дальнейшей работы нажмите  - Enter.");
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

    private static Repeatable createTask(int checkingAppearance, String titleTask, String descriptionTask, String typeTask, LocalDateTime localDateTime) throws TaskNotFoundException {
//        switch (checkingAppearance) {
//                case 0:
//                    System.out.println("Выход?\n");
//                    break;
//                case 1-> {
//                    System.out.println("Вы выбрали-однократная \n");
//                    OneTimeTask oneTimeTask = new OneTimeTask(titleTask, descriptionTask, typeTask, localDateTime);
//                    activeTask.put(oneTimeTask.getId(), oneTimeTask);
//                    //yield oneTimeTask;
//                    break;
//                }
//                case 2:
//                        System.out.println("Вы выбрали-однократная \n");
//                    DailyTask dailyTask = new DailyTask(titleTask, descriptionTask, typeTask, localDateTime);
//                    activeTask.put(dailyTask.getId(), dailyTask);
//                    //yield dailyTask;
//                    break;
//
//                case 3:
//                    System.out.println("Вы выбрали- еженедельная\n");
//                    WeeklyTask weeklyTask = new WeeklyTask(titleTask, descriptionTask, typeTask, localDateTime);
//                    activeTask.put(weeklyTask.getId(), weeklyTask);
//                    //yield dailyTask;
//                    break;
//                case 4:
//                    System.out.println("Вы выбрали- ежемесячная\n");
//                    MonthlyTask monthlyTask = new MonthlyTask(titleTask, descriptionTask, typeTask, localDateTime);
//                    activeTask.put(monthlyTask.getId(), monthlyTask);
//                    //yield dailyTask;
//                    break;
//                case 5:
//                    System.out.println("Вы выбрали- ежегодная\n");
//                    YearlyTask yearlyTask = new YearlyTask(titleTask, descriptionTask, typeTask, localDateTime);
//                    activeTask.put(yearlyTask.getId(), yearlyTask);
//                    //yield dailyTask;
//                    break;
//                default:
//                    System.out.println("Вы ввели неверное число ");
//                    break;
//           }
       return null;
    }
    public static void deleteTask(Scanner scanner1) {
        System.out.println("Текущие задачи");
        printActualTask();
        System.out.print("Для удаления введите ID задачи");
        int id = scanner1.nextInt();
        if (activeTask.containsKey(id)) {
            Repeatable removedTask = activeTask.get(id);
            removedTask.setArchived(true);
            activeTask.put(id, removedTask);
            System.out.println("Задача" + id + "удалена");
        } else {
            System.out.println("Такой задачи не существует");
        }
    }

    public static String receiveTask(String task) {
        return  task;
    }
    public static void printActualTask() {
        for (Repeatable task : activeTask.values()) {
            System.out.println(task);
        }
    }
}
