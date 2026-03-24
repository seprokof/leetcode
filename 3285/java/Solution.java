import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, 2, List.of(3, 4)),
                new TestCase(new int[] { 10, 1, 10, 1, 10 }, 3, List.of(1, 3)),
                new TestCase(new int[] { 10, 1, 10, 1, 10 }, 10, List.of())
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.stableMountains(test.in1, test.in2);
            assert containsSame(test.expected, actual) : "stableMountains(%s, %s) = %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    private static boolean containsSame(List<Integer> one, List<Integer> two) {
        if (one.size() != two.size()) {
            return false;
        }
        return new HashSet<>(one).equals(new HashSet<>(two));
    }

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                result.add(i);
            }
        }
        return result;
    }

}