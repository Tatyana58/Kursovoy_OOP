package Kursovoy_OOP;

import java.time.LocalDateTime;

public interface Repeatable {

    boolean checkingAppearance(LocalDateTime localDateTime);
    void setTitle(String title);
    LocalDateTime getDateTimeTask();
    void setArchived(boolean archived);
}
