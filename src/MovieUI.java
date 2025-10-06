import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieUI {
    private final Map<String, Movie> movies = new HashMap<>();
    private final Input input = new Input();
    public MovieUI() {
        int choice;
        do {
            System.out.println("Movies: " + movies.size());
            System.out.println("0) Exit");
            System.out.println("1) Add Movie");
            System.out.println("2) Search Movie");
            choice = input.getInt("Enter choice", 0, 2);
            process(choice);
        } while (choice != 0);
    }
    private void process(int choice) {
        if(choice == 0) return;
        else if(choice == 1) {
            String name = input.getString("Enter movie name");
            String genre = input.getString("Enter genre");
            Director director = new Director(input.getString("Enter Director's name"));
            List<Actor> actors = new ArrayList<>();
            int actorNumber = input.getInt("Number of actors");
            for(int i = 0; i < actorNumber; i++) {
                actors.add(new Actor(input.getString("Enter name for actor " + (i+1))));
            }
            movies.put(name, new Movie(director, genre, actors));
            System.out.println("Done!");
        } else {
            System.out.println("Query Types");
            System.out.println("1) By Name");
            System.out.println("2) By Director");
            System.out.println("3) By Actor");
            System.out.println("4) By Genre");
            int queryChoice = input.getInt("Choice", 1, 4);
            String query = input.getString("Name");
            search(query,queryChoice);
        }
    }
    private void search(String query, int type) {
        for (String name : movies.keySet()) {
            Movie movie = movies.get(name);
            boolean isFound = switch (type) {
                case 1 -> name.toLowerCase().contains(query.toLowerCase());
                case 2 -> query.toLowerCase().matches(movie.getDirector().getName().toLowerCase());
                case 4 -> movie.getGenre().equalsIgnoreCase(query);
                case 3 -> {
                    for (Actor actor : movie.getActors()) {
                        if(actor.getName().equalsIgnoreCase(query))
                            yield true;
                    }
                    yield false;
                }
                default -> false;
            };
            if(isFound) {
                System.out.println("--- MOVIE ---");
                System.out.println("Name: " + name);
                System.out.println("Genre: " + movie.getGenre());
                System.out.println("Director: " + movie.getDirector().getName());
                StringBuilder actorBuilder = new StringBuilder();
                for(Actor actor : movie.getActors()) {
                    actorBuilder.append(actor.getName()).append(", ");
                }
                String actorList = actorBuilder.toString();
                actorList = actorList.substring(0, actorList.length()-2);
                System.out.println("Actors: " + actorList);
            }
        }
    }
}
