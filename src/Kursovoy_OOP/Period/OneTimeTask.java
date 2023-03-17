package Kursovoy_OOP.Period;

import Kursovoy_OOP.Exception.TaskNotFoundException;
import Kursovoy_OOP.Repeatable;
import Kursovoy_OOP.Type;

import java.time.LocalDateTime;

public class OneTimeTask extends Task implements Repeatable {
    public OneTimeTask(String titleTask, String descriptionTask, Type typeTask, LocalDateTime date) throws TaskNotFoundException {
        super(titleTask, descriptionTask, typeTask, date);
    }

    @Override
    public boolean checkingAppearance(LocalDateTime requestedDate) {
        return getDateTimeTask().toLocalTime().equals(requestedDate.toLocalTime());
    }

    @Override
    public void setTitle(String title) {

    }
}
