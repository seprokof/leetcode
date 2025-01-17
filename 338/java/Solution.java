import java.util.Arrays;

class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(int in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(2, new int[] { 0, 1, 1 }),
                new TestCase(5, new int[] { 0, 1, 1, 2, 1, 2 })
                };
        // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			int[] actual = s.countBits(test.in);
			assert Arrays.equals(test.expected, actual) : "countBits(%s) == %s, want %s".formatted(test.in,
					Arrays.toString(actual), Arrays.toString(test.expected));
		}
	}

	public int[] countBits(int n) {
		int[] ans = new int[n + 1];
		for (int i = 1; i < ans.length; i++) {
			ans[i] = ans[i >> 1] + (i & 1);
		}
		return ans;
	}

}