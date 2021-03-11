public class RobotLocation {
    private int pos_x;
    private int pos_y;
    private Direction face_direction;

    public RobotLocation(int x, int y, Direction face_direction) {
        this.pos_x = x;
        this.pos_y = y;
        this.face_direction = face_direction;
    }

    public int getPosX() {
        return this.pos_x;
    }

    public int getPosY() {
        return this.pos_y;
    }

    public Direction getFaceDirection() {
        return this.face_direction;
    }

    public void setPosX(int x) {
        this.pos_x = x;
    }

    public void setPosY(int y) {
        this.pos_y = y;
    }

    public void setFaceDirection(Direction face_direction) {
        this.face_direction = face_direction;
    }
}
