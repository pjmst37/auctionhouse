/**
 * Created by paulmack on 10/26/16.
 */
public class NoBuyerSaleNotification extends SaleNotification {

    public NoBuyerSaleNotification() {
        super();
    }

    @Override
    public void sendEmailNotification(Auction auction) {
        String email = String.format("Sorry your auction for %s did not have any bidders", auction.getItemDescription());
        this.postOffice.sendEMail(auction.getSeller().getUserEmail(), email);
    }
}
