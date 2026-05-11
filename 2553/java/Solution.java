import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 13, 25, 83, 77 }, new int[] { 1, 3, 2, 5, 8, 3, 7, 7 }),
                new TestCase(new int[] { 7, 1, 3, 9 }, new int[] { 7, 1, 3, 9 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.separateDigits(test.in);
            assert Arrays.equals(test.expected, actual) : "separateDigits(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] separateDigits(int[] nums) {
        int count = 0;
        for (int num : nums) {
            while (num > 0) {
                count++;
                num /= 10;
            }
        }
        int[] result = new int[count--];
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            while (num > 0) {
                result[count--] = num % 10;
                num /= 10;
            }
        }
        return result;
    }

}