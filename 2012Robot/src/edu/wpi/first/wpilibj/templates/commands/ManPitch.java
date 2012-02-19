
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author bradmiller
 */
public class ManPitch extends CommandBase {

    public ManPitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooterPitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooterPitch.setSetpoint(82.5 + (oi.getThrottle()/2)*75); //multiply by whatever max angle
       // System.out.println("Pitch throttle: " + oi.getThrottle());
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
