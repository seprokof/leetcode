import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 100, 3001, 3002 }, new int[] { 1, 2, 3, 3 })
                };
        // @formatter:on
        RecentCounter rc = new RecentCounter();

        for (TestCase test : tests) {
            int[] actual = new int[test.expected.length];
            for (int i = 0; i < test.in.length; i++) {
                actual[i] = rc.ping(test.in[i]);
                assert test.expected[i] == actual[i] : "%s -> ping -> %s, want %s".formatted(Arrays.toString(test.in),
                        Arrays.toString(actual), Arrays.toString(test.expected));
            }
        }
    }

}