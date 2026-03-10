import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, int in2, String expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "d", "b", "c", "b", "c", "a" }, 2, "a"),
                new TestCase(new String[] { "aaa", "aa", "a" }, 1, "aaa"),
                new TestCase(new String[] { "a", "b", "a" }, 3, "")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.kthDistinct(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "kthDistinct(%s, %s) = '%s', want '%s'"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequency = new HashMap<>(arr.length);
        for (String str : arr) {
            frequency.merge(str, 1, Integer::sum);
        }
        for (int i = 0; i < arr.length; i++) {
            if (frequency.get(arr[i]) == 1) {
                k--;
                if (k == 0) {
                    return arr[i];
                }
            }
        }
        return "";
    }

}