import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, 0, 1, 0, 1, 0, 1 }), 22),
                new TestCase(makeTree(new Integer[] { 0 }), 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.sumRootToLeaf(test.in);
            assert test.expected == actual : "sumRootToLeaf(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum = (currentSum << 1) + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
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