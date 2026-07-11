import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 10, 2, 5, 3 }, true),
                new TestCase(new int[] { 3, 1, 7, 11 }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkIfExist(test.in);
            assert test.expected == actual : "checkIfExist(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> unique = new HashSet<>();
        for (int i : arr) {
            if (unique.contains(i * 2) || (i % 2 == 0 && unique.contains(i / 2))) {
                return true;
            }
            unique.add(i);
        }
        return false;
    }

}