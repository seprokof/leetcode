import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 2, 4 }, new int[] { 3, 1, 2, 4 }, new int[] { 0, 2, 3, 4 }),
                new TestCase(new int[] { 2, 3, 1 }, new int[] { 3, 1, 2 }, new int[] { 0, 1, 3 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.findThePrefixCommonArray(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "findThePrefixCommonArray(%s, %s) = %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] frequency = new int[n + 1];
        int commonCount = 0;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (++frequency[A[i]] == 2) {
                commonCount++;
            }
            if (++frequency[B[i]] == 2) {
                commonCount++;
            }
            result[i] = commonCount;
        }
        return result;
    }

}