class Solution {

    private static final String CTOR = "NumArray";
    private static final String SUM = "sumRange";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, int[][] in2, Integer[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { CTOR, SUM, SUM, SUM }, new int[][] { { -2, 0, 3, -5, 2, -1 }, { 0, 2 }, { 2, 5 }, { 0, 5 } }, new Integer[] { null, 1, -1, -3 })
                };
        // @formatter:on

        for (TestCase test : tests) {
            NumArray a = null;
            for (int i = 0; i < test.in1.length; i++) {
                if (CTOR.equals(test.in1[i])) {
                    a = new NumArray(test.in2[i]);
                } else if (SUM.equals(test.in1[i])) {
                    int actual = a.sumRange(test.in2[i][0], test.in2[i][1]);
                    assert test.expected[i] == actual : "sumRange(%s, %s) == %s, want %s".formatted(test.in2[i][0],
                            test.in2[i][1], actual, test.expected[i]);
                }
            }
        }
    }

}