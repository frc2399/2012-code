
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * A Command extending CommandBase that turns both of the Shooter motors off and
 * stops the shooter completely.  
 * Requires Shooter.  
 * @author Jessie and Emma
 */
public class ShootOff extends CommandBase {

    /**
     * Creates an instance of ShootOff.  
     */
    public ShootOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    /**
     * Sets the Shooter speed to zero, turning the Shooter off.  
     */
    protected void initialize() {
        shooter.setSpeed(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putBoolean("atSpeed", false); 
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
