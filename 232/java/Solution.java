class Solution {

    private static final String EMPTY = "empty";
    private static final String PEEK = "peek";
    private static final String POP = "pop";
    private static final String PUSH = "push";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Integer[] in2, Object[] expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { PUSH, PUSH, PEEK, POP, EMPTY }, new Integer[] { 1, 2, null, null, null }, new Object[] { null, null, 1, 1, false })
                };
         // @formatter:on

        for (TestCase test : tests) {
            MyQueue q = new MyQueue();
            for (int i = 0; i < test.in1.length; i++) {
                if (EMPTY.equals(test.in1[i])) {
                    boolean actual = q.empty();
                    assert (boolean) test.expected[i] == actual : EMPTY
                            + "() == %s, want %s".formatted(actual, test.expected[i]);
                } else if (POP.equals(test.in1[i])) {
                    int actual = q.pop();
                    assert (int) test.expected[i] == actual : POP
                            + "() == %s, want %s".formatted(actual, test.expected[i]);
                } else if (PUSH.equals(test.in1[i])) {
                    q.push(test.in2[i]);
                } else if (PEEK.equals(test.in1[i])) {
                    int actual = q.peek();
                    assert (int) test.expected[i] == actual : PEEK
                            + "() == %s, want %s".formatted(actual, test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}