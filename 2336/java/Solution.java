class Solution {

    private static final String ADD = "addBack";
    private static final String POP = "popSmallest";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Integer[] in2, Integer[] expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { ADD, POP, POP, POP, ADD, POP, POP, POP }, new Integer[] { 2, null, null, null, 1, null, null, null }, new Integer[] { null, 1, 2, 3, null, 1, 4, 5 })
                };
         // @formatter:on

        for (TestCase test : tests) {
            SmallestInfiniteSet s = new SmallestInfiniteSet();
            for (int i = 0; i < test.in1.length; i++) {
                if (ADD.equals(test.in1[i])) {
                    s.addBack(test.in2[i]);
                } else if (POP.equals(test.in1[i])) {
                    int actual = s.popSmallest();
                    assert test.expected[i] == actual : POP + "() == %s, want %s".formatted(actual, test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}