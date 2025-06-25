import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, 2, 3, 4, 5 }), 3),
                new TestCase(makeTree(new Integer[] { 1, 2 }), 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.diameterOfBinaryTree(test.in);
            assert test.expected == actual : "diameterOfBinaryTree(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        process(root);
        return max;
    }

    private int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMaxDepth = process(node.left);
        int rightMaxDepth = process(node.right);
        max = Math.max(max, leftMaxDepth + rightMaxDepth);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
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