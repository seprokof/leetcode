import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 1 }, 3),
                new TestCase(new int[] { 0, 1, 2, 2 }, 3),
                new TestCase(new int[] { 1, 2, 3, 2, 2 }, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.totalFruit(test.in);
            assert test.expected == actual : "totalFruit(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int totalFruit(int[] fruits) {
        int fruitLast = -1;
        int countLast = 0;
        int fruitPrev = -1;
        int subResult = 0;
        int result = 0;
        for (int fruit : fruits) {
            if (fruit == fruitLast) {
                countLast++;
                subResult++;
            } else if (fruit == fruitPrev) {
                subResult++;
                countLast = 1;
                fruitPrev = fruitLast;
                fruitLast = fruit;
            } else {
                fruitPrev = fruitLast;
                fruitLast = fruit;
                subResult = countLast + 1;
                countLast = 1;
            }
            result = Math.max(result, subResult);
        }
        return result;
    }

}