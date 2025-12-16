import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(1, 22, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22)),
                new TestCase(47, 85, List.of(48, 55, 66, 77))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.selfDividingNumbers(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "selfDividingNumbers(%s, %s) = %s, want %s"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isSelfDividingNumber(int num) {
        int val = num;
        while (val != 0) {
            int digit = val % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            val /= 10;
        }
        return true;
    }

}