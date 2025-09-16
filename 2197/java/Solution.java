import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 6, 4, 3, 2, 7, 6, 2 }, List.of(12, 7, 6)),
                new TestCase(new int[] { 2, 2, 1, 1, 3, 3, 3 }, List.of(2, 1, 1, 3))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.replaceNonCoprimes(test.in);
            assert Objects.equals(test.expected, actual) : "replaceNonCoprimes(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int current : nums) {
            while (!result.isEmpty()) {
                int gcd = gcd(current, result.getLast());
                if (gcd == 1) {
                    break;
                }
                current = (current / gcd) * result.removeLast();
            }
            result.add(current);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}