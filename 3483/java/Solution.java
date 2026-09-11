import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4 }, 12L),
                new TestCase(new int[] { 0, 2, 2 }, 2L),
                new TestCase(new int[] { 6, 6, 6 }, 1L),
                new TestCase(new int[] { 1, 3, 5 }, 0L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.totalNumbers(test.in);
            assert test.expected == actual : "totalNumbers(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int totalNumbers(int[] digits) {
        int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }
        int result = 0;
        for (int i = 1; i < 10; i++) {
            frequency[i]--;
            for (int j = 0; j < 10 && frequency[i] >= 0; j++) {
                frequency[j]--;
                for (int k = 0; k < 9 && frequency[j] >= 0; k += 2) {
                    if (frequency[k] - 1 >= 0) {
                        result++;
                    }
                }
                frequency[j]++;
            }
            frequency[i]++;
        }
        return result;
    }

}