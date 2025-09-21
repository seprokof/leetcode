import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class MovieRentingSystem {

    private final Map<Movie, PricedMovie> pricedMovieByMovie;
    private final Map<Integer, TreeSet<PricedMovie>> availableByMovieId;
    private final TreeSet<PricedMovie> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        pricedMovieByMovie = new HashMap<>();
        availableByMovieId = new HashMap<>();
        rented = new TreeSet<>();
        for (int[] entry : entries) {
            PricedMovie pm = new PricedMovie(entry[0], entry[1], entry[2]);
            pricedMovieByMovie.put(new Movie(pm.shop(), pm.movie()), pm);
            availableByMovieId.computeIfAbsent(pm.movie(), ignore -> new TreeSet<>()).add(pm);
        }
    }

    public List<Integer> search(int movie) {
        TreeSet<PricedMovie> available = availableByMovieId.get(movie);
        if (available == null) {
            return List.of();
        }
        return available.stream().limit(5L).map(PricedMovie::shop).toList();
    }

    public void rent(int shop, int movie) {
        PricedMovie pm = pricedMovieByMovie.get(new Movie(shop, movie));
        TreeSet<PricedMovie> available = availableByMovieId.get(movie);
        if (available != null) {
            available.remove(pm);
        }
        rented.add(pm);
    }

    public void drop(int shop, int movie) {
        PricedMovie pm = pricedMovieByMovie.get(new Movie(shop, movie));
        rented.remove(pm);
        availableByMovieId.computeIfAbsent(movie, ignore -> new TreeSet<>()).add(pm);
    }

    public List<List<Integer>> report() {
        return rented.stream().limit(5L).map(pm -> List.of(pm.shop(), pm.movie())).toList();
    }

    private static record Movie(int shop, int movie) {
    }

    private static record PricedMovie(int shop, int movie, int price) implements Comparable<PricedMovie> {

        @Override
        public int compareTo(PricedMovie other) {
            int result = Integer.compare(price, other.price);
            if (result != 0) {
                return result;
            }
            result = Integer.compare(shop, other.shop);
            if (result != 0) {
                return result;
            }
            return Integer.compare(movie, other.movie);
        }

    }

}
