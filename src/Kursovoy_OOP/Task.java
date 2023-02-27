package Kursovoy_OOP;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private final int idGenerator;
    private String title;
    private final Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private String description;

    public Task(int idGenerator, String title, Type type, int id, LocalDateTime dateTime, String description) {
        this.idGenerator = idGenerator;
        this.title = title;
        this.type = type;
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
    }

    public int getIdGenerator() {
        return idGenerator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idGenerator == task.idGenerator && id == task.id && title.equals(task.title) && type.equals(task.type) && dateTime.equals(task.dateTime) && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, title, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "idGenerator=" + idGenerator +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
