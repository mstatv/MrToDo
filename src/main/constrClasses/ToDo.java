package main.constrClasses;


import java.sql.Timestamp;

/**
 * TODO CLASS
 * CREATES STRUCTURE FOR TODO DATA
 *
 */
public class ToDo {

    private String toDo;
    private Timestamp timeDate;
    private String taskDesc;
    private int uID;

    // empty constructor
    public ToDo() {
        // empty
    }

    // constructor
    public ToDo(Timestamp timeDate, String taskDesc, String toDo) {
        this.toDo = toDo;
        this.timeDate = timeDate;
        this.taskDesc = taskDesc;
    }

    /**
     * Getter/Setter Block
     * for 'ToDo' Class
     * @return
     */
    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
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

    public void setTodoDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }
}
