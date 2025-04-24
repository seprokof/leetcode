import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, -3, 4 }, 1, 6, 2),
                new TestCase(new int[] { 3, -4, 5, 1, -2 }, -4, 5, 4),
                new TestCase(new int[] { 4, -7, 2 }, 3, 6, 0),
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfArrays(test.in1, test.in2, test.in3);
            assert test.expected == actual : "numberOfArrays(%s, %s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, test.in3, actual, test.expected);
        }
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int current = 0;
        int minSeqElem = current;
        int maxSeqElem = current;
        for (int diff : differences) {
            current += diff;
            minSeqElem = Math.min(minSeqElem, current);
            maxSeqElem = Math.max(maxSeqElem, current);
            if (maxSeqElem - minSeqElem > upper - lower) {
                return 0;
            }
        }
        return (upper - lower + 1) - (maxSeqElem - minSeqElem);
    }

}