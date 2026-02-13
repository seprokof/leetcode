class Solution {

    private static final String CTOR = "MyHashMap";
    private static final String GET = "get";
    private static final String PUT = "put";
    private static final String REMOVE = "remove";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Integer[][] in2, Integer[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { CTOR, PUT, PUT, GET, GET, PUT, GET, REMOVE, GET }, new Integer[][] { null, { 1, 1 }, { 2, 2 }, { 1 }, { 3 }, { 2, 1 }, { 2 }, { 2 }, { 2 } }, new Integer[] { null, null, null, 1, -1, null, 1, null, -1 }),
                };
        // @formatter:on

        for (TestCase test : tests) {
            MyHashMap m = null;
            for (int i = 0; i < test.in1.length; i++) {
                if (CTOR.equals(test.in1[i])) {
                    m = new MyHashMap();
                } else if (GET.equals(test.in1[i])) {
                    int arg = test.in2[i][0];
                    int actual = m.get(arg);
                    assert test.expected[i] == actual : GET
                            + "(%s) == %s, want %s".formatted(arg, actual, test.expected[i]);
                } else if (PUT.equals(test.in1[i])) {
                    Integer[] arg = test.in2[i];
                    m.put(arg[0], arg[1]);
                } else if (REMOVE.equals(test.in1[i])) {
                    m.remove(test.in2[i][0]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}