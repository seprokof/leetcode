import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 2, 5 }, new int[] { 3, 5, 4 }, 1),
                new TestCase(new int[] { 3, 6, 1 }, new int[] { 6, 4, 7 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numOfUnplacedFruits(test.in1, test.in2);
            assert test.expected == actual : "numOfUnplacedFruits(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result = fruits.length;
        for (int fruit : fruits) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruit <= baskets[j]) {
                    baskets[j] = 0;
                    result--;
                    break;
                }
            }
        }
        return result;
    }

}