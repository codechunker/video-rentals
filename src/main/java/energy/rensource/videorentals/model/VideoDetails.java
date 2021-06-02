package energy.rensource.videorentals.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class VideoDetails {
    private Long id;
    private String title;
    private int videoType;
    private int videoGenre;
    private Integer maxAge = null;
    private Integer releaseYear = null;
    private double price;

}
