import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) throws Exception {
      // @formatter:off
      record TestCase(int[] in1, int in2, int in3, long expected) {}

      TestCase[] tests = {
              new TestCase(new int[] { 17, 12, 10, 2, 7, 2, 11, 20, 8 }, 3, 4, 11L),
              new TestCase(new int[] { 1, 2, 4, 1 }, 3, 3, 4L)
              };
       // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.totalCost(test.in1, test.in2, test.in3);
            assert test.expected == actual : "totalCost(%s, %s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, test.in3, actual, test.expected);
        }
    }

    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> leftQueue = new PriorityQueue<>(candidates);
        Queue<Integer> rightQueue = new PriorityQueue<>(candidates);
        int leftEndIdx = 0;
        int rightStartIdx = costs.length - 1;
        long totalCost = 0;
        while (k > 0) {
            while (leftQueue.size() < candidates && leftEndIdx <= rightStartIdx) {
                leftQueue.offer(costs[leftEndIdx++]);
            }
            while (rightQueue.size() < candidates && leftEndIdx <= rightStartIdx) {
                rightQueue.offer(costs[rightStartIdx--]);
            }
            Integer leftVal = leftQueue.peek();
            Integer rightVal = rightQueue.peek();
            if (leftVal != null && rightVal != null) {
                totalCost += leftVal <= rightVal ? leftQueue.poll() : rightQueue.poll();
            } else if (leftVal != null) {
                totalCost += leftQueue.poll();
            } else {
                totalCost += rightQueue.poll();
            }
            k--;
        }
        return totalCost;
    }

}