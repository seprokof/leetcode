import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[][] { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } }, 4),
                new TestCase(new int[][] { { -1, -1 }, { -1, 3 } }, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.snakesAndLadders(test.in);
            assert test.expected == actual : "snakesAndLadders(%s) == %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] minRolls = new int[n * n + 1];
        Arrays.fill(minRolls, -1);
        minRolls[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int currentCell = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int targetCell = currentCell + i;
                int targetRow = (targetCell - 1) / n;
                int targetCollumn = targetRow % 2 == 0 ? (targetCell - 1) % n : (n - 1 - (targetCell - 1) % n);
                if (board[n - 1 - targetRow][targetCollumn] != -1) {
                    targetCell = board[n - 1 - targetRow][targetCollumn];
                }
                if (targetCell == n * n) {
                    return minRolls[currentCell] + 1;
                }
                if (minRolls[targetCell] == -1) {
                    minRolls[targetCell] = minRolls[currentCell] + 1;
                    queue.add(targetCell);
                }
            }
        }
        return -1;
    }

}