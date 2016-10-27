import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by paulmack on 10/25/16.
 */
public class Auction {
    private User seller;
    private String itemDescription;
    private BigDecimal startingBid;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private User highBidder;
    private BigDecimal currentBid;

    public boolean createAuction(User seller, String itemDescription, BigDecimal startingBid, LocalDateTime startDate,
                                 LocalDateTime endDate) {
        if (seller.isSeller()) {
            if (seller.isLoggedIn()) {
                if (startDate.isAfter(LocalDateTime.now())) {
                    if (endDate.isAfter(startDate)) {
                        if (startingBid.doubleValue() >= 0) {
                            this.seller = seller;
                            this.itemDescription = itemDescription;
                            this.startingBid = startingBid;
                            this.startDate = startDate;
                            this.endDate = endDate;
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BigDecimal getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(BigDecimal startingBid) {
        this.startingBid = startingBid;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public User getHighBidder() {
        return highBidder;
    }

    public void setHighBidder(User highBidder) {
        this.highBidder = highBidder;
    }

    public BigDecimal getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(BigDecimal currentBid) {
        this.currentBid = currentBid;
    }
}


