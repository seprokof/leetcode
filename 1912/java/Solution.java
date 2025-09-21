import java.util.List;
import java.util.Objects;

class Solution {

    private static final String CTOR = "Router";
    private static final String SEARCH = "search";
    private static final String RENT = "rent";
    private static final String DROP = "drop";
    private static final String REPORT = "report";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Object[] in2, Object[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { CTOR, SEARCH, RENT, RENT, REPORT, DROP, SEARCH }, new Object[] { new Object[] { 3, new int[][] { { 0, 1, 5 }, { 0, 2, 6 }, { 0, 3, 7 }, { 1, 1, 4 }, { 1, 2, 7 }, { 2, 1, 5 } } }, new int[] { 1 }, new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] {}, new int[] { 1, 2 }, new int[] { 2 } }, new Object[] { null, List.of(1, 0, 2), null, null, List.of(List.of(0, 1), List.of(1, 2)), null, List.of(0, 1) }),
                };
        // @formatter:on

        for (TestCase test : tests) {
            MovieRentingSystem m = null;
            for (int i = 0; i < test.in1.length; i++) {
                if (CTOR.equals(test.in1[i])) {
                    Object[] arg = (Object[]) test.in2[i];
                    m = new MovieRentingSystem((int) arg[0], (int[][]) arg[1]);
                } else if (SEARCH.equals(test.in1[i])) {
                    int arg = ((int[]) test.in2[i])[0];
                    List<Integer> actual = m.search(arg);
                    assert Objects.equals((List<Integer>) test.expected[i], actual) : SEARCH
                            + "(%s) == %s, want %s".formatted(arg, actual, test.expected[i]);
                } else if (RENT.equals(test.in1[i])) {
                    int[] arg = (int[]) test.in2[i];
                    m.rent(arg[0], arg[1]);
                } else if (DROP.equals(test.in1[i])) {
                    int[] arg = (int[]) test.in2[i];
                    m.drop(arg[0], arg[1]);
                } else if (REPORT.equals(test.in1[i])) {
                    List<List<Integer>> actual = m.report();
                    assert Objects.equals((List<List<Integer>>) test.expected[i], actual) : REPORT
                            + "() == %s, want %s".formatted(actual, test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}