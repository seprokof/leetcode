class Solution {

    private static final String CTOR = "Spreadsheet";
    private static final String GET = "getValue";
    private static final String SET = "setCell";
    private static final String RESET = "resetCell";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Object[][] in2, Integer[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { CTOR, GET, SET, GET, SET, GET, RESET, GET }, new Object[][] { { 3 }, { "=5+7" }, { "A1", 10 }, { "=A1+6" }, { "B2", 15 }, { "=A1+B2" }, { "A1" }, { "=A1+B2" } }, new Integer[] { null, 12, null, 16, null, 25, null, 15 })
                };
        // @formatter:on

        for (TestCase test : tests) {
            Spreadsheet s = null;
            for (int i = 0; i < test.in1.length; i++) {
                if (CTOR.equals(test.in1[i])) {
                    s = new Spreadsheet((int) test.in2[i][0]);
                } else if (GET.equals(test.in1[i])) {
                    int actual = s.getValue((String) test.in2[i][0]);
                    assert test.expected[i] == actual : GET
                            + "('%s') == %s, want %s".formatted(test.in2[i][0], actual, test.expected[i]);
                } else if (SET.equals(test.in1[i])) {
                    s.setCell((String) test.in2[i][0], (int) test.in2[i][1]);
                } else if (RESET.equals(test.in1[i])) {
                    s.resetCell((String) test.in2[i][0]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}