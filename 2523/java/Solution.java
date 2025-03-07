import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(10, 19, new int[] { 11, 13 }),
                new TestCase(4, 6, new int[] { -1, -1 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.closestPrimes(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "closestPrimes(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] closestPrimes(int left, int right) {
        boolean[] primes = new boolean[right + 1];
        primes[0] = primes[1] = true;
        for (int i = 2; i * i <= right; i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= right; j += i) {
                    primes[j] = true;
                }
            }
        }
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[] { -1, -1 };
        Integer num = null;
        for (int i = left; i < primes.length; i++) {
            if (!primes[i]) {
                if (num != null) {
                    if (i - num < minDiff) {
                        result[0] = num;
                        result[1] = i;
                        minDiff = i - num;
                    }
                }
                num = i;
            }
        }
        return result;
    }

}