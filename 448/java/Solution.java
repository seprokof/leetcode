import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, List<Integer> expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }, List.of(5, 6)),
                new TestCase(new int[] { 1, 1 }, List.of(2))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.findDisappearedNumbers(test.in);
            assert Objects.equals(test.expected, actual) : "findDisappearedNumbers(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] found = new boolean[nums.length + 1];
        for (int val : nums) {
            found[val] = true;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < found.length; i++) {
            if (!found[i]) {
                result.add(i);
            }
        }
        return result;
    }

}