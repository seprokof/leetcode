class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(7, 3),
                new TestCase(2, 1),
                new TestCase(3, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.getMaximumGenerated(test.in);
            assert test.expected == actual : "getMaximumGenerated(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            int j = i / 2;
            arr[i] = arr[j];
            if (i % 2 != 0) {
                arr[i] += arr[j + 1];
            }
            result = Math.max(result, arr[i]);
        }
        return result;
    }

}