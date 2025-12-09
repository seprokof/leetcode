import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 6, 3, 6 }, 1),
                new TestCase(new int[] { 0, 1, 0, 0 }, 1),
                new TestCase(new int[] { 8, 4, 2, 8, 4 }, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.specialTriplets(test.in);
            assert test.expected == actual : "specialTriplets(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    private static final long MODULO = 1_000_000_007L;

    public int specialTriplets(int[] nums) {
        int[] leftFreq = new int[100_001];
        int[] rightFreq = new int[100_001];
        for (int num : nums) {
            rightFreq[num]++;
        }
        long result = 0L;
        for (int num : nums) {
            rightFreq[num]--;
            int value = num * 2;
            if (value <= leftFreq.length) {
                result = (result + 1L * leftFreq[value] * rightFreq[value]) % MODULO;
            }
            leftFreq[num]++;
        }
        return (int) result;
    }

}