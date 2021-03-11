public enum Turn {
    RIGHT(1),
    LEFT(-1);

    private final int turnIndex;

    Turn(int turnIndex) {
        this.turnIndex = turnIndex;
    }
    
    public int getTurnIndex() {
        return this.turnIndex;
    }
}
