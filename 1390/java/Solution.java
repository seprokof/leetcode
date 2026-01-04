import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 21, 4, 7 }, 32),
                new TestCase(new int[] { 21, 21 }, 64),
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.sumFourDivisors(test.in);
            assert test.expected == actual : "sumFourDivisors(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int p = (int) Math.round(Math.cbrt(num));
            if (p * p * p == num && isPrime(p)) {
                result += (1 + p + p * p + num);
                continue;
            }
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    int j = num / i;
                    if (i != j && isPrime(i) && isPrime(j)) {
                        result += 1 + i + j + num;
                    }
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}