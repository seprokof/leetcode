import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in1, int in2, ListNode expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 1, 2, 3, 4, 5 }), 2, makeList(new int[] { 4, 5, 1, 2, 3 })),
                new TestCase(makeList(new int[] { 0, 1, 2 }), 4, makeList(new int[] { 2, 0, 1 }))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            ListNode actual = s.rotateRight(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "rotateRight(%s, %s) = %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    private static ListNode makeList(int[] values) {
        ListNode node = null;
        for (int i = values.length - 1; i >= 0; i--) {
            node = new ListNode(values[i], node);
        }
        return node;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode current = head;
        int count = 1;
        for (; current.next != null; current = current.next) {
            count++;
        }
        current.next = head;
        current = head;
        for (int i = 0; i < count - (k %= count) - 1; i++) {
            current = current.next;
        }
        ListNode nHead = current.next;
        current.next = null;
        return nHead;
    }

}