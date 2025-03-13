import java.util.Arrays;

class Solution {

    private static final String GOLD = "Gold Medal";
    private static final String SILVER = "Silver Medal";
    private static final String BRONZE = "Bronze Medal";
    private static final String[] MEDALS = new String[] { GOLD, SILVER, BRONZE };

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, String[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 4, 3, 2, 1 }, new String[] { GOLD, SILVER, BRONZE, "4", "5" }),
                new TestCase(new int[] { 10, 3, 8, 9, 4 }, new String[] { GOLD, "5", BRONZE, SILVER, "4" })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String[] actual = s.findRelativeRanks(test.in);
            assert Arrays.equals(test.expected, actual) : "findRelativeRanks(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public String[] findRelativeRanks(int[] score) {
        int maxScore = 0;
        for (int s : score) {
            maxScore = Math.max(maxScore, s);
        }
        int[] scoreToIdx = new int[maxScore + 1];
        for (int i = 0; i < score.length; i++) {
            scoreToIdx[score[i]] = i + 1;
        }
        String[] result = new String[score.length];
        int place = 1;
        for (int i = maxScore; i >= 0; i--) {
            if (scoreToIdx[i] > 0) {
                if (place < 4) {
                    result[scoreToIdx[i] - 1] = MEDALS[place - 1];
                } else {
                    result[scoreToIdx[i] - 1] = String.valueOf(place);
                }
                place++;
            }
        }
        return result;
    }

}