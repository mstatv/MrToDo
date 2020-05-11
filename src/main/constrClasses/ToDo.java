package main.constrClasses;

import com.sun.tools.javac.comp.Todo;

public class ToDo {

    private String task;
    private long timeDate;
    private String taskDesc;

    // empty constructor
    public ToDo() {
        // empty
    }

    // constructor
    public ToDo(String task, long timeDate, String taskDesc) {
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

    public long getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(long timeDate) {
        this.timeDate = timeDate;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }
}
