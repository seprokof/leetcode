import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in, ListNode expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 1, 2, 3, 4, 5 }), makeList(new int[] { 3, 4, 5 })),
                new TestCase(makeList(new int[] { 1, 2, 3, 4, 5, 6 }), makeList(new int[] { 4, 5, 6 }))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            ListNode actual = s.middleNode(test.in);
            assert Objects.equals(test.expected, actual) : "middleNode(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

}