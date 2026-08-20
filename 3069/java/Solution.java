import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 1, 3 }, new int[] { 2, 3, 1 }),
                new TestCase(new int[] { 5, 4, 3, 8 }, new int[] { 5, 3, 4, 8 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.resultArray(test.in);
            assert Arrays.equals(test.expected, actual) : "resultArray(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0;
        int j = n - 1;
        result[i] = nums[0];
        result[j] = nums[1];
        for (int k = 2; k < n; k++) {
            if (result[i] > result[j]) {
                result[++i] = nums[k];
            } else {
                result[--j] = nums[k];
            }
        }
        i = n - 1;
        while (j < i) {
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
            i--;
            j++;
        }
        return result;
    }

}