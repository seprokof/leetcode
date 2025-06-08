import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, List<Integer> expected) {}
        
        TestCase[] tests = {
                new TestCase(13, List.of(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9)),
                new TestCase(2, List.of(1, 2))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.lexicalOrder(test.in);
            assert Objects.equals(test.expected, actual) : "lexicalOrder(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        for (int i = 1; i < 10; i++) {
            traverse(result, n, i);
        }
        return result;
    }

    private static void traverse(List<Integer> list, int n, Integer value) {
        if (value > n) {
            return;
        }
        list.add(value);
        value *= 10;
        if (value > n) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            traverse(list, n, value + i);
        }
    }

}