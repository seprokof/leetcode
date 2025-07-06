class Solution {

    private static final String ADD = "add";
    private static final String COUNT = "count";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, String[] in3, Object[] in4, Object[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 2, 2, 2, 3 }, new int[] { 1, 4, 5, 2, 5, 4 }, new String[] { COUNT, ADD, COUNT, COUNT, ADD, ADD, COUNT }, new Object[] { 7, new int[] { 3, 2 }, 8, 4, new int[] { 0, 1 }, new int[] { 1, 1 }, 7 }, new Object[] { 8, null, 2, 1, null, null, 11 })
                };
         // @formatter:on

        for (TestCase test : tests) {
            FindSumPairs fsp = new FindSumPairs(test.in1, test.in2);
            for (int i = 0; i < test.in3.length; i++) {
                if (ADD.equals(test.in3[i])) {
                    int[] addArgs = (int[]) test.in4[i];
                    fsp.add(addArgs[0], addArgs[1]);
                } else if (COUNT.equals(test.in3[i])) {
                    int actual = fsp.count((int) test.in4[i]);
                    assert (int) test.expected[i] == actual : "count(%s) == %s, want %s".formatted(test.in4[i], actual,
                            test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in3[i]));
                }
            }
        }
    }

}