import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, List<Boolean> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 1, 1 }, List.of(true, false, false)),
                new TestCase(new int[] { 1, 1, 1 }, List.of(false, false, false))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Boolean> actual = s.prefixesDivBy5(test.in);
            assert Objects.equals(test.expected, actual) : "prefixesDivBy5(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>(nums.length);
        int prefixRem = 0;
        for (int num : nums) {
            prefixRem = ((prefixRem << 1) + num) % 5;
            result.add(prefixRem == 0);
        }
        return result;
    }

}