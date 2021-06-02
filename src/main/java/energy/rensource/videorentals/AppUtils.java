package energy.rensource.videorentals;

import energy.rensource.videorentals.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AppUtils {

    public static void validatePageNumberAndSize(int page, int size) {

        if (page < 0) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST.toString(), "Page number cannot be less than zero.");
        }

        if (size > Const.MAX_PAGE_SIZE)
            throw new BadRequestException(HttpStatus.BAD_REQUEST.toString(), "page size must not be greater than "+Const.MAX_PAGE_SIZE);
    }
}
