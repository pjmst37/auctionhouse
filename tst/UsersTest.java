/**
 * Created by paulmack on 10/25/16.
 */

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class UsersTest {
    private Users users;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userName;
    private String password;
    private boolean isRegistered;
    private boolean isLoggedIn;
    private boolean isSeller;

    @Before
    public void setup() {
        //instantiated here to initialized the collection that holds users
        users = new Users();

        firstName = "Joe";
        lastName = "Doe";
        userEmail = "test@test.com";
        userName = "joedoe";
        password = "test123";
        isRegistered = false;
        isLoggedIn = false;
        isSeller = false;
    }

    @Test
    public void registerUser() {
        User userToRegister = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);

        assertFalse("User is not registered", userToRegister.isRegistered());
        User registeredUser = users.register(userToRegister);
        assertNotNull("Registered Users is not null");
        assertTrue("User is registered", registeredUser.isRegistered());

    }

    @Test
    public void registerUserTwiceTest() {
        User userToRegister = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);

        User registeredUser = users.register(userToRegister);
        assertNotNull("Registered Users is not null", registeredUser);
        assertTrue("User is registered", registeredUser.isRegistered());

        User duplicateUser = users.register(userToRegister);
        assertNull("Registered Users is not null", duplicateUser);
    }

    @Test
    public void loginUserTest() {
        isRegistered = true;

        User userToLogin = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        assertFalse("User is not logged in", userToLogin.isLoggedIn());
        boolean successfulLogin = users.login(userToLogin.getUserName(), userToLogin.getPassword());
        assertTrue("User is logged in", successfulLogin);
    }

    @Test
    public void loginUserWithBadPasswordTest() {
        isRegistered = true;
        userName = "foo";
        final String badPassword = "foo";
        User userToLogin = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        assertFalse("User is not logged in", userToLogin.isLoggedIn());
        boolean successfulLogin = users.login(userName, badPassword);
        assertFalse("User is not logged in", successfulLogin);
    }

    @Test
    public void loginWithUserNotRegisteredTest(){
        User userToLogin = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        assertFalse("User is not logged in", userToLogin.isLoggedIn());
        boolean successfulLogin = users.login(userToLogin.getUserName(), userToLogin.getPassword());
        assertFalse("User is not logged in", successfulLogin);
    }

    @Test
    public void logoutUserTest() {
        isRegistered = true;
        isLoggedIn = true;
        userName = "foo";
        User userToLogout = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        assertTrue("User is logged in", userToLogout.isLoggedIn());
        boolean successfulLogout = users.logout(userToLogout.getUserName());
        assertTrue("User is logged out", successfulLogout);
    }

    @Test
    public void findUserByUsernameTest() {
        isRegistered = true;
        userName = "bar";
        User userToFind = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        User foundUser = users.findUser(userToFind.getUserName());
        assertNotNull("User was found", foundUser);
    }

    @Test
    public void findUserByUnregisteredUserTest() {
        final String badUserName = "bar";
        User foundUser = users.findUser(badUserName);
        assertNull("User was not found", foundUser);
    }


    private User buildUser(String firstName, String lastName, String username, String password, boolean isRegistered,
                           boolean isLoggedIn, boolean isSeller) {
        User user = new User(firstName, lastName, "", username, password, isSeller);
        user.setUserEmail("test@test.com");
        user.setRegistered(isRegistered);
        user.setLoggedIn(isLoggedIn);

        if (isRegistered && isLoggedIn) {
            users.register(user);
            users.login(user.getUserName(), user.getPassword());
        } else if (isRegistered) {
            users.register(user);
        }

        return user;
    }
}
