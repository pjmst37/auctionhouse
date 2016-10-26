import java.util.HashMap;
import java.util.Map;

/**
 * Created by paulmack on 10/25/16.
 */
public class Users {
    private Map<String, User> siteUsers = new HashMap<String, User>();

    public User register(User user) {
        if (!siteUsers.containsKey(user.getUserName())) {
            user.setRegistered(true);
            siteUsers.put(user.getUserName(), user);
            return user;
        } else {
            return null;
        }
    }

    public boolean login(String username, String password) {
        if (siteUsers.containsKey(username)) {
            User registeredUser = siteUsers.get(username);
            if (registeredUser.getPassword().equals(password)) {
                registeredUser.setLoggedIn(true);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean logout(String username) {
        if (siteUsers.containsKey(username)) {
            User loggedInUser = siteUsers.get(username);
            loggedInUser.setLoggedIn(false);
            return true;
        } else {
            return false;
        }
    }

    public User findUser(String username) {
        User foundUser = siteUsers.get(username);
        return foundUser;
    }
}
