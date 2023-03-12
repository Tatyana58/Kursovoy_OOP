package Kursovoy_OOP.Exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(){
        System.out.println("Задача не найдена");
    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}
