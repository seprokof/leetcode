import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in1, TreeNode in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 3, 4, 5, 1, 2 }), makeTree(new Integer[] { 4, 1, 2 }), true),
                new TestCase(makeTree(new Integer[] { 3, 4, 5, 1, 2, null, null, null, null, 0 }), makeTree(new Integer[] { 4, 1, 2 }), false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isSubtree(test.in1, test.in2);
            assert test.expected == actual : "isSubtree(%s, %s) == %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val && equals(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean equals(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null) {
            return tree2 == null;
        }
        if (tree2 == null) {
            return false;
        }
        return tree1.val == tree2.val && equals(tree1.left, tree2.left) && equals(tree1.right, tree2.right);
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