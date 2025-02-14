class Solution {

    private static final String ADD = "add";
    private static final String GET = "getProduct";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Integer[] in2, Object[] expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { ADD, ADD, ADD, ADD, ADD, GET, GET, GET, ADD, GET }, new Integer[] { 3, 0, 2, 5, 4, 2, 3, 4, 8, 2 }, new Object[] { null, null, null, null, null, 20, 40, 0, null, 32 })
                };
         // @formatter:on

        for (TestCase test : tests) {
            ProductOfNumbers p = new ProductOfNumbers();
            for (int i = 0; i < test.in1.length; i++) {
                if (ADD.equals(test.in1[i])) {
                    p.add(test.in2[i]);
                } else if (GET.equals(test.in1[i])) {
                    int actual = p.getProduct(test.in2[i]);
                    assert (int) test.expected[i] == actual : GET
                            + "(%s) == %s, want %s".formatted(test.in2[i], actual, test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}