package Kursovoy_OOP.Utilite;

import Kursovoy_OOP.Exception.TaskNotFoundException;

import java.util.Scanner;

public class ValidateUtils {
    public static String checkingString (String str) throws TaskNotFoundException {
        if (str == null || str.isEmpty() || str.isBlank()) {
            throw new  TaskNotFoundException("Ввод некорректных данных. Введите строку.");
        } else{
            return str;
        }
    }
}
