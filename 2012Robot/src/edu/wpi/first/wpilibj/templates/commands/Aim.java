package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 * converting origin in corner to origin in center:
 * y = 120 - y
 * x = x - 160
 */
public class Aim extends CommandBase {
    NetworkTable rioCameraTable;
    int position;
    final double targetHeight = 109;     //heights in inches
    final double cameraHeight = 27.5;

    public Aim(int position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooterPitch);
        requires(shooterYaw);
        this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       // System.out.println("Starting Aim");
        rioCameraTable = NetworkTable.getTable("camera");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //this is for finding the topmost target
        int keySize;
        
        try {
            rioCameraTable.beginTransaction();
            SmartDashboard.putDouble("TopY", getTopY(rioCameraTable));
            SmartDashboard.putDouble("ChosenX", getChosenX(rioCameraTable));
            SmartDashboard.putDouble("range", targetRange(getTopY(rioCameraTable)));
            
            System.out.println("connected? " + rioCameraTable.isConnected());
            
            keySize = rioCameraTable.getKeys().size()/2;
            for (int i = 0; i < keySize; i++){
                SmartDashboard.putDouble("x" + i, rioCameraTable.getDouble("x" + i)-160);
                SmartDashboard.putDouble("y" + i, 120-rioCameraTable.getDouble("y" + i));
           }
            
            
            rioCameraTable.endTransaction();
            
          //  shooterYaw.setSetpoint(shooterYaw.getSetpoint() + yawAngle(getChosenX(rioCameraTable)));
          //  shooterPitch.setSetpoint(pitchAngle(targetRange(getTopY(rioCameraTable))));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        SmartDashboard.putBoolean("yawAtSetpoint", shooterYaw.atSetpoint());
        SmartDashboard.putBoolean("pitchAtSetPoint", shooterPitch.atSetpoint());
        SmartDashboard.putData("yawTuner", shooterYaw);
        SmartDashboard.putData("pitchTuner", shooterPitch);
        
        
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
                    double angle = 0;
        switch (position) {
                    case 1: // top
                        angle = 0.0174*(MathUtils.pow(range, 3))
                                + 0.9494*(MathUtils.pow(range, 2))
                                - 19.315*range
                                + 236.91;
                        break;
                    case 2: // right
                    case 3: // left

                        break;
                    case 4: // bottom

                        break;
                    default:
                        break;
    }
        angle += 15;
         return angle; //for now. we need to finish it. 
    }

    private double getTopY(NetworkTable table) {
        //assuming table is the camera table
        double topY = 0;
        try {
            //Makes chosenX and chosenY the first X and Y values
            table.beginTransaction();
            topY = table.getDouble("y0", 0);
            
            //The for loop looks at the values in the camera table
            for (int i = 0; i < (table.getKeys().size()) / 2; i++) {
                
                double y = table.getDouble("y" + i, 0);
               
                // Finds the y value of the top target
                if (y < topY && y > 0) {
                    topY = y;
                }
            }
            table.endTransaction();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        topY = 120 - topY;
       // System.out.println("top y:" + topY);
               SmartDashboard.putDouble("top y", topY);
        return topY;
    }

    private double getChosenX(NetworkTable table) {
        double chosenX = 0;
        double chosenY = 0;
        try {
            table.beginTransaction();
            //Makes chosenX and chosenY the first X and Y values
            chosenX = table.getDouble("x0", 0);
            chosenY = table.getDouble("y0", 0);

            //The for loop looks at the values in the camera table
            for (int i = 0; i < (table.getKeys().size()) / 2; i++) {
                double x = table.getDouble("x" + i, 0);
                double y = table.getDouble("y" + i, 0);

                switch (position) {
                    case 1: // top
                        if (y < chosenY && y > 0) {
                            chosenY = y;
                            chosenX = x;
                        }
                        break;
                    case 2: // right
                        if (x > chosenX && x > 0) {
                            chosenY = y;
                            chosenX = x;
                        }
                        break;
                    case 3: // left
                        if (x < chosenX && x > 0) {
                            chosenY = y;
                            chosenX = x;
                        }
                        break;
                    case 4: // bottom
                        if (y > chosenY && y > 0) {
                            chosenY = y;
                            chosenX = x;
                        }
                        break;
                    default:
                        break;
                }
            }
            table.endTransaction();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        chosenX = chosenX - 160;
      // System.out.println("chosen x:" + chosenX);
        SmartDashboard.putDouble("chosen x", chosenX);
                return chosenX;
    }
}
