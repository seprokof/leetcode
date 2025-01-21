import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in, ListNode expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 1, 2, 3, 4, 5 }), makeList(new int[] { 1, 3, 5, 2, 4 })),
                new TestCase(makeList(new int[] { 2, 1, 3, 5, 6, 4, 7 }), makeList(new int[] { 2, 3, 6, 7, 1, 5, 4 }))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            ListNode actual = s.oddEvenList(test.in);
            assert Objects.equals(test.expected, actual) : "oddEvenList(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oddTail = head;
        ListNode evenHead = oddTail.next;
        ListNode evenTail = evenHead;
        while (evenTail != null && evenTail.next != null) {
            ListNode child = evenTail.next.next;
            ListNode nextOdd = evenTail.next;
            evenTail.next = child;
            evenTail = evenTail.next;
            oddTail.next = nextOdd;
            oddTail = oddTail.next;
        }
        oddTail.next = evenHead;
        return head;
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