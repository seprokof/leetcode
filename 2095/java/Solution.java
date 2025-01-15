class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in, ListNode expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 1, 3, 4, 7, 1, 2, 6 }), makeList(new int[] { 1, 3, 4, 1, 2, 6 })),
                new TestCase(makeList(new int[] { 1, 2, 3, 4 }), makeList(new int[] { 1, 2, 4 })),
                new TestCase(makeList(new int[] { 2, 1 }), makeList(new int[] { 2 }))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            ListNode actual = s.deleteMiddle(copyList(test.in));
            assert test.expected.equals(actual) : "deleteMiddle(%s) == %s, want %s".formatted(toString(test.in),
                    toString(actual), toString(test.expected));
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head.next.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        left.next = left.next.next;
        return head;
    }

    private static ListNode makeList(int[] values) {
        ListNode node = null;
        for (int i = values.length - 1; i >= 0; i--) {
            node = new ListNode(values[i], node);
        }
        return node;
    }

    private static ListNode copyList(ListNode list) {
        ListNode current = list;
        ListNode head = null;
        ListNode node = null;
        while (current != null) {
            ListNode nextNode = new ListNode(current.val);
            if (node != null) {
                node.next = nextNode;
            } else {
                head = nextNode;
            }
            node = nextNode;
            current = current.next;
        }
        return head;
    }

    private static String toString(ListNode list) {
        if (list == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        ListNode current = list;
        while (current != null) {
            sb.append(" ").append(current.val);
            current = current.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

}