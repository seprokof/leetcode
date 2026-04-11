import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
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
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (indexesByNum.containsKey(nums[i])) {
                List<Integer> indexes = indexesByNum.get(nums[i]);
                indexes.add(i);
                if (indexes.size() == 3) {
                    min = Math.min(min, 2 * (indexes.get(2) - indexes.get(0)));
                    indexes.remove(0);
                }
            } else {
                indexesByNum.computeIfAbsent(nums[i], ignore -> new LinkedList<>()).add(i);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}