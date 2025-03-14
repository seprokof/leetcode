import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, long in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 8, 6 }, 3, 5),
                new TestCase(new int[] { 2, 5 }, 11, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumCandies(test.in1, test.in2);
            assert test.expected == actual : "maximumCandies(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;
        int minPile = Integer.MAX_VALUE;
        for (int c : candies) {
            totalCandies += c;
            minPile = Math.min(minPile, c);
        }
        if (totalCandies < k) {
            return 0;
        }
        return findMax(0, (int) (totalCandies / k), candies, k);
    }

    private static int findMax(int min, int max, int[] candies, long k) {
        if (min == max) {
            return canAssignCandies(candies, k, min) ? min : -1;
        }
        int mid = min + (max - min) / 2;
        if (canAssignCandies(candies, k, mid)) {
            return Math.max(mid, findMax(mid + 1, max, candies, k));
        } else {
            return findMax(min, mid, candies, k);
        }
    }
    
    private static boolean canAssignCandies(int[] candies, long k, int perPerson) {
        if (perPerson == 0) {
            return true;
        }
        long piles = 0;
        for (int c : candies) {
            piles += c / perPerson;
            if (piles >= k) {
                return true;
            }
        }
        return false;
    }

}