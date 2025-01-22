import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in1, int in2, TreeNode expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 5, 3, 6, 2, 4, null, 7 }), 3, makeTree(new Integer[] { 5, 4, 6, 2, null, null, 7 })),
                new TestCase(makeTree(new Integer[] { 5, 3, 6, 2, 4, null, 7 }), 0, makeTree(new Integer[] { 5, 3, 6, 2, 4, null, 7 })),
                new TestCase(makeTree(new Integer[] { }), 0, makeTree(new Integer[] { })),
                new TestCase(makeTree(new Integer[] { 0 }), 0, makeTree(new Integer[] { })),
                new TestCase(makeTree(new Integer[] { 5,3,6,2,4,null,7 }), 5, makeTree(new Integer[] { 6,3,7,2,4})),
                new TestCase(makeTree(new Integer[] { 5,3,6,2,4,null,7 }), 7, makeTree(new Integer[] { 5,3,6,2,4}))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            TreeNode actual = s.deleteNode(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "deleteNode(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNode(root, null, key);
    }

    private TreeNode deleteNode(TreeNode node, TreeNode parent, int key) {
        if (node == null) {
            return null;
        }
        if (node.val > key) {
            deleteNode(node.left, node, key);
        } else if (node.val < key) {
            deleteNode(node.right, node, key);
        } else {
            TreeNode rebalanced = null;
            if (node.left != null && node.right != null) {
                rebalanced = node.right;
                TreeNode leftChild = node.left;
                while (node.right.left != null) {
                    node.right = node.right.left;
                }
                node.right.left = leftChild;
            } else if (node.right == null) {
                rebalanced = node.left;
            } else {
                rebalanced = node.right;
            }
            if (parent == null) {
                return rebalanced;
            }
            if (parent.val > node.val) {
                parent.left = rebalanced;
            } else {
                parent.right = rebalanced;
            }
        }
        return node;
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