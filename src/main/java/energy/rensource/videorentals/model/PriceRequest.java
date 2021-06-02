package energy.rensource.videorentals.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "video_price_request")
public class PriceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Your name is needed")
    private String userName;

    @NotNull
    private Long videoId;

    @NotNull
    @Min(value = 1, message = "Number of days should not be less than 1")
    private int numDays;

    public PriceRequest(String userName, Long videoId, int numDays) {
        this.userName = userName;
        this.videoId = videoId;
        this.numDays = numDays;
    }

}
