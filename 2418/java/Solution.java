import java.util.Arrays;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, int[] in2, String[] expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "Mary", "John", "Emma" }, new int[] { 180, 165, 170 }, new String[] { "Mary", "Emma", "John" }),
                new TestCase(new String[] { "Alice","Bob","Bob" }, new int[] { 155, 185, 150 }, new String[] { "Bob", "Alice", "Bob" })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String[] actual = s.sortPeople(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "sortPeople(%s, %s) = %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        NavigableMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }
        String[] result = new String[heights.length];
        int i = 0;
        for (String name : map.sequencedValues()) {
            result[i++] = name;
        }
        return result;
    }

}