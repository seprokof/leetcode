import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 5, 2, 3 }, 2, List.of(1, 2)),
                new TestCase(new int[] { 1, 2, 5, 2, 3 }, 3, List.of(3)),
                new TestCase(new int[] { 1, 2, 5, 2, 3 }, 5, List.of(4))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.targetIndices(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "targetIndices(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0;
        int equal = 0;
        for (int num : nums) {
            if (num == target) {
                equal++;
            } else if (num < target) {
                less++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < equal; i++) {
            result.add(less + i);
        }
        return result;
    }

}