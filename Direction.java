import java.util.Arrays;

public enum Direction {
    NORTH(0, "North"),
    EAST(1, "East"),
    SOUTH(2, "South"),
    WEST(3, "West");

    private final int directionCode;
    private final String description;

    Direction(int directionCode, String description) {
        this.directionCode = directionCode;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDirectionCode() {
        return this.directionCode;
    }

    public static Direction determineDirection(int directionCode) {
        return Arrays.stream(Direction.values()).filter(e -> e.getDirectionCode() == directionCode).findFirst().orElse(null);
    }
}
