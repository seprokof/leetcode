import java.util.Objects;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}
        
        TestCase[] tests = {
                new TestCase("aaba*", "aab"),
                new TestCase("abc", "abc")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.clearStars(test.in);
            assert Objects.equals(test.expected, actual) : "clearStars('%s') == '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String clearStars(String s) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((l, r) -> l[0] == r[0] ? r[1] - l[1] : l[0] - r[0]);
        boolean[] deleted = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                deleted[queue.poll()[1]] = true;
                deleted[i] = true;
            } else {
                queue.offer(new int[] { ch, i });
            }
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (!deleted[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}