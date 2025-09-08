import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(2, new int[] { 1, 1 }),
                new TestCase(11, new int[] { 2, 9 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.getNoZeroIntegers(test.in);
            assert isValidResult(actual, test.in) : "getNoZeroIntegers(%s) = %s, want something like %s"
                    .formatted(test.in, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    private static boolean isValidResult(int[] arr, int expected) {
        if (arr == null || arr.length != 2) {
            return false;
        }
        if (!isValidNum(arr[0]) || !isValidNum(arr[1])) {
            return false;
        }
        return arr[0] + arr[1] == expected;
    }

    private static boolean isValidNum(int value) {
        return value > 0 && !String.valueOf(value).contains("0");
    }

    public int[] getNoZeroIntegers(int n) {
        int a = 0;
        for (int value = n, multiplier = 1; value > 0; multiplier *= 10) {
            int digit = value % 10;
            if (digit > 1) {
                a += (--digit * multiplier);
                value /= 10;
            } else if (value > 9) {
                a += 9 * multiplier;
                value = value / 10 - 1;
            } else {
                value /= 10;
            }
        }
        return new int[] { a, n - a };
    }

}