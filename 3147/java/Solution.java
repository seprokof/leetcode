import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 2, -10, -5, 1 }, 3, 3),
                new TestCase(new int[] { -2, -3, -1 }, 2, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumEnergy(test.in1, test.in2);
            assert test.expected == actual : "maximumEnergy(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = energy.length - k; i < energy.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j -= k) {
                sum += energy[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

}