import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 1, 1, 0 }, new int[] { 0, 1 }),
                new TestCase(new int[] { 0, 3, 2, 1, 3, 2 }, new int[] { 2, 3 }),
                new TestCase(new int[] { 7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2 }, new int[] { 4, 5 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.getSneakyNumbers(test.in);
            assert containsSame(test.expected, actual) : "getSneakyNumbers(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    private static boolean containsSame(int[] left, int[] right) {
        if (left.length != right.length) {
            return false;
        }
        Set<Integer> set1 = Arrays.stream(left).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(right).boxed().collect(Collectors.toSet());
        return set1.equals(set2);
    }

    public int[] getSneakyNumbers(int[] nums) {
        int[] result = new int[2];
        int idx = 0;
        for (int i = 0; i < nums.length && idx < 2; i++) {
            for (int j = i + 1; j < nums.length && idx < 2; j++) {
                if (nums[i] == nums[j]) {
                    result[idx++] = nums[i];
                    break;
                }
            }
        }
        return result;
    }

}