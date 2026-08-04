import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 4, 2, 5 }, List.of(3)),
                new TestCase(new int[] { 7, 8, 6, 9 }, List.of()),
                new TestCase(new int[] { 5, 1 }, List.of(2, 3, 4))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.findMissingElements(test.in);
            assert Objects.equals(test.expected, actual) : "findMissingElements(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        boolean[] existing = new boolean[101];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            existing[num] = true;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!existing[i]) {
                result.add(i);
            }
        }
        return result;
    }

}