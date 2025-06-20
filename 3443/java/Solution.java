class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase("NWSE", 1, 3),
                new TestCase("NSWWEW", 3, 6)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxDistance(test.in1, test.in2);
            assert test.expected == actual : "maxDistance('%s', %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int maxDistance(String str, int k) {
        int result = 0;
        int n = 0;
        int s = 0;
        int e = 0;
        int w = 0;
        for (char ch : str.toCharArray()) {
            switch (ch) {
            case 'N' -> n++;
            case 'S' -> s++;
            case 'E' -> e++;
            case 'W' -> w++;
            }
            int vertSwaps = Math.min(Math.min(n, s), k);
            int horSwaps = Math.min(Math.min(e, w), k - vertSwaps);
            result = Math.max(result, Math.abs(n - s) + vertSwaps * 2 + Math.abs(e - w) + horSwaps * 2);
        }
        return result;
    }

}