package Kursovoy_OOP.Period;

import Kursovoy_OOP.Exception.TaskNotFoundException;
import Kursovoy_OOP.Repeatable;
import Kursovoy_OOP.Type;

import java.time.LocalDateTime;

    public class DailyTask extends Task implements Repeatable {
    public DailyTask(String titleTask, String descriptionTask, Type typeTask, LocalDateTime date) throws TaskNotFoundException {
        super(titleTask, descriptionTask, typeTask, date);
    }
    @Override
    public boolean checkingAppearance(LocalDateTime requestedDate) {
        return getDateTimeTask().toLocalDate().equals(requestedDate.toLocalDate());
    }

        @Override
        public void setTitle(String title) {

        }

    }
