import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, List<List<Integer>> expected) {}

        TestCase[] tests = {
                new TestCase(5, List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1))),
                new TestCase(1, List.of(List.of(1)))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<List<Integer>> actual = s.generate(test.in);
            assert Objects.equals(test.expected, actual) : "generate(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> prevRow = result.getLast();
            for (int j = 1; j < prevRow.size(); j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

}