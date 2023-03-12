package Kursovoy_OOP.Period;

import Kursovoy_OOP.Exception.TaskNotFoundException;
import Kursovoy_OOP.Type;
import Kursovoy_OOP.Utilite.ValidateUtils;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private String titleTask; // заголовок
    private String descriptionTask;// описание
    private Type typeTask;// тип Личная или рабочая
    private LocalDateTime dateTimeTask; // Дата создания задачи
    private boolean archived;
    private static Integer count=1;
    private final Integer id;


    public Task(String titleTask, String descriptionTask,Type typeTask, LocalDateTime localDateTime) throws TaskNotFoundException {
        this.titleTask = ValidateUtils.checkingString(titleTask);
        this.descriptionTask = ValidateUtils.checkingString(descriptionTask);
        this.archived = false;
        this.typeTask = typeTask;
        this.dateTimeTask = localDateTime;
        id = count++;
    }

    public String getTitleTask() {
        return titleTask;
    }

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public Type getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(Type typeTask) {
        this.typeTask = typeTask;
    }

    public LocalDateTime getDateTimeTask() {
        return dateTimeTask;
    }

    public void setDateTimeTask(LocalDateTime dateTimeTask) {
        this.dateTimeTask = dateTimeTask;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Task.count = count;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return archived == task.archived && titleTask.equals(task.titleTask) && descriptionTask.equals(task.descriptionTask) && typeTask == task.typeTask && dateTimeTask.equals(task.dateTimeTask) && id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleTask, descriptionTask, typeTask, dateTimeTask, archived, id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "titleTask='" + titleTask + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", typeTask=" + typeTask +
                ", dateTimeTask=" + dateTimeTask +
                ", arhived=" + archived +
                ", id=" + id +
                '}';
    }
}

