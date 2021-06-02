package energy.rensource.videorentals.enums;


public enum Genre {

    ACTION(1), DRAMA(2), ROMANCE(3), COMEDY(4), HORROR(5);

    private int genre;

    Genre(int genre) {
        this.genre = genre;
    }

    public int getGenre() {
        return genre;
    }
}
