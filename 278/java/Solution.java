class Solution extends VersionControl {

    public Solution(int badVersion) {
        super(badVersion);
    }

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(5, 4),
                new TestCase(1, 1)
                };
        // @formatter:on

        for (TestCase test : tests) {
            int actual = new Solution(test.expected).firstBadVersion(test.in);
            assert test.expected == actual : "firstBadVersion(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int firstBadVersion(int n) {
        return findBadVersion(1, n);
    }

    private int findBadVersion(int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            return findBadVersion(start, mid);
        } else {
            return findBadVersion(mid + 1, end);
        }
    }

}