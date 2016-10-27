/**
 * Created by paulmack on 10/26/16.
 */
public abstract class SaleNotification {
    PostOffice postOffice;

    SaleNotification() {
        postOffice = PostOffice.getInstance();
    }

    public abstract void sendEmailNotification(Auction auction);


}
