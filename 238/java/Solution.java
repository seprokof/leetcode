import java.util.Arrays;

class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4 }, new int[] { 24, 12, 8, 6 }),
                new TestCase(new int[] { -1, 1, 0, -3, 3 }, new int[] { 0, 0, 9, 0, 0 })
                };
        // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			int[] actual = s.productExceptSelf(test.in);
			assert Arrays.equals(test.expected, actual) : "productExceptSelf(%s) == %s, want %s"
					.formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
		}
	}

	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}
		int suffixProduct = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] *= suffixProduct * nums[i + 1];
			suffixProduct *= nums[i + 1];
		}
		return result;
	}

}