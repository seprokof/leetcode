import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(6, 10, 4),
                new TestCase(10, 15, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countPrimeSetBits(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "countPrimeSetBits(%s, %s) = %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                result++;
            }
        }
        return result;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}