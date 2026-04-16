import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 1, 4, 1, 3, 2 }, new int[] { 0, 3, 5 }, List.of(2, -1, 3)),
                new TestCase(new int[] { 1, 2, 3, 4 }, new int[] { 0, 1, 2, 3 }, List.of(-1, -1, -1, -1))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.solveQueries(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "solveQueries(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> valueToIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valueToIndexes.computeIfAbsent(nums[i], ignore -> new ArrayList<>()).add(i);
        }
        List<Integer> result = new ArrayList<>(queries.length);
        for (int query : queries) {
            List<Integer> indexes = valueToIndexes.get(nums[query]);
            if (indexes.size() == 1) {
                result.add(-1);
                continue;
            }
            int i = Collections.binarySearch(indexes, query);
            int leftDist = i - 1 < 0 ? indexes.get(i) + nums.length - indexes.getLast()
                    : indexes.get(i) - indexes.get(i - 1);
            int rightDist = i + 1 == indexes.size() ? nums.length - indexes.get(i) + indexes.getFirst()
                    : indexes.get(i + 1) - indexes.get(i);
            result.add(Math.min(leftDist, rightDist));
        }
        return result;
    }

}