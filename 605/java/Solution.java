import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 0, 0, 0, 1 }, 1, true),
                new TestCase(new int[] { 1, 0, 0, 0, 1 }, 2, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canPlaceFlowers(test.in1, test.in2);
            assert test.expected == actual : "canPlaceFlowers(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int interval = 0;
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 1) {
                interval = 0;
                continue;
            }
            interval++;
            if (interval < 3 && i == 0) {
                interval++;
            }
            if (interval < 3 && i == flowerbed.length - 1) {
                interval++;
            }
            if (interval == 3) {
                n--;
                interval = 1;
            }
        }
        return n == 0;
    }

}