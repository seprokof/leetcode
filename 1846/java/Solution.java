import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 2, 1, 2, 1 }, 2),
                new TestCase(new int[] { 100, 1, 1000 }, 3),
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, 5)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumElementAfterDecrementingAndRearraging(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "maximumElementAfterDecrementingAndRearraging(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int maximumElementAfterDecrementingAndRearraging(int[] arr) {
        Arrays.sort(arr);
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max++;
            }
        }
        return max;
    }

}