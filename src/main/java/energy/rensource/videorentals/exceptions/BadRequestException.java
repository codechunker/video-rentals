package energy.rensource.videorentals.exceptions;

import java.util.List;

/**
 * @Author Sunday Ayodele
 * @create 9/27/2020
 */

public class BadRequestException extends RuntimeException {

    private String code;
    private List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }

    private void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public BadRequestException(String message, List<Error> errors) {
        super(message);

        setErrors(errors);
    }

    public BadRequestException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
