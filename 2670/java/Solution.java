import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, new int[] { -3, -1, 1, 3, 5 }),
                new TestCase(new int[] { 3, 2, 3, 4, 2 }, new int[] { -2, -1, 0, 2, 3 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.distinctDifferenceArray(test.in);
            assert Arrays.equals(test.expected, actual) : "distinctDifferenceArray(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] distinctDifferenceArray(int[] nums) {
        int[] firstPositions = new int[51];
        int[] lastPositions = new int[51];
        for (int i = 0; i < 51; i++) {
            firstPositions[i] = -1;
            lastPositions[i] = -1;
        }
        int rightDistinct = 0;
        for (int i = 0; i < nums.length; i++) {
            if (firstPositions[nums[i]] == -1) {
                rightDistinct++;
                firstPositions[nums[i]] = i;
            }
            lastPositions[nums[i]] = i;
        }
        int leftDistinct = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (firstPositions[nums[i]] == i) {
                leftDistinct++;
            }
            if (lastPositions[nums[i]] == i) {
                rightDistinct--;
            }
            result[i] = leftDistinct - rightDistinct;
        }
        return result;
    }

}