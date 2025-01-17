import java.util.Arrays;

class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 2, 1 }, 1),
                new TestCase(new int[] { 4, 1, 2, 1, 2 }, 4),
                new TestCase(new int[] { 1 }, 1)
                };
        // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			int actual = s.singleNumber(test.in);
			assert test.expected == actual
					: "singleNumber(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual, test.expected);
		}
	}

	public int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}

}