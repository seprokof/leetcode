import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 3, 1, 2, 4, 5 }, { 1, 2, 3, 4 }, { 3, 4, 5, 6 } }, List.of(3, 4)),
                new TestCase(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, List.of())
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.intersection(test.in);
            assert Objects.equals(test.expected, actual) : "intersection(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public List<Integer> intersection(int[][] nums) {
        int[] frequency = new int[1001];
        for (int[] arr : nums) {
            for (int val : arr) {
                frequency[val]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] == nums.length) {
                result.add(i);
            }
        }
        return result;
    }

}