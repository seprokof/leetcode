import java.util.Arrays;
import java.util.Objects;

class Solution {

    private static final String FLUSH = "Flush";
    private static final String HIGH_CARD = "High Card";
    private static final String PAIR = "Pair";
    private static final String THREE = "Three of a Kind";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, char[] in2, String expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 13, 2, 3, 1, 9 }, new char[] { 'a', 'a', 'a', 'a', 'a' }, FLUSH),
                new TestCase(new int[] { 4, 4, 2, 4, 4 }, new char[] { 'd', 'a', 'a', 'b', 'c' }, THREE),
                new TestCase(new int[] { 10, 10, 2, 12, 9 }, new char[] { 'a', 'b', 'c', 'a', 'd' }, PAIR)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.bestHand(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "bestHand(%s, %s) = '%s', want '%s'"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public String bestHand(int[] ranks, char[] suits) {
        boolean areSame = true;
        for (int i = 1; i < 5 && areSame; i++) {
            areSame &= suits[i] == suits[i - 1];
        }
        if (areSame) {
            return FLUSH;
        }
        int[] rankFrequency = new int[14];
        int maxFrequency = 0;
        for (int rank : ranks) {
            maxFrequency = Math.max(maxFrequency, ++rankFrequency[rank]);
        }
        if (maxFrequency >= 3) {
            return THREE;
        } else if (maxFrequency == 2) {
            return PAIR;
        } else {
            return HIGH_CARD;
        }
    }

}