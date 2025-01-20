class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 100, 80, 60, 70, 60, 75, 85 }, new int[] { 1, 1, 1, 2, 1, 4, 6 })
                };
        // @formatter:on

        for (TestCase test : tests) {
            StockSpanner stockSpanner = new StockSpanner();
            for (int i = 0; i < test.in.length; i++) {
                int actual = stockSpanner.next(test.in[i]);
                assert test.expected[i] == actual : "next(%s) == %s, want %s".formatted(test.in[i], actual,
                        test.expected[i]);
            }

        }
    }

}