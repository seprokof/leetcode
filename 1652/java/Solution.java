import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 7, 1, 4 }, 3, new int[] { 12, 10, 16, 13 }),
                new TestCase(new int[] { 1, 2, 3, 4 }, 0, new int[] { 0, 0, 0, 0 }),
                new TestCase(new int[] { 2, 4, 9, 3 }, -2, new int[] { 12, 5, 6, 13 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.decrypt(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "decrypt(%s, %s) = %s, want %s".formatted(
                    Arrays.toString(test.in1), test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) {
            Arrays.fill(result, 0);
        } else if (k > 0) {
            for (int i = 0; i < result.length; i++) {
                int sum = 0;
                int j = i + 1;
                for (int g = 0; g < k; g++, j++) {
                    sum += j < result.length ? code[j] : code[j - result.length];
                }
                result[i] = sum;
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                int sum = 0;
                int j = i - 1;
                for (int g = 0; g < -k; g++, j--) {
                    sum += j >= 0 ? code[j] : code[result.length + j];
                }
                result[i] = sum;
            }
        }
        return result;
    }

}