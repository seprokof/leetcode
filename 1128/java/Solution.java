import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } }, 1),
                new TestCase(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numEquivDominoPairs(test.in);
            assert test.expected == actual : "numEquivDominoPairs(%s) == %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, List<int[]>> map = new HashMap<>(dominoes.length);
        int result = 0;
        for (int[] domino : dominoes) {
            Integer key = domino[0] + domino[1];
            List<int[]> values = map.computeIfAbsent(key, ignore -> new ArrayList<>());
            if (values.size() > 0) {
                for (int[] v : values) {
                    if ((v[0] == domino[0] && v[1] == domino[1]) || (v[1] == domino[0] && v[0] == domino[1])) {
                        result++;
                    }
                }
            }
            values.add(domino);
        }
        return result;
    }

}