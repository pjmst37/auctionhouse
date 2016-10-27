/**
 * Created by paulmack on 10/26/16.
 */
public class SuccessfulBuyerSaleNotification extends SaleNotification {


    SuccessfulBuyerSaleNotification() {
        super();
    }


    @Override
    public void sendEmailNotification(Auction auction) {
        String sellerEmail = String.format("Your %s auction sold to %s for %n", auction.getItemDescription(), auction.getHighBidder().getUserEmail(), auction.getCurrentBid().intValue());
        String buyerEmail = String.format("Congratulations! You won an auction for %s from %s for %n", auction.getItemDescription(), auction.getSeller().getUserEmail(), auction.getCurrentBid().intValue());
        this.postOffice.sendEMail(auction.getSeller().getUserEmail(), sellerEmail);
        this.postOffice.sendEMail(auction.getHighBidder().getUserEmail(), buyerEmail);
        System.out.println(sellerEmail);
        System.out.println(buyerEmail);
        System.out.println(auction.getHighBidder().getUserEmail());
    }
}
