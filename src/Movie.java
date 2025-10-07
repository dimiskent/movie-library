import java.util.List;

public class Movie {
    private final String title;
    private final List<Actor> actors;
    private final Director director;
    private final String genre;
    public Movie(String title, Director director, String genre, List<Actor> actors) {
        this.director = director;
        this.genre = genre;
        this.actors = actors;
        this.title = title;
    }
    public Director getDirector() {
        return director;
    }
    public String getGenre() {
        return genre;
    }
    public String getTitle() {
        return title;
    }
    public List<Actor> getActors() {
        return actors;
    }
}
