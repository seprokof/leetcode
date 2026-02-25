import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, new int[] { 0, 1, 2, 4, 8, 3, 5, 6, 7 }),
                new TestCase(new int[] { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 }, new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.sortByBits(test.in);
            assert Arrays.equals(test.expected, actual) : "sortByBits(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int num : arr) {
            queue.offer(new int[] { num, Integer.bitCount(num) });
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }

}