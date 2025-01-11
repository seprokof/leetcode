import java.util.Arrays;

class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, true),
                new TestCase(new int[] { 5, 4, 3, 2, 1 }, false),
                new TestCase(new int[] { 2, 1, 5, 0, 4, 6 }, true)
                };
        // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			boolean actual = s.increasingTriplet(test.in);
			assert test.expected == actual
					: "increasingTriplet(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual, test.expected);
		}
	}

	public boolean increasingTriplet(int[] nums) {
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= first) {
				first = n;
			} else if (n <= second) {
				second = n;
			} else {
				return true;
			}
		}
		return false;
	}

}