class Solution {

    private static final String EMPTY = "empty";
    private static final String POP = "pop";
    private static final String PUSH = "push";
    private static final String TOP = "top";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Integer[] in2, Object[] expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { PUSH, PUSH, TOP, POP, EMPTY }, new Integer[] { 1, 2, null, null, null }, new Object[] { null, null, 2, 2, false })
                };
         // @formatter:on

        for (TestCase test : tests) {
            MyStack s = new MyStack();
            for (int i = 0; i < test.in1.length; i++) {
                if (EMPTY.equals(test.in1[i])) {
                    boolean actual = s.empty();
                    assert (boolean) test.expected[i] == actual : EMPTY
                            + "() == %s, want %s".formatted(actual, test.expected[i]);
                } else if (POP.equals(test.in1[i])) {
                    int actual = s.pop();
                    assert (int) test.expected[i] == actual : POP
                            + "() == %s, want %s".formatted(actual, test.expected[i]);
                } else if (PUSH.equals(test.in1[i])) {
                    s.push(test.in2[i]);
                } else if (TOP.equals(test.in1[i])) {
                    int actual = s.top();
                    assert (int) test.expected[i] == actual : TOP
                            + "() == %s, want %s".formatted(actual, test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}