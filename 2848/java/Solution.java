import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<List<Integer>> in, int expected) {}

        TestCase[] tests = {
                new TestCase(List.of(List.of(3, 6), List.of(1, 5), List.of(4, 7)), 7),
                new TestCase(List.of(List.of(1, 3), List.of(5, 8)), 7)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfPoints(test.in);
            assert test.expected == actual : "numberOfPoints(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int numberOfPoints(List<List<Integer>> nums) {
        int[] line = new int[102];
        for (List<Integer> n : nums) {
            line[n.getFirst()]++;
            line[n.getLast() + 1]--;
        }
        int result = 0;
        for (int i = 1; i < line.length; i++) {
            line[i] += line[i - 1];
            if (line[i] > 0) {
                result++;
            }
        }
        return result;
    }

}