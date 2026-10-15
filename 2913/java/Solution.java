import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<Integer> in, int expected) {}

        TestCase[] tests = {
                new TestCase(List.of(1, 2, 1), 15),
                new TestCase(List.of(1, 1), 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.sumCounts(test.in);
            assert test.expected == actual : "sumCounts(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int sumCounts(List<Integer> nums) {
        Set<Integer> unique = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                unique.add(nums.get(j));
                result += unique.size() * unique.size();
            }
            unique.clear();
        }
        return result;
    }

}