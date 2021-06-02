package energy.rensource.videorentals.enums;

public enum Type {
    REGULAR(1), CHILDREN(2), NEW(3);

    private int type;

    Type(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
