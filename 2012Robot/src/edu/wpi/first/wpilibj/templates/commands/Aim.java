package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;

/**
 *
 * @author bradmiller
 */
public class Aim extends CommandBase {

    public Aim() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //for NetworkTableTestingExtension:
        try {
            NetworkTable SDTable = new NetworkTable();
            SDTable = NetworkTable.getTable("SmartDashboard");
           // System.out.println(SDTable.getKeys());
            
            //System.out.println(SDTable.containsKey("x"));
                        
          // System.out.println(SDTable.getValue("test").getClass());
            
            System.out.println(SDTable.getSubTable("test").getInt("testNum", 0));
       } catch (Exception ex) {
            System.out.println(ex);
      }
        
        /*
        System.out.println(NetworkTable.getTable("camera").isConnected());
        // System.out.println("number of particles: " + NetworkTable.getTable("camera").getKeys().size());
        for (int i = 0; i < NetworkTable.getTable("camera").getKeys().size(); i++) {
        double x = NetworkTable.getTable("camera").getDouble("x" + i, 0);
        double y = NetworkTable.getTable("camera").getDouble("y" + i, 0);
        // System.out.println("particle #" + i + " center:(" + x + "," + y + ")");
        }
         */
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
