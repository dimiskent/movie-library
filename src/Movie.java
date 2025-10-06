import java.util.ArrayList;
import java.util.List;

public class Movie {
    private final List<Actor> actors;
    private final Director director;
    private final String genre;
    public Movie(Director director, String genre, List<Actor> actors) {
        this.director = director;
        this.genre = genre;
        this.actors = actors;
    }
    public Director getDirector() {
        return director;
    }
    public String getGenre() {
        return genre;
    }
    public List<Actor> getActors() {
        return actors;
    }
}
