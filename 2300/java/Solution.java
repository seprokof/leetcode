import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, long in3, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 1, 3 }, new int[] { 1, 2, 3, 4, 5 }, 7, new int[] { 4, 0, 3 }),
                new TestCase(new int[] { 3, 1, 2 }, new int[] { 8, 5, 8 }, 16, new int[] { 2, 0, 2 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.successfulPairs(test.in1, test.in2, test.in3);
            assert Arrays.equals(test.expected, actual) : "successfulPairs(%s, %s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), test.in3, Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            result[i] = potions.length
                    - findClosestGreater(potions, 0, potions.length - 1, Math.ceilDiv(success, spells[i]));
        }
        return result;
    }

    private int findClosestGreater(int[] arr, int left, int right, long targetValue) {
        if (left > right) {
            return arr.length;
        }
        int midIdx = (left + right) / 2;
        if (arr[midIdx] < targetValue) {
            return findClosestGreater(arr, midIdx + 1, right, targetValue);
        } else {
            return Math.min(midIdx, findClosestGreater(arr, left, midIdx - 1, targetValue));
        }
    }

}