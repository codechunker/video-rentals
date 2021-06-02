package energy.rensource.videorentals.repository.sql;

import energy.rensource.videorentals.payload.VideoResponse;

import java.util.List;

public interface VideoRepository {

    List<VideoResponse> getVideos();
}
