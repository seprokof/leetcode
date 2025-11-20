import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 3 }, { 3, 7 }, { 8, 9 } }, 5),
                new TestCase(new int[][] { { 1, 3 }, { 1, 4 }, { 2, 5 }, { 3, 5 } }, 3),
                new TestCase(new int[][] { { 1, 2 }, { 2, 3 }, { 2, 4 }, { 4, 5 } }, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.intersectionSizeTwo(test.in);
            assert test.expected == actual : "intersectionSizeTwo(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (l, r) -> l[1] == r[1] ? r[0] - l[0] : l[1] - r[1]);
        List<Integer> chosen = new ArrayList<>();
        for (int[] interval : intervals) {
            int remaining = 2;
            for (int i = chosen.size() - 1; i >= 0 && remaining > 0; i--) {
                if (chosen.get(i) >= interval[0]) {
                    remaining--;
                }
            }
            for (int i = remaining - 1; i >= 0; i--) {
                chosen.add(interval[1] - i);
            }
        }
        return chosen.size();
    }

}