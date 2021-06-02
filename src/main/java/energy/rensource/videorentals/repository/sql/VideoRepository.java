package energy.rensource.videorentals.repository.sql;

import energy.rensource.videorentals.payload.VideoResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VideoRepository {

    List<VideoResponse> getVideos(Pageable pageable);
}
