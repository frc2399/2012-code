
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author bradmiller
 */
public class Printout extends CommandBase {

    NetworkTable cameraTable;
    public Printout() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(networkTabling);
        cameraTable = NetworkTable.getTable("camera");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
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
         for (int i = 0; i < (cameraTable.getKeys().size()/2); i++){

                SmartDashboard.putDouble("x" + i, cameraTable.getDouble("x" + i)-160);
                SmartDashboard.putDouble("y" + i, cameraTable.getDouble("y" + i));
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
}
