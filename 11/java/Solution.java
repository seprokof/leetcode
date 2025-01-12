import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }, 49),
                new TestCase(new int[] { 1, 1 }, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxArea(test.in);
            assert test.expected == actual : "maxArea(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int maxArea(int[] height) {
        int max = 0;
        int leftIdx = 0;
        int rightIdx = height.length - 1;
        while (leftIdx < rightIdx) {
            int minHeight = Math.min(height[leftIdx], height[rightIdx]);
            max = Math.max(max, minHeight * (rightIdx - leftIdx));
            while (leftIdx < rightIdx && height[leftIdx] <= minHeight) {
                leftIdx++;
            }
            while (leftIdx < rightIdx && height[rightIdx] <= minHeight) {
                rightIdx--;
            }
        }
        return max;
    }

}