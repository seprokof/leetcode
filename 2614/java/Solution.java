import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 } }, 11),
                new TestCase(new int[][] { { 1, 2, 3 }, { 5, 17, 7 }, { 9, 11, 10 } }, 17)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.diagonalPrime(test.in);
            assert test.expected == actual : "diagonalPrime(%s) == %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int diagonalPrime(int[][] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][i] > result && isPrime(nums[i][i])) {
                result = nums[i][i];
            }
            if (nums[i][nums.length - 1 - i] > result && isPrime(nums[i][nums.length - 1 - i])) {
                result = nums[i][nums.length - 1 - i];
            }
        }
        return result;
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
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