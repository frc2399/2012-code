package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;

/**
 *
 * @author bradmiller
 */
public class Aim extends CommandBase {
    
    String position;
    
    public Aim(String position) {
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
        if(position.equals("top")) {
            try {
                NetworkTable SDTable = new NetworkTable();
                SDTable = NetworkTable.getTable("SmartDashboard");
            
                //Makes chosenX and chosenY the first X and Y values
                double topX = SDTable.getSubTable("camera").getDouble("x0" , 0);
                double topY = SDTable.getSubTable("camera").getDouble("y0" , 0);
            
                //The for loop looks at the values in the camera table
                for (int i = 0; i < (SDTable.getSubTable("camera").getKeys().size()) / 2; i++) {
                    double x = SDTable.getSubTable("camera").getDouble("x" + i, 0);
                    double y = SDTable.getSubTable("camera").getDouble("y" + i, 0);
                    // Finds the y value of the top target
                    if (y > topY){
                        topY = y;
                        topX = x;
                    }
                }
            }   catch (Exception ex) {
                System.out.println(ex);
            }
          //this is for finding the rightmost target
        } else if(position.equals("right")){
            try {
                NetworkTable SDTable = new NetworkTable();
                SDTable = NetworkTable.getTable("SmartDashboard");
            
                //Makes chosenX and chosenY the first X and Y values
                double rightX = SDTable.getSubTable("camera").getDouble("x0" , 0);
                double rightY = SDTable.getSubTable("camera").getDouble("y0" , 0);
            
                //The for loop looks at the values in the camera table
                for (int i = 0; i < (SDTable.getSubTable("camera").getKeys().size()) / 2; i++) {
                    double x = SDTable.getSubTable("camera").getDouble("x" + i, 0);
                    double y = SDTable.getSubTable("camera").getDouble("y" + i, 0);
                    // Finds the y value of the top target
                    if (x > rightX){
                        rightY = y;
                        rightX = x;
                    }
                }
            }   catch (Exception ex) {
                System.out.println(ex);
        }
      //this is for finding the leftmost target
    } else if(position.equals("left")){
        try {
                NetworkTable SDTable = new NetworkTable();
                SDTable = NetworkTable.getTable("SmartDashboard");
            
                //Makes chosenX and chosenY the first X and Y values
                double leftX = SDTable.getSubTable("camera").getDouble("x0" , 0);
                double leftY = SDTable.getSubTable("camera").getDouble("y0" , 0);
            
                //The for loop looks at the values in the camera table
                for (int i = 0; i < (SDTable.getSubTable("camera").getKeys().size()) / 2; i++) {
                    double x = SDTable.getSubTable("camera").getDouble("x" + i, 0);
                    double y = SDTable.getSubTable("camera").getDouble("y" + i, 0);
                    // Finds the y value of the top target
                    if (x < leftX){
                        leftY = y;
                        leftX = x;
                    }
                }
            }   catch (Exception ex) {
                System.out.println(ex);
    }
      //this is for finding the lowest target
    } else if(position.equals("bottom")){
        try {
                NetworkTable SDTable = new NetworkTable();
                SDTable = NetworkTable.getTable("SmartDashboard");
            
                //Makes chosenX and chosenY the first X and Y values
                double bottomX = SDTable.getSubTable("camera").getDouble("x0" , 0);
                double bottomY = SDTable.getSubTable("camera").getDouble("y0" , 0);
            
                //The for loop looks at the values in the camera table
                for (int i = 0; i < (SDTable.getSubTable("camera").getKeys().size()) / 2; i++) {
                    double x = SDTable.getSubTable("camera").getDouble("x" + i, 0);
                    double y = SDTable.getSubTable("camera").getDouble("y" + i, 0);
                    // Finds the y value of the top target
                    if (y < bottomY){
                        bottomY = y;
                        bottomX = x;
                    }
                }
            }   catch (Exception ex) {
                System.out.println(ex);
    
            }
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
