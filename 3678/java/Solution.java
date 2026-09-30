import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 5 }, 6),
                new TestCase(new int[] { -1, 1, 2 }, 3),
                new TestCase(new int[] { 4, -1 }, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.smallestAbsent(test.in);
            assert test.expected == actual : "smallestAbsent(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int smallestAbsent(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int avg = sum / nums.length;
        int val = Math.max(avg + 1, 1);
        outer: for (;; val++) {
            for (int num : nums) {
                if (val == num) {
                    continue outer;
                }
            }
            return val;
        }
    }

}