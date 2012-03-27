
package edu.wpi.first.wpilibj.templates.commands;

/**
 * A Command that extends CommandBase and turns the feeder motor on, therefore rotating the feeder conveyor belt
 * @author Jessie
 */
public class FeedBallOn extends CommandBase {
    
    private int sign;
    private double speed;
    
    /**
     * turns the PickupBall feeder on
     * requires the "feeder" subsystem
     * @param sign either -1 or 1 designates the direction of the motor/victor as positive or negative
     */
    public FeedBallOn(int sign, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(feeder);
        this.sign = sign;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    /**
     * turns the bottommost conveyor on
     */
    protected void initialize() {
        feeder.setFeederSpeed(sign * speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       feeder.setFeederSpeed(sign * speed);
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
