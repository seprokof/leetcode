import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<Integer> in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(List.of(-1, 1, 2, 3, 1), 2, 3),
                new TestCase(List.of(-6, 2, 5, -2, -7, -1, 3), -2, 10)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countPairs(test.in1, test.in2);
            assert test.expected == actual : "countPairs(%s, %s) == %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int countPairs(List<Integer> nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            Integer n = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                if (n + nums.get(j) < target) {
                    result++;
                }
            }
        }
        return result;
    }

}