import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, ListNode in2, ListNode expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, makeList(new int[] { 1, 2, 3, 4, 5 }), makeList(new int[] { 4, 5 })),
                new TestCase(new int[] { 1 }, makeList(new int[] { 1, 2, 1, 2, 1, 2 }), makeList(new int[] { 2, 2, 2 })),
                new TestCase(new int[] { 5 }, makeList(new int[] { 1, 2, 3, 4 }), makeList(new int[] { 1, 2, 3, 4 }))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            ListNode actual = s.modifiedList(test.in1, copyList(test.in2));
            assert Objects.equals(test.expected, actual) : "modifiedList(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> banned = new HashSet<>();
        for (int num : nums) {
            banned.add(num);
        }
        ListNode preHead = new ListNode(-1);
        ListNode previous = preHead;
        for (ListNode current = head; current != null; current = current.next) {
            if (!banned.contains(current.val)) {
                previous.next = current;
                previous = previous.next;
            }
        }
        previous.next = null;
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

    private static ListNode copyList(ListNode head) {
        ListNode preHead = new ListNode(-1);
        ListNode previous = preHead;
        for (ListNode current = head; current != null; current = current.next) {
            previous.next = new ListNode(current.val);
            previous = previous.next;
        }
        return preHead.next;
    }

}