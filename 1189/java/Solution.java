class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("nlaebolko", 1),
                new TestCase("loonbalxballpoon", 2),
                new TestCase("leetcode", 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxNumberOfBalloons(test.in);
            assert test.expected == actual : "maxNumberOfBalloons('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int maxNumberOfBalloons(String text) {
        int[] frequency = new int[5];
        int min = Integer.MAX_VALUE;
        for (char letter : text.toCharArray()) {
            switch (letter) {
                case 'a' -> frequency[0]++;
                case 'b' -> frequency[1]++;
                case 'n' -> frequency[2]++;
                case 'l' -> frequency[3]++;
                case 'o' -> frequency[4]++;
            }
        }
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, frequency[i]);
        }
        for (int i = 3; i < 5; i++) {
            min = Math.min(min, frequency[i] / 2);
        }
        return min;
    }

}