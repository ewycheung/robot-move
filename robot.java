import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class robot {    
    public static void main(String[] args) {
        RobotLocation robot = new RobotLocation(0, 0, Direction.NORTH);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean quit = false;

        while (!quit) {
            try {
                String command = br.readLine();

                switch(command) {
                    case "Q":
                        quit = true;
                        quit();
                        break;
                    case "L":
                        turn(robot, Turn.LEFT);
                        break;
                    case "R":
                        turn(robot, Turn.RIGHT);
                        break;
                    case "M":
                        move_forward(robot);
                        break;
                    case "?":
                        info();
                        break;
                    default:
                        System.out.println("Invalid Command!");
                        break;                        
                }
            } catch (IOException ioe) {
                System.out.println(ioe);
             }
        }

    }
    
    public static void info() {
        System.out.println("Command the robot with:");
        System.out.println("  L - turn left");
        System.out.println("  R - turn right");
        System.out.println("  M - move forward");
        System.out.println("  ? - this message");
        System.out.println("  Q - quit");
    }

    public static void quit() {
        System.out.println("Robot shutting down.");
    }

    private static void print_robot_location(RobotLocation robot) {
        System.out.println("Robot at (" + robot.getPosX() + ", " + robot.getPosY() + ") facing " + robot.getFaceDirection());
    }

    public static void move_forward(RobotLocation robot) {
        if (robot != null) {
            switch(robot.getFaceDirection()) {
            case NORTH:
                robot.setPosY(robot.getPosY() + 1);
                break;
            case EAST:
                robot.setPosX(robot.getPosX() + 1);
                break;
            case SOUTH:
                robot.setPosY(robot.getPosY() - 1);
                break;
            case WEST:
                robot.setPosX(robot.getPosX() - 1);
                break;
            default:
                break;
        }
        
        print_robot_location(robot);
        }
    }

    public static void turn(RobotLocation robot, Turn turn) {
        int newDirection;

        switch (turn) {
            case RIGHT:
                newDirection = (robot.getFaceDirection().getDirectionCode() + turn.getTurnIndex()) % 4;
                break;
            case LEFT:
                newDirection = robot.getFaceDirection().getDirectionCode() + turn.getTurnIndex() < 0 ? 3 : robot.getFaceDirection().getDirectionCode() + turn.getTurnIndex();
                break;
            default:
                newDirection = robot.getFaceDirection().getDirectionCode();
                break;        
        }
        robot.setFaceDirection(Direction.determineDirection(newDirection));        
        print_robot_location(robot);
    }    
}
