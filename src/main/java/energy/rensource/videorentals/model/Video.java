package energy.rensource.videorentals.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private int videoType;
    @Column(name = "genre")
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
