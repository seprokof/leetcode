import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 1, 3 }, new int[] { 5, 7 }, 15),
                new TestCase(new int[] { 3, 5, 2, 6 }, new int[] { 3, 1, 7 }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minNumber(test.in1, test.in2);
            assert test.expected == actual : "minNumber(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int minNumber(int[] nums1, int[] nums2) {
        int[] frequency = new int[10];
        int min1 = 10;
        for (int num : nums1) {
            frequency[num]++;
            min1 = Math.min(min1, num);
        }
        int min2 = 10;
        for (int num : nums2) {
            frequency[num]++;
            min2 = Math.min(min2, num);
        }
        for (int i = 0; i < 10; i++) {
            if (frequency[i] == 2) {
                return i;
            }
        }
        if (min1 < min2) {
            return min1 * 10 + min2;
        } else {
            return min2 * 10 + min1;
        }
    }

}