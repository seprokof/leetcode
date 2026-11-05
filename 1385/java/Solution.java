import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 5, 8 }, new int[] { 10, 9, 1, 8 }, 2, 2),
                new TestCase(new int[] { 1, 4, 2, 3 }, new int[] { -4, -3, 6, 10, 20, 30 }, 3, 2),
                new TestCase(new int[] { 2, 1, 100, 3 }, new int[] { -5, -2, 10, -3, 7 }, 6, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findTheDistanceValue(test.in1, test.in2, test.in3);
            assert test.expected == actual : "findTheDistanceValue(%s, %s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), test.in3, actual, test.expected);
        }
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;
        for (int val1 : arr1) {
            boolean good = true;
            for (int val2 : arr2) {
                if (Math.abs(val1 - val2) <= d) {
                    good = false;
                    break;
                }
            }
            if (good) {
                result++;
            }
        }
        return result;
    }

}