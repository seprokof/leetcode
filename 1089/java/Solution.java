import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 }, new int[] { 1, 0, 0, 2, 3, 0, 0, 4 }),
                new TestCase(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] inCopy = Arrays.copyOf(test.in, test.in.length);
            s.duplicateZeros(test.in);
            assert Arrays.equals(test.expected, test.in) : "duplicateZeros(%s) -> %s, want %s"
                    .formatted(Arrays.toString(inCopy), Arrays.toString(test.in), Arrays.toString(test.expected));
        }
    }

    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = i + zeros;
            if (pos < arr.length) {
                arr[pos] = arr[i];
            }
            if (arr[i] == 0) {
                zeros--;
                if (--pos < arr.length) {
                    arr[pos] = 0;
                }
            }
        }
    }

}