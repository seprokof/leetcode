import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int[][] in2, int[][] expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2 }, { 2, 3 }, { 4, 5 } }, new int[][] { { 1, 4 }, { 3, 2 }, { 4, 1 } }, new int[][] { { 1, 6 }, { 2, 3 }, { 3, 2 }, { 4, 6 } }),
                new TestCase(new int[][] { { 2, 4 }, { 3, 6 }, { 5, 5 } }, new int[][] { { 1, 3 }, { 4, 3 } }, new int[][] { { 1, 3 }, { 2, 4 }, { 3, 6 }, { 4, 3 }, { 5, 5 } })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = s.mergeArrays(test.in1, test.in2);
            assert Arrays.deepEquals(test.expected, actual) : "mergeArrays(%s, %s) == %s, want %s".formatted(
                    Arrays.deepToString(test.in1), Arrays.deepToString(test.in2), Arrays.deepToString(actual),
                    Arrays.deepToString(test.expected));
        }
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] result = new int[nums1.length + nums2.length][];
        int i = 0;
        int left = 0;
        int right = 0;
        for (; left < nums1.length && right < nums2.length; i++) {
            if (nums1[left][0] < nums2[right][0]) {
                result[i] = nums1[left++];
            } else if (nums1[left][0] == nums2[right][0]) {
                result[i] = new int[] { nums1[left][0], nums1[left++][1] + nums2[right++][1] };
            } else {
                result[i] = nums2[right++];
            }
        }
        result = Arrays.copyOf(result, i + (nums1.length - left) + (nums2.length - right));
        for (; left < nums1.length; i++) {
            result[i] = nums1[left++];
        }
        for (; right < nums2.length; i++) {
            result[i] = nums2[right++];
        }
        return result;
    }

}