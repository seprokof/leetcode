import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, TreeNode expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 }), makeTree(new Integer[] { 2, 7, 4 })),
                new TestCase(makeTree(new Integer[] { 1 }), makeTree(new Integer[] { 1 })),
                new TestCase(makeTree(new Integer[] { 0, 1, 3, null, 2 }), makeTree(new Integer[] { 2 }))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            TreeNode actual = s.subtreeWithAllDeepest(test.in);
            assert Objects.equals(test.expected, actual) : "subtreeWithAllDeepest(%s) == %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node();
    }

    private record NodeWithDepth(TreeNode node, Integer depth) {
    }

    private NodeWithDepth dfs(TreeNode node) {
        if (node == null) {
            return new NodeWithDepth(null, 0);
        }
        NodeWithDepth left = dfs(node.left);
        NodeWithDepth right = dfs(node.right);
        if (left.depth() > right.depth()) {
            return new NodeWithDepth(left.node(), left.depth() + 1);
        } else if (left.depth() < right.depth()) {
            return new NodeWithDepth(right.node(), right.depth() + 1);
        } else {
            return new NodeWithDepth(node, left.depth() + 1);
        }
    }

    private static TreeNode makeTree(Integer[] values) {
        if (values.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        List<TreeNode> prevLevel = List.of(root);
        int i = 1;
        while (i < values.length) {
            List<TreeNode> currentLevel = new ArrayList<>(prevLevel.size() * 2);
            for (int j = 0; j < prevLevel.size() && i < values.length; j++) {
                if (values[i] != null) {
                    TreeNode leftNode = new TreeNode(values[i]);
                    prevLevel.get(j).left = leftNode;
                    currentLevel.add(leftNode);
                }
                i++;
                if (i < values.length) {
                    if (values[i] != null) {
                        TreeNode rightNode = new TreeNode(values[i]);
                        prevLevel.get(j).right = rightNode;
                        currentLevel.add(rightNode);
                    }
                    i++;
                }
            }
            prevLevel = currentLevel;
        }
        return root;
    }

}