import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(makeList(new int[] { 3, 1 }), new int[] { -1, -1 }),
                new TestCase(makeList(new int[] { 5, 3, 1, 2, 5, 1, 2 }), new int[] { 1, 3 }),
                new TestCase(makeList(new int[] { 1, 3, 2, 2, 3, 2, 2, 2, 7 }), new int[] { 3, 3 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.nodesBetweenCriticalPoints(test.in);
            assert Arrays.equals(test.expected, actual) : "nodesBetweenCriticalPoints(%s) == %s, want %s"
                    .formatted(test.in, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = { -1, -1 };

        int firstCrit = -1;
        int lastCrit = -1;

        ListNode previous = head;
        ListNode current = head.next;

        for (int i = 1; current.next != null; i++) {
            if ((previous.val < current.val && current.val > current.next.val)
                    || (previous.val > current.val && current.val < current.next.val)) {
                if (lastCrit == -1) {
                    lastCrit = i;
                    if (firstCrit == -1) {
                        firstCrit = i;
                    }
                } else {
                    if (result[0] == -1 || result[0] > (i - lastCrit)) {
                        result[0] = i - lastCrit;
                    }
                    result[1] = i - firstCrit;
                    lastCrit = i;
                }
            }
            previous = current;
            current = current.next;
        }
        return result;
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