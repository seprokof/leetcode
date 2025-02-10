import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, 2, 3, null, 5 }), List.of("1->2->5", "1->3")),
                new TestCase(makeTree(new Integer[] { 1 }), List.of("1"))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.binaryTreePaths(test.in);
            assert test.expected.size() == actual.size() && Objects.equals(new HashSet<>(test.expected),
                    new HashSet<>(actual)) : "binaryTreePaths(%s) == %s, want %s".formatted(test.in, actual,
                            test.expected);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        findLeafPaths(root, new StringBuilder(), result);
        return result;
    }

    private static void findLeafPaths(TreeNode node, StringBuilder parent, List<String> result) {
        if (node == null) {
            return;
        }
        int parentSize = parent.length();
        int resSize = result.size();
        if (parent.length() > 0) {
            parent.append("->");
        }
        parent.append(node.val);
        findLeafPaths(node.left, parent, result);
        findLeafPaths(node.right, parent, result);
        if (result.size() == resSize) {
            result.add(parent.toString());
        }
        parent.setLength(parentSize);
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