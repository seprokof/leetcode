import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 5),
                new TestCase(new int[] { 1, 3, 7, 11, 12, 14, 18 }, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.lenLongestFibSubseq(test.in);
            assert test.expected == actual : "lenLongestFibSubseq(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int lenLongestFibSubseq(int[] arr) {
        int[][] lengths = new int[arr.length][arr.length];
        int max = 0;
        for (int curr = 2; curr < arr.length; curr++) {
            int left = 0;
            int right = curr - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum > arr[curr]) {
                    right--;
                } else if (sum < arr[curr]) {
                    left++;
                } else {
                    lengths[right][curr] = lengths[left][right] + 1;
                    max = Math.max(max, lengths[right][curr]);
                    left++;
                    right--;
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }

}