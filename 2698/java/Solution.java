import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final Set<Integer> CACHE = new HashSet<>();
    private static Integer max = 0;

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(10, 182),
                new TestCase(37, 1478)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.punishmentNumber(test.in);
            assert test.expected == actual : "punishmentNumber(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (i <= max) {
                if (!CACHE.contains(i)) {
                    continue;
                }
                result += (i * i);
            } else {
                if (isValid(i, i * i)) {
                    CACHE.add(i);
                    max = i;
                    result += (i * i);
                }
            }
        }
        return result;
    }

    private static boolean isValid(int target, int n) {
        if (n == target) {
            return true;
        }
        for (int i = 10; i <= n; i *= 10) {
            int reminder = n % i;
            if (isValid(target - reminder, n / i)) {
                return true;
            }
        }
        return false;
    }

}