import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 55, 30, 5, 4, 2 }, new int[] { 100, 20, 10, 10, 5 }, 2),
                new TestCase(new int[] { 2, 2, 2 }, new int[] { 10, 10, 1 }, 1),
                new TestCase(new int[] { 30, 29, 19, 5 }, new int[] { 25, 25, 25, 25, 25 }, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxDistance(test.in1, test.in2);
            assert test.expected == actual : "maxDistance(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            int start = i;
            int end = nums2.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums2[mid] >= nums1[i]) {
                    max = Math.max(max, mid - i);
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return max;
    }

}