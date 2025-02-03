import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(ListNode[] in, ListNode expected) {}

        TestCase[] tests = {
                new TestCase(new ListNode[] { makeList(new int[] { 1, 4, 5 }), makeList(new int[] { 1, 3, 4 }), makeList(new int[] { 2, 6 }) }, makeList(new int[] { 3, 1, 2, 3, 4, 4, 5, 6 })),
                new TestCase(new ListNode[] { }, makeList(new int[] { })),
                new TestCase(new ListNode[] { makeList(new int[] { }) }, makeList(new int[] { }))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            ListNode actual = s.mergeKLists(copy(test.in));
            assert Objects.equals(test.expected, actual) : "mergeKLists(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode preHead = new ListNode(-1);
        ListNode current = preHead;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(ln -> ln.val));
        for (ListNode l : lists) {
            if (l != null) {
                queue.offer(l);
            }
        }
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
            if (current.next != null) {
                queue.offer(current.next);
            }
        }
        return preHead.next;
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

    private static ListNode[] copy(ListNode[] original) {
        if (original == null) {
            return null;
        }
        ListNode[] copy = new ListNode[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = copyList(original[i]);
        }
        return copy;
    }

}