import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 1, 2, 3 }, new int[] { 2, 3, 4, 1 }),
                new TestCase(new int[] { 2, 1 }, new int[] { 2, 1 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.sortEvenOdd(Arrays.copyOf(test.in, test.in.length));
            assert Arrays.equals(test.expected, actual) : "sortEvenOdd(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] sortEvenOdd(int[] nums) {
        int[] even = new int[101];
        int[] odd = new int[101];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[nums[i]]++;
            } else {
                odd[nums[i]]++;
            }
        }
        for (int i = 0, j = 0; i < nums.length; i += 2) {
            while (even[j] == 0) {
                j++;
            }
            nums[i] = j;
            even[j]--;
        }
        for (int i = 1, j = 100; i < nums.length; i += 2) {
            while (odd[j] == 0) {
                j--;
            }
            nums[i] = j;
            odd[j]--;
        }
        return nums;
    }

}