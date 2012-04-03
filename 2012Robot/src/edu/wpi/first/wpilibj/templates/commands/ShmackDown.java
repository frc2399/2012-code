package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A Command that extends CommandBase that moves the RampSmacker down.  
 * Requires RampSmacker.  
 * Emma came up with the command name, and I completely and totally approve.
 * @author Emma
 */
public class ShmackDown extends CommandBase {

    /**
     * Creates a new instance of ShmackDown.  
     */
    public ShmackDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(rampSmacker);
    }

    // Called just before this Command runs the first time
    /**
     * sets the speed of the RampSmacker in order to push it down.  
     */
    protected void initialize() {
        rampSmacker.setSpeed(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Continues to run the RampSmacker at the same speed for the entire time it is within range of the 
     * limit switches.  
     */
    protected void execute() {
        rampSmacker.setSpeed(1);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * Stops the RampSmacker if it trips a limit switch, meaning it is at the bottom of it's movement range.  
     * @return true if the bottom limit switch is tripped, and false if it is not.  
     */
    protected boolean isFinished() {
        if (rampSmacker.getDownSwitch() == true) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    /**
     * Sets the RampSmacker speed to zero, stopping the RampSmacker at the bottom of it's movement range. 
     */
    protected void end() {
        rampSmacker.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        rampSmacker.setSpeed(0.0);
    }
}
