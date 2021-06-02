package energy.rensource.videorentals.controller;

import energy.rensource.videorentals.AppUtils;
import energy.rensource.videorentals.Const;
import energy.rensource.videorentals.enums.Type;
import energy.rensource.videorentals.exceptions.BadRequestException;
import energy.rensource.videorentals.exceptions.NotFoundException;
import energy.rensource.videorentals.model.*;
import energy.rensource.videorentals.payload.PriceResponse;
import energy.rensource.videorentals.payload.VideoResponse;
import energy.rensource.videorentals.service.VideoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@RestController
@RequestMapping("/api/v1/videos")
@Slf4j
public class VideoRentalController {

    final VideoService videoService;

    public VideoRentalController(VideoService videoService) {
        this.videoService = videoService;
    }

    @ApiOperation(value = "Get all the videos in the database. pageNumber and pageSize are not compulsory")
    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getVideos(
            @RequestParam(required = false, defaultValue = Const.PAGE_NUMBER) int pageNumber,
            @RequestParam(required = false, defaultValue = Const.PAGE_SIZE) int pageSize
    ) {
        AppUtils.validatePageNumberAndSize(pageNumber, pageSize);
        List<VideoResponse> videos = videoService.getAllVideo(pageNumber, pageSize);
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @GetMapping(value = {"type"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getVideoTypes(
            @RequestParam(required = false, defaultValue = Const.PAGE_NUMBER) int pageNumber,
            @RequestParam(required = false, defaultValue = Const.PAGE_SIZE) int pageSize
    ) {
        AppUtils.validatePageNumberAndSize(pageNumber, pageSize);
        List<VideoType> videos = videoService.getVideoTypes(pageNumber, pageSize);
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @GetMapping(value = {"calc-requests"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllPriceCalcRequests(
            @RequestParam(required = false, defaultValue = Const.PAGE_NUMBER) int pageNumber,
            @RequestParam(required = false, defaultValue = Const.PAGE_SIZE) int pageSize
    ) {
        AppUtils.validatePageNumberAndSize(pageNumber, pageSize);
        List<PriceRequest> requests = videoService.getPriceCalcRequests(pageNumber, pageSize);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @ApiOperation(value = "It is expected that the client provides video id to be calculated to prevent redundancy in db")
    @PostMapping(value = {"/price"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> calculatePrice(@Valid @RequestBody PriceRequest priceRequest) {
        log.info("Calculate Price Request: {}", priceRequest.toString());
        VideoDetails video = videoService.findAVideoById(priceRequest.getVideoId())
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND.toString(), String.format("Video with id %d not found", priceRequest.getVideoId())));
        PriceResponse priceResponse = AppUtils.getCalcPriceResponse(priceRequest, video);
        videoService.savePriceCalcRequest(priceRequest);
        return new ResponseEntity<>(priceResponse, HttpStatus.OK);
    }

    @PostMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createVideo(@Valid @RequestBody Video video) {
        log.info("Create Video Request: {}", video.toString());

        if ((video.getVideoType() != null && Type.CHILDREN.getType() == video.getVideoType()) && video.getMaxAge() == null)
            throw new BadRequestException(HttpStatus.BAD_REQUEST.toString(), "Maximum Age is required for Children's Movie");

        try {
            if ((video.getVideoType() != null && Type.NEW.getType() == video.getVideoType()) && video.getReleaseYear() == null)
                throw new BadRequestException(HttpStatus.BAD_REQUEST.toString(), "Year Released is required for New Releases");
            else if (video.getReleaseYear() != null){
                new SimpleDateFormat("yyyy").parse(String.valueOf(video.getReleaseYear()));
            }
        } catch (ParseException e) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST.toString(), "Invalid Year. Year should be in 'yyyy' format ");
        } catch (Exception e) {
            log.error("Error: ", e);
        }

        Video response = videoService.createVideo(video);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(value = {"/type"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createVideoType(@Valid @RequestBody VideoType type) {
        log.info("Create Video Type Request: {}", type.toString());
        VideoType response = videoService.createVideoType(type);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(value = {"/genre"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createVideoGenre(@Valid @RequestBody VideoGenre genre) {
        log.info("Create Video Genre Request: {}", genre.toString());
        VideoGenre response = videoService.createVideoGenre(genre);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
