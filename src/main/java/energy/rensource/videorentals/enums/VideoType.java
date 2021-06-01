package energy.rensource.videorentals.enums;

public enum VideoType {
    REGULAR(1), CHILDREN(2), NEW(3);

    private int type;

    VideoType(int type) {
        this.type = type;
    }
}
