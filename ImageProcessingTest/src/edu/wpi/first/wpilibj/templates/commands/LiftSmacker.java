package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A Command extending CommandBase that lifts the RampSmacker up. 
 * Requires rampSmacker.  
 * @author Jessie and Emma
 */
public class LiftSmacker extends CommandBase {

    /**
     * Creates a new instance of LiftSmacker.
     */
    public LiftSmacker() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(rampSmacker);
    }

    // Called just before this Command runs the first time
    /**
     * Sets the speed of the RampSmacker in order to lift it up.
     */
    protected void initialize() {
        rampSmacker.setSpeed(-0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Continues to run the RampSmacker at the same speed for the entire time it is within range of the 
     * limit switches.  
     */
    protected void execute() {
        rampSmacker.setSpeed(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * Stops the RampSmacker if it trips a limit switch, meaning it is at the top of it's movement range.  
     * @return true if the top limit switch is tripped, and false if it is not.  
     */
    protected boolean isFinished() {
        if (rampSmacker.getUpSwitch() == true) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    /**
     * Sets the RampSmacker speed to zero, stopping the RampSmacker at the top of it's movement range.  
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
