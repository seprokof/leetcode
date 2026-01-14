import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4 }, new int[] { 2, 4, 1, 3 }, true),
                new TestCase(new int[] { 7 }, new int[] { 7 }, true),
                new TestCase(new int[] { 3, 7, 9 }, new int[] { 3, 7, 11 }, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canBeEqual(test.in1, test.in2);
            assert test.expected == actual : "canBeEqual(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] frequency = new int[1001];
        for (int i = 0; i < target.length; i++) {
            frequency[target[i]]++;
            frequency[arr[i]]--;
        }
        for (int f : frequency) {
            if (f != 0) {
                return false;
            }
        }
        return true;
    }

}