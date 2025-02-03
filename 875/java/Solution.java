import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 6, 7, 11 }, 8, 4),
                new TestCase(new int[] { 30, 11, 23, 4, 20 }, 5, 30),
                new TestCase(new int[] { 30, 11, 23, 4, 20 }, 6, 23)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minEatingSpeed(test.in1, test.in2);
            assert test.expected == actual : "minEatingSpeed(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        while (min < max) {
            int speed = min + (max - min) / 2;
            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] - 1) / speed + 1;
            }
            if (hours <= h) {
                max = speed;
            } else {
                min = speed + 1;
            }
        }
        return min;
    }

}