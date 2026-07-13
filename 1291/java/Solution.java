import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(100, 300, List.of(123, 234)),
                new TestCase(1000, 13000, List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.sequentialDigits(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "sequentialDigits(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    private static final List<Integer> NUMS = List.of(12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789,
            1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789,
            1234567, 2345678, 3456789, 12345678, 23456789, 123456789);

    public List<Integer> sequentialDigits(int low, int high) {
        int start = 0;
        while (start < NUMS.size() && NUMS.get(start) < low) {
            start++;
        }
        int end = start;
        while (end < NUMS.size() && NUMS.get(end) <= high) {
            end++;
        }
        return NUMS.subList(start, end);
    }

}