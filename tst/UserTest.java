import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by paulmack on 10/25/16.
 */



public class UserTest {
    String testFirstName;
    String testLastName;
    String testUserEmail;
    String testUserName;
    String testPassword;
    boolean isRegistered;
    boolean isLoggedIn;
    boolean isSeller;

    @Test
    public void createUserTest() {
        testFirstName = "John";
        testLastName = "Doe";
        testUserEmail = "john.doe@test.com";
        testUserName = "jdoe";
        testPassword = "test123";
        isSeller = false;

        User user = new User(testFirstName, testLastName, testUserEmail, testUserName, testPassword, isSeller);

        assertEquals("First Name", testFirstName, user.getFirstName());
        assertEquals("Last Name", testLastName, user.getLastName());
        assertEquals("Email", testUserEmail, user.getUserEmail());
        assertEquals("Username", testUserName, user.getUserName());
        assertEquals("Password", testPassword, user.getPassword());
        assertFalse("isRegistered", user.isRegistered());
        assertFalse("isLoggedIn", user.isLoggedIn());
        assertFalse("isSeller", user.isSeller());
    }
}
