import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 0, 2 }, 5),
                new TestCase(new int[] { 1, 2, 2 }, 4)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.candy(test.in);
            assert test.expected == actual : "candy(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        count[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            count[i] = 1;
            if (ratings[i] > ratings[i - 1]) {
                count[i] += count[i - 1];
            }
        }
        int result = 0;
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                count[i - 1] = Math.max(count[i] + 1, count[i - 1]);
            }
            result += count[i - 1];
        }
        return result + count[ratings.length - 1];
    }

}