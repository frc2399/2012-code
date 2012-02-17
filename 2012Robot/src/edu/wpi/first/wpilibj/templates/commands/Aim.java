
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;
import com.sun.squawk.util.MathUtils;

/**
 *
 * converting origin in corner to origin in center:
 * y = 120 - y
 * x = x - 160
 */
public class Aim extends CommandBase {

    int position;
    final double targetHeight = 109;     //heights in inches
    final double cameraHeight = 20;

    public Aim(int position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        requires(vision);
        requires(shooterPitch);
        this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //this is for finding the topmost target

        try {
            NetworkTable cameraTable = NetworkTable.getTable("SmartDashboard").getSubTable("camera");
            System.out.println("Top Y: " +  getTopY(cameraTable));
            System.out.println("Chosen X: " +  getChosenX(cameraTable));
            System.out.println("range: " +  targetRange(getTopY(cameraTable)));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    private double targetRange(double yPixel) { // yPixel is the top target's y-coordinate
        return 305.01 * ((targetHeight - cameraHeight) / yPixel);
    }

    private double yawAngle(double xPixel) {
        return MathUtils.atan(xPixel / 346.03);
    }

    private double pitchAngle(double range) {
        return 0; //for now. we need to finish it. 
    }

    private double getTopY(NetworkTable table) {
        //assuming table is the camera table
        double topY = 0;
        try {
            //Makes chosenX and chosenY the first X and Y values

            topY = table.getDouble("y0", 0);

            //The for loop looks at the values in the camera table
            for (int i = 0; i < (table.getKeys().size()) / 2; i++) {
                double y = table.getDouble("y" + i, 0);
                // Finds the y value of the top target
                if (y < topY) {
                    topY = y;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } 
        topY = 120 - topY;
        return topY;
    }

    private double getChosenX(NetworkTable table) {
        double chosenX = 0;
        double chosenY = 0;
        try {

            //Makes chosenX and chosenY the first X and Y values
            chosenX = table.getDouble("x0", 0);
            chosenY = table.getDouble("y0", 0);

            //The for loop looks at the values in the camera table
            for (int i = 0; i < (table.getKeys().size()) / 2; i++) {
                double x = table.getDouble("x" + i, 0);
                double y = table.getDouble("y" + i, 0);

                switch (position) {
                    case 1: // top
                        if (y < chosenY) {
                            chosenY = y;
                            chosenX = x;
                        }
                        break;
                    case 2: // right
                        if (x > chosenX) {
                            chosenY = y;
                            chosenX = x;
                        }
                        break;
                    case 3: // left
                        if (x < chosenX) {
                            chosenY = y;
                            chosenX = x;
                        }
                        break;
                    case 4: // bottom
                        if (y > chosenY) {
                            chosenY = y;
                            chosenX = x;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        chosenX = chosenX - 160;
        return chosenX;
    }
}
