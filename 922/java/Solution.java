import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 2, 5, 7 }),
                new TestCase(new int[] { 2, 3 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.sortArrayByParityII(Arrays.copyOf(test.in, test.in.length));
            assert isResultValid(test.in, actual) : "sortArrayByParityII(%s) == %s".formatted(Arrays.toString(test.in),
                    Arrays.toString(actual));
        }
    }

    private static boolean isResultValid(int[] in, int[] actual) {
        if (in.length != actual.length) {
            return false;
        }
        int[] frequency = new int[1001];
        for (int v : in) {
            frequency[v]++;
        }
        for (int i = 0; i < actual.length; i++) {
            if (i % 2 != actual[i] % 2) {
                return false;
            }
            frequency[actual[i]]--;
        }
        for (int f : frequency) {
            if (f != 0) {
                return false;
            }
        }
        return true;
    }

    public int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];
        int even = 0;
        int odd = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[even] = nums[i];
                even += 2;
            } else {
                result[odd] = nums[i];
                odd += 2;
            }
        }
        return result;
    }

}