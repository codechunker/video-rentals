package energy.rensource.videorentals.payload;

import energy.rensource.videorentals.model.VideoGenre;
import energy.rensource.videorentals.model.VideoType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VideoResponse {
    private String videoTitle;
    private VideoType videoType;
    private VideoGenre videoGenre;
}
