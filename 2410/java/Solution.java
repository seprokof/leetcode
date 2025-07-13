import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 7, 9 }, new int[] { 8, 2, 5, 8 }, 2),
                new TestCase(new int[] { 1, 1, 1 }, new int[] { 10 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.matchPlayersAndTrainers(Arrays.copyOf(test.in1, test.in1.length),
                    Arrays.copyOf(test.in2, test.in2.length));
            assert test.expected == actual : "matchPlayersAndTrainers(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int result = 0;
        for (int i = players.length - 1, j = trainers.length - 1; i >= 0 && j >= 0; i--) {
            if (players[i] <= trainers[j]) {
                result++;
                j--;
            }
        }
        return result;
    }

}