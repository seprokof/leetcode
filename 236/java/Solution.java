import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in1, TreeNode in2, TreeNode in3, TreeNode expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 }), makeTree(new Integer[] { 5 }), makeTree(new Integer[] { 1 }), makeTree(new Integer[] { 3 })),
                new TestCase(makeTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 }), makeTree(new Integer[] { 5 }), makeTree(new Integer[] { 4 }), makeTree(new Integer[] { 5 })),
                new TestCase(makeTree(new Integer[] { 1, 2 }), makeTree(new Integer[] { 1 }), makeTree(new Integer[] { 2 }), makeTree(new Integer[] { 1 }))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            TreeNode actual = s.lowestCommonAncestor(test.in1, test.in2, test.in3);
            assert test.expected.val == actual.val : "lowestCommonAncestor(%s, %s, %s) == %s, want %s"
                    .formatted(test.in1, test.in2, test.in3, actual, test.expected);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
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