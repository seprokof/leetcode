import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 4, 2, 3 }, new int[] { 3, 2, 5, 4 }),
                new TestCase(new int[] { 2, 5 }, new int[] { 5, 2 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.numberGame(Arrays.copyOf(test.in, test.in.length));
            assert Arrays.equals(test.expected, actual) : "numberGame(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] numberGame(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    swap(nums, i, j);
                }
            }
        }
        for (int i = 0; i < nums.length; i += 2) {
            swap(nums, i, i + 1);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}