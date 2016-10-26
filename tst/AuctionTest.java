import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

/**
 * Created by paulmack on 10/25/16.
 */
public class AuctionTest {
    private Users users;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userName;
    private String password;
    private boolean isRegistered;
    private boolean isLoggedIn;
    private boolean isSeller;
    private String itemDescription;
    private BigDecimal startingBid;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Before
    public void setup() {
        users = new Users();
        firstName = "Joe";
        lastName = "Doe";
        userEmail = "test@test.com";
        userName = "joedoe";
        password = "test123";
        isRegistered = false;
        isLoggedIn = false;
        isSeller = false;

        itemDescription = "Book";
        startingBid = new BigDecimal(10.00);
        startDate = LocalDateTime.now().plusDays(5);
        endDate = LocalDateTime.now().plusDays(10);

    }

    @Test
    public void createAuctionTest() {
        isRegistered = true;
        isLoggedIn = true;
        isSeller = true;
        // user is registered, logged in and is a Seller
        User seller = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        Auction auction = new Auction();
        boolean createdAuction = auction.createAuction(seller, itemDescription, startingBid, startDate, endDate);
        assertTrue("Auction create", createdAuction);
    }

    @Test
    public void createAuctionNotSellerTest() {
        isRegistered = true;
        isLoggedIn = true;
        isSeller = false;
        // user is registered, logged in and is not a Seller
        User seller = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        Auction auction = new Auction();
        boolean createdAuction = auction.createAuction(seller, itemDescription, startingBid, startDate, endDate);
        assertFalse("Auction not created", createdAuction);
    }

    @Test
    public void createAuctionNotLoggedInTest() {
        isRegistered = true;
        isLoggedIn = false;
        isSeller = true;
        // user is registered, not logged in and is a Seller
        User seller = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        Auction auction = new Auction();
        boolean createdAuction = auction.createAuction(seller, itemDescription, startingBid, startDate, endDate);
        assertFalse("Auction not created", createdAuction);
    }

    @Test
    public void createAuctionStartDateIsNowTest(){
        isRegistered = true;
        isLoggedIn = true;
        isSeller = true;
        startDate = LocalDateTime.now();
        User seller = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        Auction auction = new Auction();
        boolean createdAuction = auction.createAuction(seller, itemDescription, startingBid, startDate, endDate);
        assertFalse("Auction not created", createdAuction);
    }

    @Test
    public void createAuctionEndateDateIsStartDateTest(){
        isRegistered = true;
        isLoggedIn = true;
        isSeller = true;
        startDate = LocalDateTime.now();
        endDate = startDate;
        User seller = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        Auction auction = new Auction();
        boolean createdAuction = auction.createAuction(seller, itemDescription, startingBid, startDate, endDate);
        assertFalse("Auction not created", createdAuction);
    }

    @Test
    public void createAuctionBelowMinimalBidTest(){
        isRegistered = true;
        isLoggedIn = true;
        isSeller = true;
        startingBid = new BigDecimal(-1.00);
        User seller = buildUser(firstName, lastName, userName, password, isRegistered, isLoggedIn, isSeller);
        Auction auction = new Auction();
        boolean createdAuction = auction.createAuction(seller, itemDescription, startingBid, startDate, endDate);
        assertFalse("Auction not created", createdAuction);
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
