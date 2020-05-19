package main.constrClasses;


import java.sql.Timestamp;

/**
 * TODO CLASS
 * CREATES STRUCTURE FOR TODO DATA
 *
 */
public class ToDo {

    private String task;
    private Timestamp timeDate;
    private String taskDesc;

    // empty constructor
    public ToDo() {
        // empty
    }

    // constructor
    public ToDo(String task, Timestamp timeDate, String taskDesc, String toDo) {
        this.task = task;
        this.timeDate = timeDate;
        this.taskDesc = taskDesc;
    }

    /**
     * Getter/Setter Block
     * for 'ToDo' Class
     * @return
     */
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Timestamp getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Timestamp timeDate) {
        this.timeDate = timeDate;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }
}
