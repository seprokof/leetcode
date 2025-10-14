import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<Integer> in1, int in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3, true),
                new TestCase(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.hasIncreasingSubarrays(test.in1, test.in2);
            assert test.expected == actual : "hasIncreasingSubarrays(%s, %s) = %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = k; i + k - 1 < nums.size(); i++) {
            if (isStrictlyIncreasing(nums, i - k, i - 1) && isStrictlyIncreasing(nums, i, i + k - 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStrictlyIncreasing(List<Integer> nums, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            if (nums.get(i - 1) >= nums.get(i)) {
                return false;
            }
        }
        return true;
    }

}