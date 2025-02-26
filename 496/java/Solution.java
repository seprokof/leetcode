import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }, new int[] { -1, 3, -1 }),
                new TestCase(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 }, new int[] { 3, -1 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.nextGreaterElement(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "nextGreaterElement(%s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] elemToIdx = new int[10001];
        for (int i = 0; i < nums2.length; i++) {
            elemToIdx[nums2[i]] = i;
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            for (int j = elemToIdx[nums1[i]] + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }

}