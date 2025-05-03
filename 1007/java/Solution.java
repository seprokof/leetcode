import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 }, 2),
                new TestCase(new int[] { 3, 5, 1, 2, 3 }, new int[] { 3, 6, 3, 3, 4 }, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minDominoRotations(test.in1, test.in2);
            assert test.expected == actual : "minDominoRotations(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] tFreq = new int[7]; // top frequency
        int[] bFreq = new int[7]; // bottom frequency
        int[] dFreq = new int[7]; // doubles frequency
        for (int i = 0; i < tops.length; i++) {
            int top = tops[i];
            int bottom = bottoms[i];
            tFreq[top]++;
            bFreq[bottom]++;
            if (top == bottom) {
                dFreq[top]++;
            }
        }
        for (int i = 1; i < tFreq.length; i++) {
            if (tFreq[i] + bFreq[i] - dFreq[i] == tops.length) {
                return Math.min(tFreq[i], bFreq[i]) - dFreq[i];
            }
        }
        return -1;
    }

}