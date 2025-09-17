import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {

    private final Map<String, FoodRating> foodByName;
    private final Map<String, PriorityQueue<FoodRating>> highestByCuisine;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodByName = new HashMap<>(foods.length);
        highestByCuisine = new HashMap<>(foods.length);
        for (int i = 0; i < foods.length; i++) {
            FoodRating fr = new FoodRating(foods[i], cuisines[i], ratings[i]);
            foodByName.put(fr.food, fr);
            highestByCuisine.computeIfAbsent(fr.cuisine, ignore -> new PriorityQueue<>()).offer(new FoodRating(fr));
        }
    }

    public void changeRating(String food, int newRating) {
        FoodRating fr = foodByName.get(food);
        fr.rating = newRating;
        highestByCuisine.get(fr.cuisine).offer(new FoodRating(fr));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<FoodRating> queue = highestByCuisine.get(cuisine);
        while (queue.peek().rating != foodByName.get(queue.peek().food).rating) {
            queue.poll();
        }
        return queue.peek().food;
    }

    private static class FoodRating implements Comparable<FoodRating> {

        private final String food;
        private final String cuisine;
        private int rating;

        public FoodRating(String food, String cuisine, int rating) {
            super();
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        public FoodRating(FoodRating fr) {
            super();
            this.food = fr.food;
            this.cuisine = fr.cuisine;
            this.rating = fr.rating;
        }

        @Override
        public int compareTo(FoodRatings.FoodRating other) {
            int result = Integer.compare(this.rating, other.rating);
            if (result != 0) {
                return -result;
            }
            return this.food.compareTo(other.food);
        }

    }

}
