import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(537, new int[] { 500, 30, 7 }),
                new TestCase(102, new int[] { 100, 2 }),
                new TestCase(6, new int[] { 6 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.decimalRepresentation(test.in);
            assert Arrays.equals(test.expected, actual) : "decimalRepresentation(%s) == %s, want %s".formatted(test.in,
                    Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] decimalRepresentation(int n) {
        List<Integer> list = new ArrayList<>();
        for (int j = 1; n > 0; j *= 10) {
            int value = n % 10 * j;
            if (value > 0) {
                list.add(value);
            }
            n /= 10;
        }
        int len = list.size();
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = list.get(len - 1 - i);
        }
        return result;
    }

}