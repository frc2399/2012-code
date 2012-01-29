
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jessie 
 */
public class StopPickupBall extends CommandBase {
    /**
     * sets the speed of the PickupBall belt to zero, stopping the belt 
     * requires the "feeder" subsystem
     */
    public StopPickupBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(feeder);
    }

    // Called just before this Command runs the first time
    /**
     * sets the PickupBall feeder speed to zero, stopping the belt
     */
    protected void initialize() {
        feeder.setFeederSpeed(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
