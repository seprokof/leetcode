import java.util.List;

class Solution {

    private static final String FIND = "find";
    private static final String CHANGE = "change";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, List<Integer>[] in2, Integer[] expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { FIND, CHANGE, CHANGE, CHANGE, CHANGE, FIND, CHANGE, FIND }, new List[] { List.of(10), List.of(2, 10), List.of(1, 10), List.of(3, 10), List.of(5, 10), List.of(10), List.of(1, 20), List.of(10) }, new Integer[] { -1, null, null, null, null, 1, null, 2 })
                };
         // @formatter:on

        for (TestCase test : tests) {
            NumberContainers nc = new NumberContainers();
            for (int i = 0; i < test.in1.length; i++) {
                if (FIND.equals(test.in1[i])) {
                    int actual = nc.find(test.in2[i].getFirst());
                    assert test.expected[i] == actual : FIND
                            + "(%s) == %s, want %s".formatted(test.in2[i].getFirst(), actual, test.expected[i]);
                } else if (CHANGE.equals(test.in1[i])) {
                    List<Integer> arg = test.in2[i];
                    nc.change(arg.getFirst(), arg.getLast());
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}