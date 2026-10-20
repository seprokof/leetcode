import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<Integer> in, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(List.of(10, 30, 20, 10), List.of(20, 30)),
                new TestCase(List.of(100, 100), List.of())
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.toggleLightBulbs(test.in);
            assert Objects.equals(test.expected, actual) : "toggleLightBulbs(%s) == %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] state = new boolean[101];
        for (Integer bulb : bulbs) {
            state[bulb] = !state[bulb];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            if (state[i]) {
                result.add(i);
            }
        }
        return result;
    }

}