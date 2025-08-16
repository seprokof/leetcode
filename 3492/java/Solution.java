class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase(2, 3, 15, 4),
                new TestCase(3, 5, 20, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxContainers(test.in1, test.in2, test.in3);
            assert test.expected == actual : "maxContainers(%s, %s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    test.in3, actual, test.expected);
        }
    }

    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n, maxWeight / w);
    }

}