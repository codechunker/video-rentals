package energy.rensource.videorentals.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @NotBlank(message = "Video title is needed")
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "type")
    private Integer videoType;

    @NotNull
    @Column(name = "genre")
    private Integer videoGenre;

    //Nullables
    @Column(name = "maxAge")
    private Integer maxAge = null;
    @Column(name = "releaseYear")
    private Integer releaseYear = null;

    public Video(String title, int videoType, int videoGenre) {
        this.title = title;
        this.videoType =  videoType;
        this.videoGenre = videoGenre;
    }

}
