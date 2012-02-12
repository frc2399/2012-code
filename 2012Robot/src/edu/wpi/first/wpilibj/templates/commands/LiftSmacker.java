
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author bradmiller
 */
public class LiftSmacker extends CommandBase {

    public LiftSmacker() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);requires(rampSmacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        rampSmacker.setSpeed(-0.25);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        rampSmacker.setSpeed(-0.25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(rampSmacker.getUpSwitch() == true){
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        rampSmacker.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
