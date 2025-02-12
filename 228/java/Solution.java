import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 1, 2, 4, 5, 7 }, List.of("0->2", "4->5", "7")),
                new TestCase(new int[] { 0, 2, 3, 4, 6, 8, 9 },  List.of("0", "2->4", "6", "8->9"))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.summaryRanges(test.in);
            assert Objects.equals(test.expected, actual) : "summaryRanges(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                result.add(start == nums[i - 1] ? String.valueOf(start) : "%s->%s".formatted(start, nums[i - 1]));
                start = nums[i];
            }
        }
        result.add(start == nums[nums.length - 1] ? String.valueOf(start)
                : "%s->%s".formatted(start, nums[nums.length - 1]));
        return result;
    }

}