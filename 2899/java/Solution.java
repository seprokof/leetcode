import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, -1, -1, -1 }, List.of(2, 1, -1)),
                new TestCase(new int[] { 1, -1, 2, -1, -1 }, List.of(1, 2, 1))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.lastVisitedIntegers(test.in);
            assert Objects.equals(test.expected, actual) : "lastVisitedIntegers(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        int k = 0;
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                seen.addFirst(num);
                k = 0;
            } else {
                k++;
                if (k <= seen.size()) {
                    ans.add(seen.get(k - 1));
                } else {
                    ans.add(-1);
                }
            }
        }
        return ans;
    }

}