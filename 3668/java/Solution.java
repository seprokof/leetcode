import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 1, 2, 5, 4 }, new int[] { 1, 3, 4 }, new int[] { 3, 1, 4 }),
                new TestCase(new int[] { 1, 4, 5, 3, 2 }, new int[] { 2, 5 }, new int[] { 5, 2 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.recoverOrder(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "recoverOrder(%s, %s) == '%s', want '%s'".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public int[] recoverOrder(int[] order, int[] friends) {
        int[] result = new int[friends.length];
        for (int i = 0, j = 0; i < order.length && j < friends.length; i++) {
            for (int k = 0; k < friends.length; k++) {
                if (order[i] == friends[k]) {
                    result[j] = order[i];
                    j++;
                    break;
                }
            }
        }
        return result;
    }

}