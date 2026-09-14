import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 0, 2, 2 }, new int[] { 1, 1, 3, 3 }, true),
                new TestCase(new int[] { 0, 0, 1, 1 }, new int[] { 1, 0, 2, 1 }, false),
                new TestCase(new int[] { 0, 0, 1, 1 }, new int[] { 2, 2, 3, 3 }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isRectangleOverlap(test.in1, test.in2);
            assert test.expected == actual : "isRectangleOverlap(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec1[2] > rec2[0] && rec1[1] < rec2[3] && rec1[3] > rec2[1];
    }

}