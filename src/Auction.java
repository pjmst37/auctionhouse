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

    public boolean createAuction(User seller, String itemDescription, BigDecimal startingBid, LocalDateTime startDate,
                                 LocalDateTime endDate) {
        if (seller.isSeller()) {
            if (seller.isLoggedIn()) {
                if (startDate.isAfter(LocalDateTime.now())) {
                    if (endDate.isAfter(startDate)) {
                        if (startingBid.doubleValue() >= 0) {
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

}


