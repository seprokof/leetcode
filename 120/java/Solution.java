import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<List<Integer>> in, int expected) {}

        TestCase[] tests = {
                new TestCase(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)), 11),
                new TestCase(List.of(List.of(-10)), -10)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumTotal(test.in);
            assert test.expected == actual : "minimumTotal(%s) = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> currentLevel = triangle.getLast();
        int[] dp = new int[currentLevel.size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = currentLevel.get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            currentLevel = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = currentLevel.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

}