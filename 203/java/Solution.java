import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in1, int in2, ListNode expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 1, 2, 6, 3, 4, 5, 6 }), 6, makeList(new int[] { 1, 2, 3, 4, 5 })),
                new TestCase(makeList(new int[] { }), 1, makeList(new int[] { })),
                new TestCase(makeList(new int[] { 7, 7, 7, 7 }), 7, makeList(new int[] { }))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            ListNode actual = s.removeElements(copyList(test.in1), test.in2);
            assert Objects.equals(test.expected, actual) : "removeElements(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    head = current.next;
                }
            } else {
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    private static ListNode makeList(int[] values) {
        ListNode preHead = new ListNode(-1);
        ListNode previous = preHead;
        for (int value : values) {
            previous.next = new ListNode(value);
            previous = previous.next;
        }
        return preHead.next;
    }

    private static ListNode copyList(ListNode original) {
        ListNode preHead = new ListNode(-1);
        ListNode current = preHead;
        while (original != null) {
            current.next = new ListNode(original.val);
            current = current.next;
            original = original.next;
        }
        return preHead.next;
    }

}