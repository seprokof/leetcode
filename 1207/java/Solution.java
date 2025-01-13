import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 2, 1, 1, 3 }, true),
                new TestCase(new int[] { 1, 2 }, false),
                new TestCase(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 }, true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.uniqueOccurrences(test.in);
            assert test.expected == actual : "uniqueOccurrences(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = IntStream.of(arr).boxed()
                .collect(Collectors.toMap(Function.identity(), i -> 1, (l, r) -> l + r));
        return map.values().size() == Set.copyOf(map.values()).size();
    }

}