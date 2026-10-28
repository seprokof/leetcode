class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("IloveLe3tcode!", true),
                new TestCase("Me+You--IsMyDream", false),
                new TestCase("1aB!", false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.strongPasswordCheckerII(test.in);
            assert test.expected == actual : "strongPasswordCheckerII('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (i > 0 && ch == password.charAt(i - 1)) {
                return false;
            }
            if (ch >= 'a' && ch <= 'z') {
                hasLowercase = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                hasUppercase = true;
            } else if (ch >= '0' && ch <= '9') {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }
        return hasLowercase && hasUppercase && hasDigit && hasSpecialChar;
    }

}