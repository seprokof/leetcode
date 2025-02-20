import java.util.Arrays;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, Set<String> expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { "01", "10" }, Set.of("00", "11")),
                new TestCase(new String[] { "00", "01" }, Set.of("10", "11")),
                new TestCase(new String[] { "111", "011", "001" }, Set.of("000", "010", "100", "101", "110"))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.findDifferentBinaryString(test.in);
            assert test.expected.contains(actual) : "findDifferentBinaryString(%s) == '%s', want '%s'"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder(nums.length);
        for (int i = 0; i < nums.length; i++) {
            result.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return result.toString();
    }

}