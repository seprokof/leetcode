import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, List<List<String>> in2, String[] in3, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "bread" }, List.of(List.of("yeast", "flour")), new String[] { "yeast", "flour", "corn" }, List.of("bread")),
                new TestCase(new String[] { "bread", "sandwich" }, List.of(List.of("yeast", "flour"), List.of("bread", "meat")), new String[] { "yeast", "flour", "meat" }, List.of("bread", "sandwich")),
                new TestCase(new String[] { "bread", "sandwich", "burger" }, List.of(List.of("yeast", "flour"), List.of("bread", "meat"), List.of("sandwich", "meat", "bread")), new String[] { "yeast", "flour", "meat" }, List.of("bread", "sandwich", "burger"))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.findAllRecipes(test.in1, test.in2, test.in3);
            assert isSame(test.expected, actual) : "findAllRecipes(%s, %s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, Arrays.toString(test.in3), actual, test.expected);
        }
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> cookBook = new HashMap<>(recipes.length);
        for (int i = 0; i < ingredients.size(); i++) {
            cookBook.put(recipes[i], ingredients.get(i));
        }
        Map<String, Boolean> canCook = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Set<String> suppliesSet = Set.of(supplies);
        List<String> result = new ArrayList<>();
        for (String recipe : recipes) {
            if (canCook(recipe, cookBook, canCook, visited, suppliesSet)) {
                result.add(recipe);
            }
        }
        return result;
    }

    private boolean canCook(String recipe, Map<String, List<String>> cookBook, Map<String, Boolean> canCook,
            Set<String> visited, Set<String> supplies) {
        if (canCook.containsKey(recipe)) {
            return canCook.get(recipe);
        }
        if (visited.contains(recipe) || !cookBook.containsKey(recipe)) {
            return false;
        }
        visited.add(recipe);
        boolean isPossible = true;
        List<String> ingredients = cookBook.get(recipe);
        for (int i = 0; i < ingredients.size() && isPossible; i++) {
            String ingredient = ingredients.get(i);
            if (!supplies.contains(ingredient)) {
                isPossible &= canCook(ingredient, cookBook, canCook, visited, supplies);
            }
        }
        canCook.put(recipe, isPossible);
        return isPossible;
    }

    private static boolean isSame(List<String> left, List<String> right) {
        if (left == right) {
            return true;
        }
        if (left.size() != right.size()) {
            return false;
        }
        return new HashSet<>(left).equals(new HashSet<>(right));
    }

}