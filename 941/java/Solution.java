import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 1 }, false),
                new TestCase(new int[] { 3, 5, 5 }, false),
                new TestCase(new int[] { 0, 3, 2, 1 }, true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.validMountainArray(test.in);
            assert test.expected == actual : "validMountainArray(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == arr.length - 1) {
            return false;
        }
        while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == arr.length - 1;
    }

}