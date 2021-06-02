package energy.rensource.videorentals.service;


import energy.rensource.videorentals.model.Video;
import energy.rensource.videorentals.model.VideoDetails;
import energy.rensource.videorentals.model.VideoGenre;
import energy.rensource.videorentals.model.VideoType;
import energy.rensource.videorentals.payload.VideoResponse;

import java.util.List;
import java.util.Optional;

public interface VideoService {

    List<VideoResponse> getAllVideo(int pageNumber, int pageSize);
    List<VideoType> getVideoTypes(int pageNumber, int pageSize);

    List<VideoGenre> getVideoGenres(int pageNumber, int pageSize);
    Optional<VideoDetails> findAVideoById(Long id);

    Optional<Video> findVideo(Long id);
    Video createVideo(Video video);

    VideoType createVideoType(VideoType type);

    VideoGenre createVideoGenre(VideoGenre genre);

}
