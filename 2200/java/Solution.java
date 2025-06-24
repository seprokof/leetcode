import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int in3, List<Integer> expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 3, 4, 9, 1, 3, 9, 5 }, 9, 1, List.of(1, 2, 3, 4, 5, 6)),
                new TestCase(new int[] { 2, 2, 2, 2, 2 }, 2, 2, List.of(0, 1, 2, 3, 4))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.findKDistantIndices(test.in1, test.in2, test.in3);
            assert Objects.equals(test.expected, actual) : "findKDistantIndices(%s, %s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, test.in3, actual, test.expected);
        }
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>(nums.length);
        int lastAddedIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int startIdx = Math.max(Math.max(0, i - k), lastAddedIndex + 1);
                int endIdx = Math.min(i + k, nums.length - 1);
                for (; startIdx <= endIdx; startIdx++) {
                    result.add(startIdx);
                    lastAddedIndex = startIdx;
                }
            }
        }
        return result;
    }

}