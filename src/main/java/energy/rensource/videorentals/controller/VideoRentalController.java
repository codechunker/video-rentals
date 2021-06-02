package energy.rensource.videorentals.controller;

import energy.rensource.videorentals.model.Video;
import energy.rensource.videorentals.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/video/rentals")
@Slf4j
public class VideoRentalController {

    final VideoService videoService;

    public VideoRentalController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getVideos() {
        List<Video> videos = videoService.getAllVideo();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }
}
