import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 6, 4 }, new int[] { 9, 7, 5 }, 3),
                new TestCase(new int[] { 10 }, new int[] { 5 }, -5),
                new TestCase(new int[] { 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.addedInteger(test.in1, test.in2);
            assert test.expected == actual : "addedInteger(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = nums1[0];
        int min2 = nums2[0];
        for (int i = 1; i < nums1.length; i++) {
            min1 = Math.min(min1, nums1[i]);
            min2 = Math.min(min2, nums2[i]);
        }
        return min2 - min1;
    }

}