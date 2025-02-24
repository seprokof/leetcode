import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int[] expected) {}
        
        TestCase[] tests = {
                new TestCase(4, new int[] { 2, 2 }),
                new TestCase(37, new int[] { 37, 1 }),
                new TestCase(122122, new int[] { 427, 286 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.constructRectangle(test.in);
            assert Arrays.equals(test.expected, actual) : "constructRectangle(%s) == %s, want %s".formatted(test.in,
                    Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] constructRectangle(int area) {
        for (int w = (int) Math.sqrt(area); w >= 0; w--) {
            if (area % w == 0) {
                return new int[] { area / w, w };
            }
        }
        return null;
    }

}