import java.util.Objects;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, val);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ListNode other = (ListNode) obj;
        return Objects.equals(next, other.next) && val == other.val;
    }

    @Override
    public String toString() {
        String result = Integer.toString(val);
        if (next != null) {
            result += "->" + next;
        }
        return result;
    }

}
