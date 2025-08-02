import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "bella", "label", "roller" }, List.of("e", "l", "l")),
                new TestCase(new String[] { "cool", "lock", "cook" }, List.of("c", "o"))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.commonChars(test.in);
            assert areSame(test.expected, actual) : "commonChars(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public List<String> commonChars(String[] words) {
        List<int[]> frequencies = new ArrayList<>(words.length);
        for (String word : words) {
            int[] frequency = new int[26];
            for (char letter : word.toCharArray()) {
                frequency[letter - 'a']++;
            }
            frequencies.add(frequency);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int countToAdd = frequencies.getFirst()[i];
            for (int j = 1; j < words.length; j++) {
                countToAdd = Math.min(countToAdd, frequencies.get(j)[i]);
                if (countToAdd == 0) {
                    break;
                }
            }
            if (countToAdd > 0) {
                char ch = (char) ('a' + i);
                for (int j = 0; j < countToAdd; j++) {
                    result.add(String.valueOf(ch));
                }
            }
        }
        return result;
    }

    private static boolean areSame(List<String> one, List<String> two) {
        if (one == null) {
            return two == null;
        }
        if (two == null) {
            return false;
        }
        List<String> oneCopy = new ArrayList<>(one);
        Collections.sort(oneCopy);
        List<String> twoCopy = new ArrayList<>(two);
        Collections.sort(twoCopy);
        return oneCopy.equals(twoCopy);
    }

}