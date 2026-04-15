import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, String in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "hello", "i", "am", "leetcode", "hello" }, "hello", 1, 1),
                new TestCase(new String[] { "a", "b", "leetcode" }, "leetcode", 0, 1),
                new TestCase(new String[] { "i", "eat", "leetcode" }, "ate", 0, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.closestTarget(test.in1, test.in2, test.in3);
            assert test.expected == actual : "closestTarget(%s, '%s', %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, test.in3, actual, test.expected);
        }
    }

    public int closestTarget(String[] words, String target, int startIndex) {
        int len = words.length;
        for (int dist = 0; dist < len; dist++) {
            int right = (startIndex + dist) % len;
            if (words[right].equals(target)) {
                return dist;
            }
            int left = (startIndex - dist + len) % len;
            if (words[left].equals(target)) {
                return dist;
            }
        }
        return -1;
    }

}