import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase("abaac", new int[] { 1, 2, 3, 4, 5 }, 3),
                new TestCase("abc", new int[] { 1, 2, 3 }, 0),
                new TestCase("aabaa", new int[] { 1, 2, 3, 4, 1 }, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minCost(test.in1, test.in2);
            assert test.expected == actual : "minCost(%s, %s) = %s, want %s".formatted(test.in1,
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int minCost(String colors, int[] neededTime) {
        char[] colorsArr = colors.toCharArray();
        int result = 0;
        for (int i = 1; i < neededTime.length; i++) {
            if (colorsArr[i - 1] == colorsArr[i]) {
                int totalGroup = neededTime[i - 1];
                int maxInGroup = neededTime[i - 1];
                for (; i < neededTime.length && colorsArr[i - 1] == colorsArr[i]; i++) {
                    totalGroup += neededTime[i];
                    maxInGroup = Math.max(maxInGroup, neededTime[i]);
                }
                result += (totalGroup - maxInGroup);
            }

        }
        return result;
    }

}