import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(1, true),
                new TestCase(10, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.reorderedPowerOf2(test.in);
            assert test.expected == actual : "reorderedPowerOf2(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean reorderedPowerOf2(int n) {
        int[] targetFreq = getDigitsFreq(n);
        for (int i = 0; i < 31; i++) {
            int[] candidateFreq = getDigitsFreq(1 << i);
            if (Arrays.equals(targetFreq, candidateFreq)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getDigitsFreq(int num) {
        int[] freq = new int[10];
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            freq[digit]++;
        }
        return freq;
    }

}