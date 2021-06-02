package energy.rensource.videorentals.repository.sql;

import energy.rensource.videorentals.model.Video;
import energy.rensource.videorentals.model.VideoDetails;
import energy.rensource.videorentals.payload.VideoResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface VideoRepository {

    List<VideoResponse> getVideos(Pageable pageable);

    Optional<VideoDetails> findVideoById(Long id);
}
