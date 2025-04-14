import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int in3, int in4, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 0, 1, 1, 9, 7 }, 7, 2, 3, 4),
                new TestCase(new int[] { 1, 1, 2, 2, 3 }, 0, 0, 1, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countGoodTriplets(test.in1, test.in2, test.in3, test.in4);
            assert test.expected == actual : "countGoodTriplets(%s, %s, %s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, test.in3, test.in4, actual, test.expected);
        }
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

}