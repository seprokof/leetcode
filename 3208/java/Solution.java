import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 1, 0, 1, 0 }, 3, 3),
                new TestCase(new int[] { 0, 1, 0, 0, 1, 0, 1 }, 6, 2),
                new TestCase(new int[] { 1, 1, 0, 1 }, 4, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfAlternatingGroups(test.in1, test.in2);
            assert test.expected == actual : "numberOfAlternatingGroups(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] arr = new int[colors.length + k - 1];
        System.arraycopy(colors, 0, arr, 0, colors.length);
        System.arraycopy(colors, 0, arr, colors.length, k - 1);
        int left = 0;
        int right = 1;
        int result = 0;
        while (right < arr.length) {
            if (arr[right] == arr[right - 1]) {
                left = right;
                right++;
            } else {
                right++;
                if (right - left == k) {
                    result++;
                    left++;
                }
            }
        }
        return result;
    }

}