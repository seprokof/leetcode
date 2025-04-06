import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, Set<List<Integer>> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, Set.of(List.of(1, 2), List.of(1, 3))),
                new TestCase(new int[] { 1, 2, 4, 8 }, Set.of(List.of(1, 2, 4, 8))),
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.largestDivisibleSubset(test.in);
            boolean foundGood = false;
            for (List<Integer> expected : test.expected) {
                foundGood |= Objects.equals(new HashSet<>(expected), new HashSet<>(actual));
            }
            assert foundGood : "largestDivisibleSubset(%s) == %s, want any of %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] prev = new int[nums.length];
        Arrays.fill(prev, -1);
        int maxIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < (dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = maxIdx; i >= 0; i = prev[i]) {
            result.add(nums[i]);
        }
        return result;
    }

}