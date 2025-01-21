import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in, ListNode expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 1, 2, 3, 4, 5 }), makeList(new int[] { 5, 4, 3, 2, 1 })),
                new TestCase(makeList(new int[] { 1, 2 }), makeList(new int[] { 2, 1 })),
                new TestCase(makeList(new int[] { }), makeList(new int[] { }))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            ListNode actual = s.reverseList(test.in);
            assert Objects.equals(test.expected, actual) : "reverseList(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public ListNode reverseList(ListNode head) {
        return reverseListRecursive(head);
        // return reverseListIterative(head);
    }

    private static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversed = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

    private static ListNode reverseListIterative(ListNode head) {
        ListNode next = null;
        ListNode current = head;
        while (current != null) {
            ListNode child = current.next;
            current.next = next;
            next = current;
            current = child;
        }
        return next;
    }

    private static ListNode makeList(int[] values) {
        ListNode head = null;
        ListNode previous = null;
        for (int value : values) {
            ListNode current = new ListNode(value);
            if (head == null) {
                head = current;
            } else {
                previous.next = current;
            }
            previous = current;
        }
        return head;
    }

}