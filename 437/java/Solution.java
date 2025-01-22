import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 10, 5, -3, 3, 2, null, 11, 3, -2, null, 1 }), 8, 3),
                new TestCase(makeTree(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 }), 22, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.pathSum(test.in1, test.in2);
            assert test.expected == actual : "pathSum(%s, %s) == %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return numPaths(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int numPaths(TreeNode node, long targetSum) {
        if (node == null) {
            return 0;
        }
        targetSum -= node.val;
        return (targetSum == 0 ? 1 : 0) + numPaths(node.left, targetSum) + numPaths(node.right, targetSum);
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