import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 2, 1, 5, 6, 4 }, 2, 5),
                new TestCase(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4, 4)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findKthLargest(test.in1, test.in2);
            assert test.expected == actual : "findKthLargest(%s, %s) == '%s', want '%s'"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (heap.peek() < nums[i]) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.poll();
    }

}