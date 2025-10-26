class Solution {

    private static final String CTOR = "Bank";
    private static final String DEPOSIT = "deposit";
    private static final String TRANSFER = "transfer";
    private static final String WITHDRAW = "withdraw";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Object[] in2, Boolean[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { CTOR, WITHDRAW, TRANSFER, DEPOSIT, TRANSFER, WITHDRAW }, new Object[] { new long[] { 10L, 100L, 20L, 50L, 30L }, new Object[] { 3, 10L }, new Object[] { 5, 1, 20L }, new Object[] { 5, 20L }, new Object[] { 3, 4, 15L }, new Object[] { 10, 50L } }, new Boolean[] { null, true, true, true, false, false }),
                };
        // @formatter:on

        for (TestCase test : tests) {
            Bank b = null;
            for (int i = 0; i < test.in1.length; i++) {
                if (CTOR.equals(test.in1[i])) {
                    b = new Bank((long[]) test.in2[i]);
                } else if (DEPOSIT.equals(test.in1[i])) {
                    Object[] arg = (Object[]) test.in2[i];
                    boolean actual = b.deposit((int) arg[0], (long) arg[1]);
                    assert test.expected[i] == actual : DEPOSIT
                            + "(%s, %s) == %s, want %s".formatted(arg[0], arg[1], actual, test.expected[i]);
                } else if (TRANSFER.equals(test.in1[i])) {
                    Object[] arg = (Object[]) test.in2[i];
                    boolean actual = b.transfer((int) arg[0], (int) arg[1], (long) arg[2]);
                    assert test.expected[i] == actual : TRANSFER
                            + "(%s, %s, %s) == %s, want %s".formatted(arg[0], arg[1], arg[2], actual, test.expected[i]);
                } else if (WITHDRAW.equals(test.in1[i])) {
                    Object[] arg = (Object[]) test.in2[i];
                    boolean actual = b.withdraw((int) arg[0], (long) arg[1]);
                    assert test.expected[i] == actual : WITHDRAW
                            + "(%s, %s) == %s, want %s".formatted(arg[0], arg[1], actual, test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}