import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, new int[] { 2, 1, 4, 3, 9, 6 }, new int[] { 2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19 }),
                new TestCase(new int[] { 28, 6, 22, 8, 44, 17 }, new int[] { 22, 28, 8, 6 }, new int[] { 22, 28, 8, 6, 17, 44 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.relativeSortArray(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "relativeSortArray(%s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] frequency = new int[1001];
        for (int n : arr1) {
            frequency[n]++;
        }
        int[] result = new int[arr1.length];
        int i = 0;
        for (int j = 0; j < arr2.length; j++) {
            int n = arr2[j];
            while (frequency[n] > 0) {
                result[i++] = n;
                frequency[n]--;
            }
        }
        for (int n = 0; n < frequency.length && i < arr1.length; n++) {
            while (frequency[n] > 0) {
                result[i++] = n;
                frequency[n]--;
            }
        }
        return result;
    }

}