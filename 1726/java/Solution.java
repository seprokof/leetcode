import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 3, 4, 6 }, 8),
                new TestCase(new int[] { 1, 2, 4, 5, 10 }, 16)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.tupleSameProduct(test.in);
            assert test.expected == actual : "tupleSameProduct(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productFreq = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                count += productFreq.getOrDefault(product, 0) * 8;
                productFreq.merge(product, 1, Integer::sum);
            }
        }
        return count;
    }

}