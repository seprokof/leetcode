import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(char[] in, char[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new char[] { 'h', 'e', 'l', 'l', 'o' }, new char[] { 'o', 'l', 'l', 'e', 'h' }),
                new TestCase(new char[] { 'H', 'a', 'n', 'n', 'a', 'h' }, new char[] { 'h', 'a', 'n', 'n', 'a', 'H' })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            char[] inCopy = Arrays.copyOf(test.in, test.in.length);
            s.reverseString(inCopy);
            assert Arrays.equals(test.expected, inCopy) : "reverseString(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(inCopy), Arrays.toString(test.expected));
        }
    }

    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

}