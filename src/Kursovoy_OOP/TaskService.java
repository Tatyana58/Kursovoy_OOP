package Kursovoy_OOP;

import Kursovoy_OOP.Exception.TaskNotFoundException;
import Kursovoy_OOP.Period.*;
import Kursovoy_OOP.Utilite.ValidateUtils;

import java.lang.invoke.WrongMethodTypeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskService {
    public static Scanner scanner1 = new Scanner(System.in);
    private static final Map<Integer, Repeatable> activeTask = new HashMap<>();
    public static void addTask(Scanner scanner) {
        try {
            System.out.print("Введите название задачи : ");
            String titleTask = ValidateUtils.checkingString(scanner1.nextLine());
            System.out.print("Введите описание задачи : ");
            String descriptionTask = ValidateUtils.checkingString(scanner1.nextLine());
            System.out.print("Выберите тип задачи : 0 - рабочая, 1 - личная : ");
            Type typeTask = Type.values()[scanner1.nextInt()];
            System.out.print("Введите повторяемость задачи : 0 - однократная, 1 - ежедневная, 2 - еженедельная, 3 - ежемесячная, 4 - ежегодная : ");
            int appearance = scanner1.nextInt();
            System.out.print("Введите дату dd.MM.yyyy HH.mm - ");
            scanner1.nextLine();
            createEvent(scanner1, titleTask, descriptionTask, typeTask, appearance);
            System.out.print("Для дальнейшей работы нажмите  - Enter.");
            scanner1.nextLine();
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createEvent(Scanner scanner1, String titleTask, String descriptionTask, Type typeTask, int appearance) {
        try {
            LocalDateTime eventDate = LocalDateTime.parse(scanner1.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm"));
            Repeatable task = null;
            try {
                task = createTask(appearance, titleTask, descriptionTask, typeTask, eventDate);
                System.out.println("Задача создана. " + task);
                printActualTask();
            } catch (WrongMethodTypeException e) {
                System.out.println(e.getMessage());
            }
        } catch (DateTimeParseException e) {
            System.out.println("Проверь формат даты dd.MM.yyyy HH.mm");
            createEvent(scanner1, titleTask, descriptionTask, typeTask, appearance);
        }
    }

    public static void editTask(Scanner scanner1) {
        Label:
        try {
            printActualTask();
            System.out.print("Редактируем задачу. Введите ID : ");
            int id = scanner1.nextInt();
            if (!activeTask.containsKey(id)) {
                throw new TaskNotFoundException("Задача не найдена.");
            }
            System.out.println("Что будете редактировать?");
            System.out.print("0- Выход, 1- Заголовок, 2 - Описание,3 - Тип, 4 - Дату  :");
            int menuEditTask = scanner1.nextInt();
            switch (menuEditTask) {
                case 0:
                    System.out.println("Вы передумали?");
                    System.out.println("Выход\n");
                    Main.outputMenu();
                    Main.inputMenu();
                    break;
                case 1:
                    scanner1.nextLine();
                    System.out.print("Введите новый заголовок задачи. ");
                    String titleTask = scanner1.nextLine();
                    Task task = (Task) activeTask.get(id);
                    task.setTitleTask(titleTask);
                    System.out.println("Изменили заголовок задачи.");
                    break Label;
                case 2:
                    scanner1.nextLine();
                    System.out.print("Введите новое описание задачи. ");
                    String descriptionTask = scanner1.nextLine();
                    Task task1 = (Task)activeTask.get(id);
                    task1.setDescriptionTask(descriptionTask);
                    System.out.println("Изменили описание задачи");
                    break Label;
                case 3:
                    scanner1.nextLine();
                    System.out.print("Введите новый тип задачи. 0 - рабочая, 1 - личная.");
                    Task task2 = (Task) activeTask.get(id);
                    task2.setTypeTask(Type.values()[scanner1.nextInt()]);
                    System.out.println("Изменили тип задачи.");
                    break Label;
                case 4:
                    scanner1.nextLine();
                    try {
                        System.out.print("Введите новую дату задачи как - yyyy-MM-ddTHH:mm - ");
                        String dateTimeTask = scanner1.nextLine();
                        LocalDateTime newDateTimeTask = LocalDateTime.parse(dateTimeTask);
                        Task task3 = (Task) activeTask.get(id);
                        task3.setDateTimeTask(newDateTimeTask);
                        System.out.println("Изменили дату задачи.");
                    } catch (DateTimeParseException e) {
                        System.out.println("Проверь формат даты dd.MM.yyyy HH.mm - ");
                        System.out.println("Начни редактировать заново. ");
                        editTask(scanner1);
                    }
                    break Label;
                default:
                    System.out.println("Вы ввели не верное число. Повторите ввод. ");
                    System.out.println("Выберите пункт меню из списка.");
                    Main.outputMenu();
                    Main.inputMenu();
                    break;
            }
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Repeatable createTask(int checkingAppearance, String titleTask, String descriptionTask, Type typeTask, LocalDateTime localDateTime) throws TaskNotFoundException {
        switch (checkingAppearance) {
                case 0:
                    System.out.println("Вы выбрали-однократная \n");
                    OneTimeTask oneTimeTask = new OneTimeTask(titleTask, descriptionTask, typeTask, localDateTime);
                    activeTask.put(oneTimeTask.getId(), oneTimeTask);
                    break;
                case 1:
                        System.out.println("Вы выбрали-ежедневную \n");
                    DailyTask dailyTask = new DailyTask(titleTask, descriptionTask, typeTask, localDateTime);
                    activeTask.put(dailyTask.getId(), dailyTask);
                    break;
                case 2:
                    System.out.println("Вы выбрали- еженедельная\n");
                    WeeklyTask weeklyTask = new WeeklyTask(titleTask, descriptionTask, typeTask, localDateTime);
                    activeTask.put(weeklyTask.getId(), weeklyTask);
                    break;
                case 3:
                    System.out.println("Вы выбрали- ежемесячная\n");
                    MonthlyTask monthlyTask = new MonthlyTask(titleTask, descriptionTask, typeTask, localDateTime);
                    activeTask.put(monthlyTask.getId(), monthlyTask);
                    break;
                case 4:
                    System.out.println("Вы выбрали- ежегодная\n");
                    YearlyTask yearlyTask = new YearlyTask(titleTask, descriptionTask, typeTask, localDateTime);
                    activeTask.put(yearlyTask.getId(), yearlyTask);
                    break;
                default:
                    System.out.println("Вы ввели неверное число.");
                    break;
           }
       return null;
    }
    public static void deleteTask(Scanner scanner1) {
        System.out.println("Текущие задачи. ");
        printActualTask();
        try {
            System.out.print("Для удаления введите ID задачи. ");
            int id = scanner1.nextInt();
            if (activeTask.containsKey(id)) {
                Repeatable removedTask = activeTask.get(id);
                activeTask.remove(id, removedTask);
                System.out.println("Задача " + id + " удалена. ");
            } else {
                throw new TaskNotFoundException();
            }
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
            System.out.println("Такой задачи не существует. ");
        }
    }

    public static void getReceiveTaskDay(Scanner scanner1) {
        System.out.print("Введите дату как -  dd.MM.yyyy.");
        try {
            String data = scanner1.next();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate requestedDate = LocalDate.parse(data, dateTimeFormatter);
            List<Repeatable> foundEvents = findTaskByDate(requestedDate);
            System.out.println("События на дату : " + requestedDate + ".");
            for (Repeatable task : foundEvents) {
                System.out.println(task);
            }
            System.out.println("Все события.");
            printActualTask();
        } catch (DateTimeParseException e) {
            System.out.println("Проверь формат даты dd.MM.yyyy.");
        }
        scanner1.nextLine();
        System.out.println("Для выхода нажмите Enter");
    }

    private static List<Repeatable> findTaskByDate(LocalDate date) {
        List<Repeatable> tasks = new ArrayList<>();
        for (Repeatable task : activeTask.values()) {
            if (task.checkingAppearance(date.atStartOfDay())) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    public static void printActualTask() {
        for (Repeatable task : activeTask.values()) {
            System.out.println(task);
        }
    }
}
