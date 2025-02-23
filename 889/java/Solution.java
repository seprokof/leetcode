import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, TreeNode expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 4, 5, 3, 6, 7 }, new int[] { 4, 5, 2, 6, 7, 3, 1 }, makeTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 })),
                new TestCase(new int[] { 1 }, new int[] { 1 }, makeTree(new Integer[] { 1 })),
                new TestCase(new int[] { 1, 2, 3 }, new int[] { 2, 3, 1 }, makeTree(new Integer[] { 1, 2, 3 })),
                new TestCase(new int[] { 3,4,1,2 }, new int[] { 1,4,2,3 }, makeTree(new Integer[] { 3,4,2,1 }))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            TreeNode actual = s.constructFromPrePost(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "constructFromPrePost(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, 0, postorder.length - 1, postorder, 0);
    }

    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return node;
        }
        int i = 1;
        while (preorder[preStart + 1] != postorder[postStart + i - 1]) {
            i++;
        }
        node.left = buildTree(preorder, preStart + 1, preStart + i, postorder, postStart);
        node.right = buildTree(preorder, preStart + i + 1, preEnd, postorder, postStart + i);
        return node;
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