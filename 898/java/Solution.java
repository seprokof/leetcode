import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0 }, 1),
                new TestCase(new int[] { 1, 1, 2 }, 3),
                new TestCase(new int[] { 1, 2, 4 }, 6)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.subarrayBitwiseORs(test.in);
            assert test.expected == actual : "subarrayBitwiseORs(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        for (int x : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(x);
            for (int y : current) {
                next.add(y | x);
            }
            current = next;
            result.addAll(current);
        }
        return result.size();
    }

}