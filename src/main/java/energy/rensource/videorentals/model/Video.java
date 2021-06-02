package energy.rensource.videorentals.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int videoType;
    private int videoGenre;

    //Nullables
    private Integer maxAge = null;
    @JsonFormat(pattern = "yyyy")
    private LocalDate releaseYear = null;

    public Video(String title, int videoType, int videoGenre) {
        this.title = title;
        this.videoType =  videoType;
        this.videoGenre = videoGenre;
    }

}
