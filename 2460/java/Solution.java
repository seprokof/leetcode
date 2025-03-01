import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 2, 1, 1, 0 }, new int[] { 1, 4, 2, 0, 0, 0 }),
                new TestCase(new int[] { 0, 1 }, new int[] { 1, 0 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.applyOperations(Arrays.copyOf(test.in, test.in.length));
            assert Arrays.equals(test.expected, actual) : "applyOperations(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] applyOperations(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] *= 2;
                    nums[i + 1] = 0;
                }
                nums[pos++] = nums[i];
            }
        }
        nums[pos++] = nums[nums.length - 1];
        for (int i = pos; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }

}