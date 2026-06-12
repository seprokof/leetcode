import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 1, 2, 2, 4, 4, 1 }, 2),
                new TestCase(new int[] { 4, 4, 4, 9, 2, 4 }, 4),
                new TestCase(new int[] { 29, 47, 21, 41, 13, 37, 25, 7 }, -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.mostFrequentEven(test.in);
            assert test.expected == actual : "mostFrequentEven(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int mostFrequentEven(int[] nums) {
        int[] frequency = new int[100001];
        int value = -1;
        int maxCount = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                continue;
            }
            int count = ++frequency[num];
            if (count > maxCount) {
                maxCount = count;
                value = num;
            } else if (count == maxCount && num < value) {
                value = num;
            }
        }
        return value;
    }

}