import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[] in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(10, new int[] { 3, 9, 19, 5, 21 }, true),
                new TestCase(5, new int[] { 4, 9, 23, 4 }, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.asteroidsDestroyed(test.in1, Arrays.copyOf(test.in2, test.in2.length));
            assert test.expected == actual : "asteroidsDestroyed(%s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int asteroid : asteroids) {
            if (asteroid > m) {
                return false;
            }
            m += asteroid;
        }
        return true;
    }

}