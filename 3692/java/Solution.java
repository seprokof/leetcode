import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("aaabbbccdddde", "ab"),
                new TestCase("abcd", "abcd"),
                new TestCase("pfpfgi", "fp")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.majorityFrequencyGroup(test.in);
            assert containsSame(test.expected, actual) : "majorityFrequencyGroup('%s') = '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    private static boolean containsSame(String expected, String actual) {
        char[] arr1 = expected.toCharArray();
        char[] arr2 = actual.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public String majorityFrequencyGroup(String s) {
        int[] frequency = new int[26];
        for (char letter : s.toCharArray()) {
            frequency[letter - 'a']++;
        }
        Map<Integer, StringBuilder> frequencyToGroup = new HashMap<>();
        int freq = 0;
        int maxLen = 0;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 0) {
                continue;
            }
            StringBuilder sb = frequencyToGroup.computeIfAbsent(frequency[i], ignore -> new StringBuilder());
            sb.append((char) ('a' + i));
            if (sb.length() > maxLen) {
                maxLen = sb.length();
                freq = frequency[i];
            } else if (sb.length() == maxLen) {
                freq = Math.max(freq, frequency[i]);
            }
        }
        return frequencyToGroup.get(freq).toString();
    }

}