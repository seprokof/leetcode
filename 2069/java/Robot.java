public class Robot {

    private static final String[] DIRECTIONS_STR = new String[] { "East", "North", "West", "South" };

    private int[][] pos;
    private int[] directions;
    private int i;
    private boolean isMoved;

    public Robot(int width, int height) {
        int len = 2 * (width - 1) + 2 * (height - 1);
        pos = new int[len][2];
        directions = new int[len];
        int j = 0;
        for (int i = 0; i < width; i++, j++) {
            pos[j][0] = i;
            pos[j][1] = 0;
            directions[j] = 0;
        }
        directions[0] = 3;
        for (int i = 1; i < height; i++, j++) {
            pos[j][0] = width - 1;
            pos[j][1] = i;
            directions[j] = 1;
        }
        for (int i = width - 2; i >= 0; i--, j++) {
            pos[j][0] = i;
            pos[j][1] = height - 1;
            directions[j] = 2;
        }
        for (int i = height - 2; i > 0; i--, j++) {
            pos[j][0] = 0;
            pos[j][1] = i;
            directions[j] = 3;
        }
        i = 0;
        isMoved = false;
    }

    public void step(int num) {
        i = (i + num) % pos.length;
        isMoved = true;
    }

    public int[] getPos() {
        return pos[i];
    }

    public String getDir() {
        return isMoved ? DIRECTIONS_STR[directions[i]] : DIRECTIONS_STR[0];
    }

}
