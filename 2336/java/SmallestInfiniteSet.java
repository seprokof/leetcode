class SmallestInfiniteSet {

    private final boolean[] values;
    private int minIdx;

    public SmallestInfiniteSet() {
        this.values = new boolean[1001];
        this.minIdx = 0;
    }

    public int popSmallest() {
        while (values[minIdx++]) {
        }
        values[minIdx - 1] = true;
        return minIdx;
    }

    public void addBack(int num) {
        values[--num] = false;
        minIdx = Math.min(minIdx, num);
    }

}
