package Kursovoy_OOP;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task extends Type {
    private String titleTask; // заголовок
    private String descriptionTask;// описание
    private Type typeTask;// тип Личная или рабочая
    private LocalDateTime dateTimeTask; // Дата создания задачи

    private static Integer count=1;
    private final Integer id;


    public Task(String titleTask, String descriptionTask, Type typeTask, LocalDateTime dateTimeTask) {
        this.titleTask = titleTask;
        this.descriptionTask = descriptionTask;
        this.typeTask = typeTask;
        this.dateTimeTask = dateTimeTask;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return titleTask.equals(task.titleTask) && descriptionTask.equals(task.descriptionTask) && typeTask.equals(task.typeTask) && dateTimeTask.equals(task.dateTimeTask) && id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleTask, descriptionTask, typeTask, dateTimeTask, id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "titleTask='" + titleTask + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", typeTask=" + typeTask +
                ", dateTimeTask=" + dateTimeTask +
                ", id=" + id +
                '}';
    }
}

