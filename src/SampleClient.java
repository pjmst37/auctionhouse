import java.math.BigDecimal;

/**
 * Created by paulmack on 10/26/16.
 */
public class SampleClient {

    public static void main(String[] args) {
        User someBuyer = new User("Tome", "Jone", "some@test.com", "tjone", "password", false);
        User someSeller = new User("Lisa", "Simpson", "simpson@test.com", "lsimpson", "password", true);
        Auction noBuyerAuction = new Auction();
        noBuyerAuction.setSeller(someSeller);
        noBuyerAuction.setItemDescription("Bar");
        noBuyerAuction.setStartingBid(new BigDecimal(14));
        Auction buyerAuction = new Auction();
        buyerAuction.setItemDescription("Foo");
        buyerAuction.setCurrentBid(new BigDecimal(25));
        buyerAuction.setHighBidder(someBuyer);
        buyerAuction.setSeller(someSeller);


        String email = String.format("Sorry your auction for %s did not have any bidders", noBuyerAuction.getItemDescription());
        String sellerEmail = String.format("Your %s auction sold to %s for %n", buyerAuction.getItemDescription(), buyerAuction.getHighBidder().getUserEmail(), buyerAuction.getCurrentBid().intValue());
        String buyerEmail = String.format("Congratulations! You won an auction for %s from %s for %n", buyerAuction.getItemDescription(), buyerAuction.getSeller().getUserEmail(), buyerAuction.getCurrentBid().intValue());

        SaleNotification saleNotification = SaleNotificationFactory.getSaleNotification(noBuyerAuction);
        saleNotification.sendEmailNotification(noBuyerAuction);
        System.out.println(PostOffice.getInstance().doesLogContain(someSeller.getUserEmail(), email));

        SaleNotification saleNotification2 = SaleNotificationFactory.getSaleNotification(buyerAuction);
        saleNotification2.sendEmailNotification(buyerAuction);
        System.out.println(PostOffice.getInstance().doesLogContain(someSeller.getUserEmail(), sellerEmail));
        System.out.println(PostOffice.getInstance().doesLogContain(someBuyer.getUserEmail(), buyerEmail));

    }
}
