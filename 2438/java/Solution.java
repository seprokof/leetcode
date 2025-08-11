import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private static final int MODULO = 1_000_000_007;

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(15, new int[][] { { 0, 1 }, { 2, 2 }, { 0, 3 } }, new int[] { 2, 4, 64 }),
                new TestCase(2, new int[][] { { 0, 0 } }, new int[] { 2 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.productQueries(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "productQueries(%s, %s) = %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] productQueries(int n, int[][] queries) {
        String binaryN = Integer.toBinaryString(n);
        List<Integer> powers = new ArrayList<>();
        for (int i = binaryN.length() - 1; i >= 0; i--) {
            if (binaryN.charAt(i) == '1') {
                powers.add(1 << (binaryN.length() - 1 - i));
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long res = 1;
            int[] query = queries[i];
            for (int j = query[0]; j <= query[1]; j++) {
                res = res * powers.get(j) % MODULO;
            }
            result[i] = (int) res;
        }
        return result;
    }

}