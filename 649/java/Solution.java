import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("RD", "Radiant"),
                new TestCase("RDD", "Dire")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.predictPartyVictory(test.in);
            assert test.expected.equals(actual) : "predictPartyVictory(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int i = 0;
        for (; i < senate.length(); i++) {
            (senate.charAt(i) == 'R' ? radiant : dire).offer(i);
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            (radiant.poll() < dire.poll() ? radiant : dire).offer(i++);
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

}