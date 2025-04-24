class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(13, 4),
                new TestCase(2, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countLargestGroup(test.in);
            assert test.expected == actual : "countLargestGroup(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int countLargestGroup(int n) {
        int[] groupToSize = new int[37];
        int maxSize = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int sumOfDigits = 0;
            for (int temp = i; temp > 0; temp /= 10) {
                sumOfDigits += temp % 10;
            }
            int size = groupToSize[sumOfDigits]++;
            if (maxSize == size) {
                result++;
            } else if (maxSize < size) {
                maxSize = size;
                result = 1;
            }
        }
        return result;
    }

}