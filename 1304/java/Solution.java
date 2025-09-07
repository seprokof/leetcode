import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(5, new int[] { -7, -1, 1, 3, 4 }),
                new TestCase(3, new int[] { -1, 0, 1 }),
                new TestCase(1, new int[] { 0 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.sumZero(test.in);
            assert verifyResult(actual, test.expected.length) : "sumZero(%s) = %s, want something like %s"
                    .formatted(test.in, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    private static boolean verifyResult(int[] arr, int expectedLength) {
        if (arr.length != expectedLength) {
            return false;
        }
        int sum = 0;
        Set<Integer> uniqueValues = new HashSet<>(arr.length);
        for (int value : arr) {
            if (!uniqueValues.add(value)) {
                return false;
            }
            sum += value;
        }
        return sum == 0;
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n % 2 != 0) {
            result[0] = 0;
        }
        for (int value = n / 2; n > 1; n -= 2, value--) {
            result[n - 1] = value;
            result[n - 2] = -value;
        }
        return result;
    }

}