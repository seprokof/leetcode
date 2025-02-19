import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, String expected) {}
        
        TestCase[] tests = {
                new TestCase(1, 3, "c"),
                new TestCase(1, 4, ""),
                new TestCase(3, 9, "cab")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.getHappyString(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "getHappyString(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total) {
            return "";
        }
        List<String> happyStrings = new ArrayList<>(total);
        generateHappyString(new StringBuilder(n), n, happyStrings, k);
        return happyStrings.get(k - 1);
    }

    private static void generateHappyString(StringBuilder str, int n, List<String> result, int k) {
        if (str.length() == n) {
            result.add(str.toString());
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (str.length() == 0 || str.charAt(str.length() - 1) != ch) {
                str.append(ch);
                generateHappyString(str, n, result, k);
                if (result.size() == k) {
                    return;
                }
                str.setLength(str.length() - 1);
            }
        }
    }

}