import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 1, 1, 3 }, 6),
                new TestCase(new int[] { 1, 1, 2, 3, 2, 1, 2 }, 8),
                new TestCase(new int[] { 1 }, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumDistance(test.in);
            assert test.expected == actual : "minimumDistance(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> indexesByNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexesByNum.computeIfAbsent(nums[i], ArrayList::new).add(i);
        }
        int min = Integer.MAX_VALUE;
        for (List<Integer> indexes : indexesByNum.values()) {
            for (int i = 0; i < indexes.size() - 2; i++) {
                min = Math.min(min, 2 * (indexes.get(i + 2) - indexes.get(i)));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}