import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    private static final String BUZZ = "Buzz";
    private static final String FIZZ = "Fizz";
    private static final String FIZZBUZZ = FIZZ + BUZZ;

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, List<String> expected) {}
        
        TestCase[] tests = {
                new TestCase(3, List.of("1", "2", FIZZ)),
                new TestCase(5, List.of("1", "2", FIZZ, "4", BUZZ)),
                new TestCase(15, List.of("1", "2", FIZZ, "4", BUZZ, FIZZ, "7", "8", FIZZ, BUZZ, "11", FIZZ, "13", "14", FIZZBUZZ))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.fizzBuzz(test.in);
            assert Objects.equals(test.expected, actual) : "fizzBuzz(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add(FIZZBUZZ);
            } else if (i % 3 == 0) {
                result.add(FIZZ);
            } else if (i % 5 == 0) {
                result.add(BUZZ);
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

}