class GuessGame {

    private final Integer picked;

    GuessGame(Integer picked) {
        super();
        this.picked = picked;
    }

    protected int guess(int num) {
        return picked.compareTo(num);
    }

}
