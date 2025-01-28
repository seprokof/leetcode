import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int in3, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 3, 2 }, new int[] { 2, 1, 3, 4 }, 3, 12L),
                new TestCase(new int[] { 4, 2, 3, 1, 1 }, new int[] { 7, 5, 10, 9, 6 }, 1, 30L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.maxScore(test.in1, test.in2, test.in3);
            assert test.expected == actual : "maxScore(%s, %s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), test.in3, actual, test.expected);
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i] = new int[] { nums1[i], nums2[i] };
        }
        Arrays.sort(pairs, Comparator.comparing(arr -> arr[1], Comparator.reverseOrder()));
        Queue<Integer> queue = new PriorityQueue<>(k);
        long sum = 0;
        long maxScore = 0;
        for (int[] pair : pairs) {
            if (queue.size() == k) {
                sum -= queue.poll();
            }
            queue.offer(pair[0]);
            sum += pair[0];
            if (queue.size() == k) {
                maxScore = Math.max(maxScore, sum * pair[1]);
            }
        }
        return maxScore;
    }

}