import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, new int[] { 2, 4 }, 2),
                new TestCase(new int[] { 1, 2, 3, 6 }, new int[] { 2, 3, 4, 5 }, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.getCommon(test.in1, test.in2);
            assert test.expected == actual : "getCommon(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int getCommon(int[] nums1, int[] nums2) {
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }

}