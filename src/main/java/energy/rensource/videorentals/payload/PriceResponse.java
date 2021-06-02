package energy.rensource.videorentals.payload;

import lombok.Data;

@Data
public class PriceResponse {
    private String userName;
    private int numDays;
    private String videoTitle;
    private double unitPrice;
    private double totalQuote;
}
