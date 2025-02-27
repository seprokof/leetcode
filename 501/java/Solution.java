import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, int[] expected) {}
        
        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, null, 2, 2 }), new int[] { 2 }),
                new TestCase(makeTree(new Integer[] { 0 }), new int[] { 0 })
                };
        // @formatter:on

        for (TestCase test : tests) {
            Solution s = new Solution();
            int[] actual = s.findMode(test.in);
            assert Arrays.stream(test.expected).boxed().collect(Collectors.toSet())
                    .equals(Arrays.stream(actual).boxed().collect(Collectors.toSet())) : "findMode(%s) == %s, want %s"
                            .formatted(test.in, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    private int maxCount = 0;
    private int currentCount = 0;
    private int currentNum = 0;
    private final List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (node.val == currentNum) {
            currentCount++;
        } else {
            currentCount = 1;
            currentNum = node.val;
        }
        if (currentCount > maxCount) {
            modes.clear();
            maxCount = currentCount;
        }
        if (currentCount == maxCount) {
            modes.add(node.val);
        }
        inorder(node.right);
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