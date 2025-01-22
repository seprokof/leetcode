import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, int expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, 7, 0, 7, -8, null, null }), 2),
                new TestCase(makeTree(new Integer[] { 989, null, 10250, 98693, -89388, null, null, null, -32127 }), 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxLevelSum(test.in);
            assert test.expected == actual : "maxLevelSum(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> currentLayer = new LinkedList<>();
        currentLayer.offer(root);
        int maxLevel = 1;
        int max = root.val;
        for (int level = 1; !currentLayer.isEmpty(); level++) {
            int sum = 0;
            int currentLevelSize = currentLayer.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = currentLayer.poll();
                sum += node.val;
                if (node.left != null) {
                    currentLayer.offer(node.left);
                }
                if (node.right != null) {
                    currentLayer.offer(node.right);
                }
            }
            if (max < sum) {
                max = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
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