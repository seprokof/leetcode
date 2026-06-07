import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, TreeNode expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[][] { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } }, makeTree(new Integer[] { 50, 20, 80, 15, 17, 19 })),
                new TestCase(new int[][] { { 1, 2, 1 }, { 2, 3, 0 }, { 3, 4, 1 } }, makeTree(new Integer[] { 1, 2, null, null, 3, 4 }))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            TreeNode actual = s.createBinaryTree(test.in);
            assert Objects.equals(test.expected, actual) : "createBinaryTree(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> valueToNode = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] description : descriptions) {
            TreeNode parent = valueToNode.computeIfAbsent(description[0], TreeNode::new);
            TreeNode child = valueToNode.computeIfAbsent(description[1], TreeNode::new);
            children.add(description[1]);
            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        for (Entry<Integer, TreeNode> en : valueToNode.entrySet()) {
            if (!children.contains(en.getKey())) {
                return en.getValue();
            }
        }
        return null;
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