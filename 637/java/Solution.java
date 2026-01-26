import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, List<Double> expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 3, 9, 20, null, null, 15, 7 }), List.of(3.0d, 14.5d, 11.0d)),
                new TestCase(makeTree(new Integer[] { 3, 9, 20, 15, 7 }), List.of(3.0d, 14.5d, 11.0d))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Double> actual = s.averageOfLevels(test.in);
            assert Objects.equals(test.expected, actual) : "averageOfLevels(%s) == %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        List<Double> result = new ArrayList<>();
        while ((size = queue.size()) > 0) {
            double levelSum = 0d;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelSum / size);
        }
        return result;
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