class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in1, ListNode in2, ListNode expected) {}

        ListNode suffix1 = makeList(new int[] { 8, 4, 5 }, null);
        ListNode suffix2 = makeList(new int[] { 2, 4 }, null);
        
        TestCase[] tests = {
                new TestCase(makeList(new int[] { 4, 1 }, suffix1), makeList(new int[] { 5, 6, 1 }, suffix1), suffix1),
                new TestCase(makeList(new int[] { 1, 9, 1 }, suffix2), makeList(new int[] { 3 }, suffix2), suffix2),
                new TestCase(makeList(new int[] { 2, 6, 4 }, null), makeList(new int[] { 1, 5 }, null), makeList(new int[] { }, null))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            ListNode actual = s.getIntersectionNode(test.in1, test.in2);
            assert test.expected == actual : "getIntersectionNode(%s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != currentB) {
            currentA = currentA == null ? headB : currentA.next;
            currentB = currentB == null ? headA : currentB.next;
        }
        return currentA;
    }

    private static ListNode makeList(int[] values, ListNode suffix) {
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
        if (suffix != null) {
            previous.next = suffix;
        }
        return head;
    }
	
}