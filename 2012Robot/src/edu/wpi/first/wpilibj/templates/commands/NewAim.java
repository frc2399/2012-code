
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.sun.squawk.util.MathUtils;
/**
 *
 * @author bradmiller
 */
public class NewAim extends CommandBase {

    NetworkTable cameraTable;
    
    final double targetHeight = 109;     //heights in inches
    final double cameraHeight = 27.5;
    int position;
    
    public NewAim(int position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(networkTabling);
        cameraTable = NetworkTable.getTable("camera");
        this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //testers
        cameraTable.beginTransaction();
        boolean imageFound = cameraTable.getBoolean("found", false);
       // double imageOffset = cameraTable.getDouble("offset", -1.0);
       // double imageDistance = cameraTable.getDouble("distance", -1.0);
        cameraTable.endTransaction();
        
        SmartDashboard.putBoolean("found", imageFound);
       /* 
         * SmartDashboard.putDouble("offset", imageOffset);     
         * SmartDashboard.putDouble("distance", imageDistance);
        */
        
        
        try{
          
         cameraTable.beginTransaction();
         
            SmartDashboard.putDouble("TopY", getTopY(cameraTable));
            SmartDashboard.putDouble("ChosenX", getChosenX(cameraTable));
            SmartDashboard.putDouble("range", targetRange(getTopY(cameraTable)));
            
         for (int i = 0; i < (cameraTable.getKeys().size()/2); i++){
                SmartDashboard.putDouble("x" + i, cameraTable.getDouble("x" + i)-160);
                SmartDashboard.putDouble("y" + i, 120-cameraTable.getDouble("y" + i));
           }
        cameraTable.endTransaction();
        
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
    
    //Beginning of 2399-created methods
    
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

            topY = table.getDouble("y0", 0);

            //The for loop looks at the values in the camera table
            for (int i = 0; i < (table.getKeys().size()) / 2; i++) {
                double y = table.getDouble("y" + i, 0);
                // Finds the y value of the top target
                if (y < topY && y > 0) {
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
        } catch (Exception ex) {
            System.out.println(ex);
        }
        chosenX = chosenX - 160;

                return chosenX;
    }
}
