import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 4, 8, 5, 0, 1, null, 6 }), 5),
                new TestCase(makeTree(new Integer[] { 1 }), 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.averageOfSubtree(test.in);
            assert test.expected == actual : "averageOfSubtree(%s) == %s, want any of %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int averageOfSubtree(TreeNode root) {
        return dfs(root)[2];
    }

    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0, 0 };
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int sum = left[0] + node.val + right[0];
        int count = left[1] + 1 + right[1];
        int averageCount = left[2] + right[2] + (sum / count == node.val ? 1 : 0);
        return new int[] { sum, count, averageCount };
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