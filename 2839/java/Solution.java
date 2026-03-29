class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase("abcd", "cdab", true),
                new TestCase("abcd", "dacb", false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canBeEqual(test.in1, test.in2);
            assert test.expected == actual : "canBeEqual('%s', '%s') = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public boolean canBeEqual(String s1, String s2) {
        if (s1.charAt(0) != s2.charAt(0)) {
            if (s1.charAt(0) != s2.charAt(2) || s1.charAt(2) != s2.charAt(0)) {
                return false;
            }
        } else {
            if (s1.charAt(2) != s2.charAt(2)) {
                return false;
            }
        }
        if (s1.charAt(1) != s2.charAt(1)) {
            if (s1.charAt(1) != s2.charAt(3) || s1.charAt(3) != s2.charAt(1)) {
                return false;
            }
        } else {
            if (s1.charAt(3) != s2.charAt(3)) {
                return false;
            }
        }
        return true;
    }

}