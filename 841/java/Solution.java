import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<List<Integer>> in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(List.of(List.of(1), List.of(2), List.of(3), List.of()), true),
                new TestCase(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0)), false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canVisitAllRooms(test.in);
            assert test.expected == actual : "canVisitAllRooms(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visit(rooms, 0, visited);
        for (boolean room : visited) {
            if (!room) {
                return false;
            }
        }
        return true;
    }

    private void visit(List<List<Integer>> rooms, int number, boolean[] visited) {
        if (visited[number]) {
            return;
        }
        visited[number] = true;
        for (Integer key : rooms.get(number)) {
            visit(rooms, key, visited);
        }
    }

}