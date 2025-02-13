import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 5, 19, 8, 1 }, 3),
                new TestCase(new int[] { 3, 8, 20 }, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.halveArray(test.in);
            assert test.expected == actual : "halveArray(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int halveArray(int[] nums) {
        Queue<Float> queue = new PriorityQueue<>((o1, o2) -> Float.compare(o2, o1));
        double sum = 0;
        for (int n : nums) {
            queue.offer((float) n);
            sum += n;
        }
        double targetSum = sum / 2;
        int i = 0;
        while (sum > targetSum) {
            i++;
            float next = queue.poll() / 2;
            sum -= next;
            queue.offer(next);
        }
        return i;
    }

}