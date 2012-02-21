package edu.wpi.first.wpilibj.templates.commands;


/**
 * A Command that extends CommandBase and turns the feeder motor off, therefore stopping the feeder conveyor belt
 * @author Jessie 
 */
public class FeedBallOff extends CommandBase {

    /**
     * sets the speed of the bottommost belt to zero, stopping the belt 
     * requires the "feeder" subsystem
     */
    public FeedBallOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(feeder);
    }

    // Called just before this Command runs the first time
    /**
     * sets the PickupBall feeder speed to zero, stopping the belt
     */
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * If the top sensor is tripped, the middle is not, and the bottom (which is located by 
     * the feeder conveyor) is tripped, then the feeder conveyor is moved until the middle 
     * sensor is tripped, thereby moving a ball from the bottom position into the middle one. 
     */
    protected void execute() {
        if (loader.getBottom() == true && loader.getTop() == true && loader.getMiddle() == false) {
            feeder.setFeederSpeed(1);
        } else {
            feeder.setFeederSpeed(0);
        }
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
