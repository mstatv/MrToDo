package main.constrClasses;


/**
 * USER CLASS
 * CREATES 'FRAMEWORK' FOR USER DATA CONFIG
 *
 */
public class User {

    private String firstName;
    private String lastName;
    private String userName;
    private String userPassword;

    // empty constructor
    public User() {
        // empty
    }

    // constructor
    public User(String firstName, String lastName, String userName, String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /**
     * Getter/Setter Block
     * for all private variables in
     * 'User' class
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
