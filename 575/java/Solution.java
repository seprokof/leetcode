import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 2, 2, 3, 3 }, 3),
                new TestCase(new int[] { 1, 1, 2, 3 }, 2),
                new TestCase(new int[] { 6, 6, 6, 6 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.distributeCandies(test.in);
            assert test.expected == actual : "distributeCandies(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int distributeCandies(int[] candyType) {
        Set<Integer> types = new HashSet<>(candyType.length);
        for (int type : candyType) {
            types.add(type);
        }
        return Math.min(candyType.length / 2, types.size());
    }

}