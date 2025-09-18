import java.util.List;

class Solution {

    private static final String CTOR = "TaskManager";
    private static final String ADD = "add";
    private static final String EDIT = "edit";
    private static final String EXEC = "execTop";
    private static final String RMV = "rmv";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, List<?> in2, Integer[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { CTOR, ADD, EDIT, EXEC, RMV, ADD, EXEC }, List.of(List.of(List.of(1, 101, 10), List.of(2, 102, 20), List.of(3, 103, 15)), List.of(4, 104, 5), List.of(102, 8), List.of(), List.of(101), List.of(5, 105, 15), List.of()), new Integer[] { null, null, null, 3, null, null, 5 })
                };
        // @formatter:on

        for (TestCase test : tests) {
            TaskManager t = null;
            for (int i = 0; i < test.in1.length; i++) {
                if (CTOR.equals(test.in1[i])) {
                    t = new TaskManager((List<List<Integer>>) test.in2.get(i));
                } else if (ADD.equals(test.in1[i])) {
                    List<Integer> arg = (List<Integer>) test.in2.get(i);
                    t.add(arg.getFirst(), arg.get(1), arg.getLast());
                } else if (EDIT.equals(test.in1[i])) {
                    List<Integer> arg = (List<Integer>) test.in2.get(i);
                    t.edit(arg.getFirst(), arg.getLast());
                } else if (EXEC.equals(test.in1[i])) {
                    int actual = t.execTop();
                    assert test.expected[i] == actual : EXEC + "() == %s, want %s".formatted(actual, test.expected[i]);
                } else if (RMV.equals(test.in1[i])) {
                    t.rmv(((List<Integer>) test.in2.get(i)).getFirst());
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}