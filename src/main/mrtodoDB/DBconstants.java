package main.mrtodoDB;

/**
 * Constants class
 * to create variables for each:
 * table and column within the DB
 * works to ensure easier access
 * in rest of application build
 */
public class DBconstants {

    // table names
    public static final String MRTODO_USERS = "mrtodo_users";
    public static final String MRTODO_TASKS = "mrtodo_tasks";

    // users column names
    public static final String U_USERID = "userID";
    public static final String U_FIRSTNAME = "firstName";
    public static final String U_LASTNAME = "lastName";
    public static final String U_USERNAME = "userName";
    public static final String U_PASSWORD = "userPassword";

    // tasks column names
    public static final String T_TASKNUM = "taskNum";
    public static final String T_USERID = "userID";
    public static final String T_TODO = "ToDo";
    public static final String T_TIMEDATE = "timeDate";
    public static final String T_TASKDESC = "taskDesc";

}
