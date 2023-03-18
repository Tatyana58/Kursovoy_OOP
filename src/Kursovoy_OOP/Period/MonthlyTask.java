package Kursovoy_OOP.Period;

import Kursovoy_OOP.Exception.TaskNotFoundException;
import Kursovoy_OOP.Repeatable;
import Kursovoy_OOP.Type;

import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatable {
    public MonthlyTask(String titleTask, String descriptionTask, Type typeTask, LocalDateTime date) throws TaskNotFoundException {
        super(titleTask, descriptionTask, typeTask, date);
    }

    @Override
    public boolean checkingAppearance(LocalDateTime requestedDate) {
        return getDateTimeTask().getDayOfMonth() == requestedDate.getDayOfMonth();
    }

    @Override
    public void setTitle(String title) {

    }
}
