import java.util.Arrays;
import java.util.Objects;

class Solution {

    private static final String CTOR = "Robot";
    private static final String STEP = "step";
    private static final String GET_POS = "getPos";
    private static final String GET_DIR = "getDir";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, int[][] in2, Object[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { CTOR, STEP, STEP, GET_POS, GET_DIR, STEP, STEP, STEP, GET_POS, GET_DIR }, new int[][] { { 6, 3 }, { 2 }, { 2 }, { }, { }, { 2 }, { 1 }, { 4 }, { }, { } }, new Object[] { null, null, null, new int[] { 4, 0 }, "East", null, null, null, new int[] { 1, 2 }, "West" }),
                };
        // @formatter:on

        for (TestCase test : tests) {
            Robot r = null;
            for (int i = 0; i < test.in1.length; i++) {
                if (CTOR.equals(test.in1[i])) {
                    int[] arg = test.in2[i];
                    r = new Robot(arg[0], arg[1]);
                } else if (STEP.equals(test.in1[i])) {
                    int arg = test.in2[i][0];
                    r.step(arg);
                } else if (GET_POS.equals(test.in1[i])) {
                    int[] actual = r.getPos();
                    assert Arrays.equals((int[]) test.expected[i], actual) : GET_POS + "() == %s, want %s"
                            .formatted(Arrays.toString(actual), Arrays.toString((int[]) test.expected[i]));
                } else if (GET_DIR.equals(test.in1[i])) {
                    String actual = r.getDir();
                    assert Objects.equals((String) test.expected[i], actual) : GET_DIR
                            + "() == %s, want %s".formatted(actual, test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}