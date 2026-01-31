import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(char[] in1, char in2, char expected) {}

        TestCase[] tests = {
                new TestCase(new char[] { 'c', 'f', 'j' }, 'a', 'c'),
                new TestCase(new char[] { 'c', 'f', 'j' }, 'c', 'f'),
                new TestCase(new char[] { 'x', 'x', 'y', 'y' }, 'z', 'x')
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            char actual = s.nextGreatestLetter(test.in1, test.in2);
            assert test.expected == actual : "nextGreatestLetter(%s, '%s') = '%s', want '%s'"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public char nextGreatestLetter(char[] letters, char target) {
        for (char ch = (char) (target + 1); ch <= 'z'; ch++) {
            if (Arrays.binarySearch(letters, ch) > -1) {
                return ch;
            }
        }
        return letters[0];
    }

}