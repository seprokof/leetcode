import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, List<List<Integer>> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 2, 1, 3 }, List.of(List.of(1, 2), List.of(2, 3), List.of(3, 4))),
                new TestCase(new int[] { 1, 3, 6, 10, 15 }, List.of(List.of(1, 3))),
                new TestCase(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 }, List.of(List.of(-14, -10), List.of(19, 23), List.of(23, 27)))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<List<Integer>> actual = s.minimumAbsDifference(Arrays.copyOf(test.in, test.in.length));
            assert Objects.deepEquals(test.expected, actual) : "minimumAbsDifference(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int currentDiff = Math.abs(arr[i] - arr[i - 1]);
            if (currentDiff > diff) {
                continue;
            }
            if (currentDiff < diff) {
                diff = currentDiff;
                result.clear();
            }
            result.add(List.of(arr[i - 1], arr[i]));
        }
        return result;
    }

}