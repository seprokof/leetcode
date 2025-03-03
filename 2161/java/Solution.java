import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 9, 12, 5, 10, 14, 3, 10 }, 10, new int[] { 9, 5, 3, 10, 10, 12, 14 }),
                new TestCase(new int[] { -3, 4, 3, 2 }, 2, new int[] { -3, 2, 4, 3 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.pivotArray(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "pivotArray(%s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int[] left = new int[nums.length];
        int lIdx = 0;
        int[] right = new int[nums.length];
        int rIdx = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                left[lIdx++] = nums[i];
            } else if (nums[i] == pivot) {
                count++;
            } else {
                right[rIdx++] = nums[i];
            }
        }
        int[] result = new int[nums.length];
        System.arraycopy(left, 0, result, 0, lIdx);
        for (int i = 0; i < count; i++) {
            result[lIdx + i] = pivot;
        }
        System.arraycopy(right, 0, result, lIdx + count, rIdx);
        return result;
    }

}