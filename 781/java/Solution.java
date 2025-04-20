import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 2 }, 5),
                new TestCase(new int[] { 10, 10, 10 }, 11)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numRabbits(test.in);
            assert test.expected == actual : "numRabbits(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int numRabbits(int[] answers) {
        int[] answerFrequency = new int[1000];
        int result = 0;
        for (int answer : answers) {
            answerFrequency[answer]++;
            if (answerFrequency[answer] == 1) {
                result += (answer + 1);
            }
            if (answerFrequency[answer] == answer + 1) {
                answerFrequency[answer] = 0;
            }
        }
        return result;
    }

}