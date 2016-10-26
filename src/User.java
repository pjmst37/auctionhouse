/**
 * Created by paulmack on 10/25/16.
 */
public class User {
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userName;
    private String password;
    private boolean isRegistered;
    private boolean isLoggedIn;
    private boolean isSeller;

    public User(String firstName, String lastName, String userEmail, String userName, String password, boolean isSeller) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userName = userName;
        this.password = password;
        this.isSeller = isSeller;
    }

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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

}
