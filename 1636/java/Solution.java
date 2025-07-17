import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 2, 2, 2, 3 }, new int[] { 3, 1, 1, 2, 2, 2 }),
                new TestCase(new int[] { 2, 3, 1, 3, 2 }, new int[] { 1, 3, 3, 2, 2 }),
                new TestCase(new int[] { -1, 1, -6, 4, 5, -6, 1, 4, 1 }, new int[] { 5, -1, 4, 4, -6, -6, 1, 1, 1 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.frequencySort(Arrays.copyOf(test.in, test.in.length));
            assert Arrays.equals(test.expected, actual) : "frequencySort(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        Integer[] boxedNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            freq[100 + nums[i]]++;
            boxedNums[i] = nums[i];
        }
        Arrays.sort(boxedNums, (l, r) -> {
            Integer lv = freq[100 + l];
            Integer rv = freq[100 + r];
            return lv.equals(rv) ? r - l : lv - rv;
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }
        return nums;
    }

}