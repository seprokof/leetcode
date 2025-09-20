import java.util.Arrays;

class Solution {

    private static final String CTOR = "Router";
    private static final String ADD = "addPacket";
    private static final String FORWARD = "forwardPacket";
    private static final String GET_CNT = "getCount";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Integer[][] in2, Object[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { CTOR, ADD, ADD, ADD, ADD, ADD, FORWARD, ADD, GET_CNT }, new Integer[][] { { 3 }, { 1, 4, 90 }, { 2, 5, 90 }, { 1, 4, 90 }, { 3, 5, 95 }, { 4, 5, 105 }, { }, { 5, 2, 110 }, { 5, 100, 110 } }, new Object[] { null, true, true, false, true, true, new int[]{ 2, 5, 90 }, true, 1 }),
                new TestCase(new String[] { CTOR, ADD, FORWARD, FORWARD }, new Integer[][] { { 2 }, { 7, 4, 90 }, { }, { } }, new Object[] { null, true, new int[]{ 7, 4, 90 }, new int[]{ } })
                };
        // @formatter:on

        for (TestCase test : tests) {
            Router r = null;
            for (int i = 0; i < test.in1.length; i++) {
                if (CTOR.equals(test.in1[i])) {
                    r = new Router(test.in2[i][0]);
                } else if (ADD.equals(test.in1[i])) {
                    Integer[] arg = test.in2[i];
                    boolean actual = r.addPacket(arg[0], arg[1], arg[2]);
                    assert (boolean) test.expected[i] == actual : ADD
                            + "(%s, %s, %s) == %s, want %s".formatted(arg[0], arg[1], arg[2], actual, test.expected[i]);
                } else if (FORWARD.equals(test.in1[i])) {
                    int[] actual = r.forwardPacket();
                    assert Arrays.equals((int[]) test.expected[i], actual) : FORWARD + "() == %s, want %s"
                            .formatted(Arrays.toString(actual), Arrays.toString((int[]) test.expected[i]));
                } else if (GET_CNT.equals(test.in1[i])) {
                    Integer[] arg = test.in2[i];
                    int actual = r.getCount(arg[0], arg[1], arg[2]);
                    assert (int) test.expected[i] == actual : GET_CNT
                            + "(%s, %s, %s) == %s, want %s".formatted(arg[0], arg[1], arg[2], actual, test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}