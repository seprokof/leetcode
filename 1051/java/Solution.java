import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 4, 2, 1, 3 }, 3),
                new TestCase(new int[] { 5, 1, 2, 3, 4 }, 5),
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.heightChecker(test.in);
            assert test.expected == actual : "heightChecker(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int heightChecker(int[] heights) {
        int[] heightFrequency = new int[101];
        for (int height : heights) {
            heightFrequency[height]++;
        }
        int result = 0;
        int height = 0;
        for (int i = 0; i < heights.length; i++) {
            while (heightFrequency[height] == 0) {
                height++;
            }
            if (height != heights[i]) {
                result++;
            }
            heightFrequency[height]--;
        }
        return result;
    }

}