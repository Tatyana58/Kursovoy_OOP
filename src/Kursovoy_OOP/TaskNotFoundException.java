package Kursovoy_OOP;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(){
        System.out.println("Задача не найдена");
    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}
