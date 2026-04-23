import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, long[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 1, 1, 2 }, new long[] { 5L, 0L, 3L, 4L, 0L }),
                new TestCase(new int[] { 0, 5, 3 }, new long[] { 0L, 0L, 0L })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long[] actual = s.distance(test.in);
            assert Arrays.equals(test.expected, actual) : "distance(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> indexesByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexesByValue.computeIfAbsent(nums[i], ignore -> new ArrayList<>()).add(i);
        }
        long[] result = new long[nums.length];
        for (List<Integer> indexes : indexesByValue.values()) {
            int count = indexes.size();
            long[] prefixSum = new long[count];
            prefixSum[0] = indexes.get(0);
            for (int i = 1; i < count; i++) {
                prefixSum[i] = prefixSum[i - 1] + indexes.get(i);
            }
            for (int i = 0; i < count; i++) {
                int index = indexes.get(i);
                if (i > 0) {
                    result[index] += 1L * i * index - prefixSum[i - 1];
                }
                if (i < count - 1) {
                    result[index] += prefixSum[count - 1] - prefixSum[i] - 1L * (count - i - 1) * index;
                }
            }
        }
        return result;
    }

}