import java.util.Arrays;
import java.util.Objects;

class Solution {

    private static final String EQUILATERAL = "equilateral";
    private static final String ISOSCELES = "isosceles";
    private static final String SCALENE = "scalene";
    private static final String NONE = "none";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, String expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 3, 3, 3 }, EQUILATERAL),
                new TestCase(new int[] { 3, 4, 5 }, SCALENE)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.triangleType(test.in);
            assert Objects.equals(test.expected, actual) : "triangleType(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public String triangleType(int[] nums) {
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return EQUILATERAL;
        }
        if (nums[0] + nums[1] <= nums[2] || nums[1] + nums[2] <= nums[0] || nums[0] + nums[2] <= nums[1]) {
            return NONE;
        }
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            return ISOSCELES;
        }
        return SCALENE;
    }

}