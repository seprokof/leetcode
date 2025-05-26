class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, 6),
                new TestCase(new int[] { 1, 2, 3, 4 }, 24),
                new TestCase(new int[] { -1, -2, -3 }, -6)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumProduct(test.in);
            assert test.expected == actual : "maximumProduct(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max3 * max2 * max1, min1 * min2 * max1);
    }

}