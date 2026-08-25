import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 8, 2, 3, 4, 6 }, 2, 10),
                new TestCase(new int[] { 1, 4, 7, 10, 15 }, 5, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.missingMultiple(test.in1, test.in2);
            assert test.expected == actual : "missingMultiple(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int missingMultiple(int[] nums, int k) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            if (num % k == 0) {
                values.add(num);
            }
        }
        for (int i = 1;; i++) {
            if (!values.contains(i * k)) {
                return i * k;
            }
        }
    }

}