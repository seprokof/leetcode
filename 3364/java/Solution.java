import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<Integer> in1, int in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase(List.of(3, -2, 1, 4), 2, 3, 1),
                new TestCase(List.of(-2, 2, -3, 1), 2, 3, -1),
                new TestCase(List.of(1, 2, 3, 4), 2, 4, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumSumSubarray(test.in1, test.in2, test.in3);
            assert test.expected == actual : "minimumSumSubarray(%s, %s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, test.in3, actual, test.expected);
        }
    }

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] prefSum = new int[nums.size() + 1];
        for (int i = 0; i < nums.size(); i++) {
            prefSum[i + 1] = prefSum[i] + nums.get(i);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.size() - l; i++) {
            for (int j = i + l; j <= i + r && j <= nums.size(); j++) {
                int sum = prefSum[j] - prefSum[i];
                if (sum > 0) {
                    result = Math.min(result, sum);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}