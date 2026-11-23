import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int[][] in2, List<List<Integer>> expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 1 }, { 4, 5 }, { 3, 8 } }, new int[][] { { 3, 1 }, { 1, 5 } }, List.of(List.of(1, 6), List.of(3, 9), List.of(4, 5))),
                new TestCase(new int[][] { { 1, 1 }, { 3, 2 }, { 2, 3 } }, new int[][] { { 2, 1 }, { 3, 2 }, { 1, 3 } }, List.of(List.of(1, 4), List.of(2, 4), List.of(3, 4))),
                new TestCase(new int[][] { { 1, 3 }, { 2, 2 } }, new int[][] { { 7, 1 }, { 2, 2 }, { 1, 4 } }, List.of(List.of(1, 7), List.of(2, 4), List.of(7, 1)))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<List<Integer>> actual = s.mergeSimilarItems(test.in1, test.in2);
            assert Objects.deepEquals(test.expected, actual) : "mergeSimilarItems(%s, %s) == %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] merged = new int[1001];
        for (int[] i : items1) {
            merged[i[0]] += i[1];
        }
        for (int[] i : items2) {
            merged[i[0]] += i[1];
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < merged.length; i++) {
            if (merged[i] > 0) {
                result.add(List.of(i, merged[i]));
            }
        }
        return result;
    }

}