import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<Integer> in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(List.of(2, 3, 5, 7), new int[] { -1, 1, 4, 3 }),
                new TestCase(List.of(11, 13, 31), new int[] { 9, 12, 15 })
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.minBitwiseArray(test.in);
            assert Arrays.equals(test.expected, actual) : "minBitwiseArray(%s) = %s, want %s".formatted(test.in,
                    Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < ans.length; i++) {
            int num = nums.get(i);
            int n = 1;
            ans[i] = -1;
            while ((num & n) != 0) {
                ans[i] = num - n;
                n <<= 1;
            }
        }
        return ans;
    }

}