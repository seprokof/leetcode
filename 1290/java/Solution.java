class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in, int expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 1, 0, 1 }), 5),
                new TestCase(makeList(new int[] { 0 }), 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.getDecimalValue(test.in);
            assert test.expected == actual : "getDecimalValue(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    private static ListNode makeList(int[] values) {
        ListNode node = null;
        for (int i = values.length - 1; i >= 0; i--) {
            node = new ListNode(values[i], node);
        }
        return node;
    }

}