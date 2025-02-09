class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 1, 2, 2, 1 }), true),
                new TestCase(makeList(new int[] { 1, 2 }), false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isPalindrome(test.in);
            assert test.expected == actual : "isPalindrome(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        ListNode head2 = null;
        while (left != null) {
            ListNode temp = left.next;
            left.next = head2;
            head2 = left;
            left = temp;
        }
        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
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