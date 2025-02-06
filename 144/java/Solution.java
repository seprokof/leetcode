import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, null, 2, 3 }), List.of(1, 2, 3)),
                new TestCase(makeTree(new Integer[] { 1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9 }), List.of(1, 2, 4, 5, 6, 7, 3, 8, 9)),
                new TestCase(makeTree(new Integer[] { }), List.of()),
                new TestCase(makeTree(new Integer[] { 1 }), List.of(1))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.preorderTraversal(test.in);
            assert Objects.equals(test.expected, actual) : "preorderTraversal(%s) == %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
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