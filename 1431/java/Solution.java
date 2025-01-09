import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, List<Boolean> expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[]{ 2, 3, 5, 1, 3 }, 3, List.of(true, true, true, false, true)),
                new TestCase(new int[]{ 4, 2, 1, 1, 2 }, 1, List.of(true, false, false, false, false)),
                new TestCase(new int[]{ 12, 1, 12 }, 10, List.of(true, false, true))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Boolean> actual = s.kidsWithCandies(test.in1, test.in2);
            assert test.expected.equals(actual) : "kidsWithCandies(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(i -> (i + extraCandies) >= max).toList();
    }

}