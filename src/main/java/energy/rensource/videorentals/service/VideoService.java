package energy.rensource.videorentals.service;


import energy.rensource.videorentals.model.Video;
import energy.rensource.videorentals.payload.VideoResponse;

import java.util.List;

public interface VideoService {

    List<VideoResponse> getAllVideo();

}
