
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Feeder;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Jessie
 */
public class FeedBallOn extends CommandBase {
    
    /**
     * turns the PickupBall feeder on
     * requires the "feeder" subsystem
     */
    public FeedBallOn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(feeder);
    }

    // Called just before this Command runs the first time
    /**
     * turns the PickupBall feeder on
     */
    protected void initialize() {
        feeder.setFeederSpeed(0.25);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(feeder.getTop() == true){
            feeder.setFeederSpeed(0.25);
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
