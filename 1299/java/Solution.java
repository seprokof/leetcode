import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 17, 18, 5, 4, 6, 1 }, new int[] { 18, 6, 6, 6, 1, -1 }),
                new TestCase(new int[] { 400 }, new int[] { -1 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.replaceElements(Arrays.copyOf(test.in, test.in.length));
            assert Arrays.equals(test.expected, actual) : "replaceElements(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i > -1; i--) {
            int current = arr[i];
            arr[i] = max;
            max = Math.max(max, current);
        }
        return arr;
    }

}