package energy.rensource.videorentals;

import energy.rensource.videorentals.enums.Type;
import energy.rensource.videorentals.exceptions.BadRequestException;
import energy.rensource.videorentals.exceptions.NotFoundException;
import energy.rensource.videorentals.model.PriceRequest;
import energy.rensource.videorentals.model.Video;
import energy.rensource.videorentals.model.VideoDetails;
import energy.rensource.videorentals.model.VideoType;
import energy.rensource.videorentals.payload.PriceResponse;
import energy.rensource.videorentals.payload.VideoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

public class AppUtils {

    public static void validatePageNumberAndSize(int page, int size) {

        if (page < 0) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST.toString(), "Page number cannot be less than zero.");
        }

        if (size > Const.MAX_PAGE_SIZE)
            throw new BadRequestException(HttpStatus.BAD_REQUEST.toString(), "page size must not be greater than "+Const.MAX_PAGE_SIZE);
    }

    private static double getPriceQuote(VideoDetails videoDetails, int numDays) {
        if (videoDetails == null) throw new NotFoundException(HttpStatus.NOT_FOUND.toString(), "Video not found");
        int videoType = videoDetails.getVideoType();
        double price;

        if (videoType == Type.REGULAR.getType()) price = videoDetails.getPrice() * numDays;
        else if (videoType == Type.CHILDREN.getType()) price = videoDetails.getPrice() * numDays + (videoDetails.getMaxAge() / 2.0);
        else if (videoType == Type.NEW.getType()) price = videoDetails.getPrice() * numDays - (Integer.parseInt(videoDetails.getReleaseYear().toString()));
        else throw new IllegalArgumentException("Invalid Video Type");

        return price;
    }

    public static PriceResponse getCalcPriceResponse(PriceRequest request, VideoDetails video) {
        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setUserName(request.getUserName());
        priceResponse.setVideoTitle(video.getTitle());
        priceResponse.setNumDays(request.getNumDays());
        priceResponse.setUnitPrice(video.getPrice());
        priceResponse.setTotalQuote(getPriceQuote(video, request.getNumDays()));
        return priceResponse;
    }
}
