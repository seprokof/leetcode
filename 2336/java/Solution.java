class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Integer[] in2, Integer[] expected) {}

        TestCase[] tests = {
                new TestCase(new String[] {}, new Integer[] {}, new Integer[] {})
                };
         // @formatter:on

        for (TestCase test : tests) {
            SmallestInfiniteSet s = new SmallestInfiniteSet();
            for (int i = 0; i < test.in1.length; i++) {
                if ("addBack".equals(test.in1[i])) {
                    s.addBack(test.in2[i]);
                } else if ("popSmallest".equals(test.in1[i])) {
                    int actual = s.popSmallest();
                    assert test.expected[i] == actual : "popSmallest() == %s, want %s".formatted(actual,
                            test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}