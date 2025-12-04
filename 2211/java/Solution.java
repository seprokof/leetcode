class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("RLRSLL", 5),
                new TestCase("LLRR", 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countCollisions(test.in);
            assert test.expected == actual : "countCollisions('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int countCollisions(String directions) {
        int left = 0;
        int right = directions.length() - 1;
        while (left <= right && directions.charAt(left) == 'L') {
            left++;
        }
        while (right >= left && directions.charAt(right) == 'R') {
            right--;
        }
        int result = 0;
        for (; left <= right; left++) {
            if (directions.charAt(left) != 'S') {
                result++;
            }
        }
        return result;
    }

}