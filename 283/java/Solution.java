import java.util.Arrays;

class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 1, 0, 3, 12 }, new int[] { 1, 3, 12, 0, 0 }),
                new TestCase(new int[] { 0 }, new int[] { 0 })
                };
        // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			int[] in = Arrays.copyOf(test.in, test.in.length);
			s.moveZeroes(in);
			assert Arrays.equals(test.expected, in) : "moveZeroes(%s) -> %s, want %s"
					.formatted(Arrays.toString(test.in), Arrays.toString(in), Arrays.toString(test.expected));
		}
	}

	public void moveZeroes(int[] nums) {
		int numZeroes = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				numZeroes++;
			} else {
				nums[i - numZeroes] = nums[i];
			}
		}
		for (int i = nums.length - numZeroes; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

}