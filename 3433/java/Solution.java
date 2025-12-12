import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    private static final String ALL = "ALL";
    private static final String HERE = "HERE";
    private static final String MESSAGE = "MESSAGE";
    private static final String OFFLINE = "OFFLINE";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, List<List<String>> in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(2, new ArrayList<>(Arrays.asList(List.of(MESSAGE, "10", "id1 id0"), List.of(OFFLINE, "11", "0"), List.of(MESSAGE, "71", HERE))), new int[] { 2, 2 }),
                new TestCase(2, new ArrayList<>(Arrays.asList(List.of(MESSAGE, "10", "id1 id0"), List.of(OFFLINE, "11", "0"), List.of(MESSAGE, "12", ALL))), new int[] { 2, 2 }),
                new TestCase(2, new ArrayList<>(Arrays.asList(List.of(OFFLINE, "10", "0"), List.of(MESSAGE, "12", HERE))), new int[] { 0, 1 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.countMentions(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "countMentions(%s, %s) = %s, want %s".formatted(test.in1,
                    test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events, (l, r) -> {
            int result = Integer.compare(Integer.parseInt(l.get(1)), Integer.parseInt(r.get(1)));
            return result == 0 ? r.getFirst().compareTo(l.getFirst()) : result;
        });
        int[] mentions = new int[numberOfUsers];
        int[] nextOnline = new int[numberOfUsers];
        for (List<String> event : events) {
            if (MESSAGE.equals(event.getFirst())) {
                String mention = event.getLast();
                if (ALL.equals(mention)) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                } else if (HERE.equals(mention)) {
                    int timestamp = Integer.parseInt(event.get(1));
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (nextOnline[i] <= timestamp) {
                            mentions[i]++;
                        }
                    }
                } else {
                    String[] usernames = mention.split(" ");
                    for (String username : usernames) {
                        int id = Integer.parseInt(username.substring(2));
                        mentions[id]++;
                    }
                }
            } else {
                int timestamp = Integer.parseInt(event.get(1));
                nextOnline[Integer.parseInt(event.getLast())] = timestamp + 60;
            }
        }
        return mentions;
    }

}