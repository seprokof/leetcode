import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 4, 4 }, List.of()),
                new TestCase(new int[] { 1, 4, 3, 8, 5 }, List.of(1, 3))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.findPeaks(test.in);
            List<Integer> actualCopy = new ArrayList<>();
            actualCopy.addAll(actual);
            Collections.sort(actualCopy);
            assert Objects.equals(test.expected, actualCopy) : "findPeaks(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>(mountain.length / 2);
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                result.add(i);
                i++;
            }
        }
        return result;
    }

}