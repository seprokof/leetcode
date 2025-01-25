import java.util.Objects;

class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(ListNode in1, int in2, ListNode expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 1, 2, 3, 4, 5 }), 2, makeList(new int[] { 1, 2, 3, 5 })),
                new TestCase(makeList(new int[] { 1 }), 1, makeList(new int[] { })),
                new TestCase(makeList(new int[] { 1, 2 }), 1, makeList(new int[] { 1 }))
                };
        // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			ListNode actual = s.removeNthFromEnd(test.in1, test.in2);
			assert Objects.equals(test.expected, actual)
					: "removeNthFromEnd(%s, %s) == %s, want %s".formatted(test.in1, test.in2, actual, test.expected);
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode left = head;
		ListNode right = head;
		for (int i = 0; i < n; i++) {
			right = right.next;
		}
		if (right == null) {
			return head.next;
		}
		while (right.next != null) {
			right = right.next;
			left = left.next;
		}
		left.next = left.next.next;
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