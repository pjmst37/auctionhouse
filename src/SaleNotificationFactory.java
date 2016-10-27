/**
 * Created by paulmack on 10/26/16.
 */
public class SaleNotificationFactory {

    public static SaleNotification getSaleNotification(Auction auction) {
        if (auction.getHighBidder() == null) {
            return new NoBuyerSaleNotification();
        } else {
            return new SuccessfulBuyerSaleNotification();
        }
    }

}
