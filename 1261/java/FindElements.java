import java.util.HashSet;

class FindElements {

    private final HashSet<Integer> values;

    public FindElements(TreeNode root) {
        this.values = new HashSet<>();
        traverse(root, 0);
    }

    private void traverse(TreeNode node, int value) {
        if (node == null) {
            return;
        }
        node.val = value;
        values.add(value);
        traverse(node.left, value * 2 + 1);
        traverse(node.right, value * 2 + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }

}
