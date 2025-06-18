import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int[][] expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 4, 8, 7, 9, 3, 5, 1 }, 2, new int[][] { { 1, 1, 3 }, { 3, 4, 5 }, { 7, 8, 9 } }),
                new TestCase(new int[] { 2, 4, 2, 2, 5, 2 }, 2, new int[][] { }),
                new TestCase(new int[] { 4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11 }, 14, new int[][] { { 2, 2, 2 }, { 4, 5, 5 }, { 5, 5, 7 }, { 7, 8, 8 }, { 9, 9, 10 }, { 11, 12, 12 } })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = s.divideArray(Arrays.copyOf(test.in1, test.in1.length), test.in2);
            assert Arrays.deepEquals(test.expected, actual) : "divideArray(%s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), test.in2, Arrays.deepToString(actual),
                    Arrays.deepToString(test.expected));
        }
    }

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result = new int[nums.length / 3][];
        int j = 0;
        for (int i = 0; i < nums.length / 3; i++) {
            int[] arr = new int[] { nums[j++], nums[j++], nums[j++] };
            if (arr[2] - arr[0] <= k) {
                result[i] = arr;
            } else {
                return new int[][] {};
            }
        }
        return result;
    }

}