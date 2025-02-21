import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    private static final String CTOR = "constructor";
    private static final String FIND = "find";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Object[] in2, Boolean[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { CTOR, FIND, FIND }, new Object[] { makeTree(new Integer[] { -1, null, -1 }), 1, 2 }, new Boolean[] { null, false, true }),
                new TestCase(new String[] { CTOR, FIND, FIND, FIND }, new Object[] { makeTree(new Integer[] { -1, -1, -1, -1, -1 }), 1, 3, 5 }, new Boolean[] { null, true, true, false }),
                new TestCase(new String[] { CTOR, FIND, FIND, FIND, FIND }, new Object[] { makeTree(new Integer[] { -1, null, -1, -1, null, -1 }), 2, 3, 4, 5 }, new Boolean[] { null, true, false, false, true })
                };
        // @formatter:on

        for (TestCase test : tests) {
            FindElements f = null;
            for (int i = 0; i < test.in1.length; i++) {
                if (CTOR.equals(test.in1[i])) {
                    f = new FindElements((TreeNode) test.in2[i]);
                } else if (FIND.equals(test.in1[i])) {
                    Boolean actual = f.find((Integer) test.in2[i]);
                    assert Objects.equals(test.expected[i], actual) : FIND
                            + "(%s) == %s, want %s".formatted(test.in2[i], actual, test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
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