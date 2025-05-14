import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 2, 4 }, new int[] { 2, 3 }),
                new TestCase(new int[] { 1, 1 }, new int[] { 1, 2 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.findErrorNums(test.in);
            assert Arrays.equals(test.expected, actual) : "findErrorNums(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] findErrorNums(int[] nums) {
        int[] all = new int[nums.length + 1];
        int duplicated = 0;
        for (int n : nums) {
            if (++all[n] > 1) {
                duplicated = n;
            }
        }
        for (int i = 1; i < all.length; i++) {
            if (all[i] == 0) {
                return new int[] { duplicated, i };
            }
        }
        return null;
    }

}