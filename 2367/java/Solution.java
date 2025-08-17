import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 1, 4, 6, 7, 10 }, 3, 2),
                new TestCase(new int[] { 4, 5, 6, 7, 8, 9 }, 2, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.arithmeticTriplets(test.in1, test.in2);
            assert test.expected == actual : "arithmeticTriplets(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int d1 = nums[j] - nums[i];
                if (d1 == diff) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int d2 = nums[k] - nums[j];
                        if (d1 <= d2) {
                            if (d1 == d2) {
                                result++;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

}