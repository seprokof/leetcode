import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, 2, 3, 4, 5, 6 }), 110),
                new TestCase(makeTree(new Integer[] { 1, null, 2, 3, 4, null, null, 5, 6 }), 90)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxProduct(test.in);
            assert test.expected == actual : "maxProduct(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    private static final long MODULO = 1_000_000_007L;

    public int maxProduct(TreeNode root) {
        long treeSum = sumTree(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        long result = 0L;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            long subTreeSum = (treeSum - node.val) * node.val;
            result = Math.max(result, subTreeSum);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return (int) (result % MODULO);
    }

    private static long sumTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        node.val += sumTree(node.left) + sumTree(node.right);
        return node.val;
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