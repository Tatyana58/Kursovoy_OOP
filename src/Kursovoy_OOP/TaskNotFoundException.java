package Kursovoy_OOP;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(){
    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}
