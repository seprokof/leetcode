class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in, int expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 5, 4, 2, 1 }), 6),
                new TestCase(makeList(new int[] { 4, 2, 2, 3 }), 7),
                new TestCase(makeList(new int[] { 1, 100000 }), 100001)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.pairSum(test.in);
            assert test.expected == actual : "pairSum(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int pairSum(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        ListNode reversedHead = null;
        while (right != null && right.next != null) {
            right = right.next.next;
            ListNode next = left.next;
            left.next = reversedHead;
            reversedHead = left;
            left = next;
        }
        int max = 0;
        for (; left != null; left = left.next, reversedHead = reversedHead.next) {
            max = Math.max(max, left.val + reversedHead.val);
        }
        return max;
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