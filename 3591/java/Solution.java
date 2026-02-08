import java.util.Arrays;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 5, 4 }, true),
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, false),
                new TestCase(new int[] { 2, 2, 2, 4, 4 }, true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkPrimeFrequency(test.in);
            assert test.expected == actual : "checkPrimeFrequency(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    private static final Set<Integer> PRIMES = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
            61, 67, 71, 73, 79, 83, 89, 97);

    public boolean checkPrimeFrequency(int[] nums) {
        int[] frequency = new int[101];
        for (int num : nums) {
            frequency[num]++;
        }
        for (int f : frequency) {
            if (PRIMES.contains(f)) {
                return true;
            }
        }
        return false;
    }

}