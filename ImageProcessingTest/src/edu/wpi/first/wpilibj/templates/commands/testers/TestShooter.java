
package edu.wpi.first.wpilibj.templates.commands.testers;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.ShooterPitch;
/**
 *
 * @author bradmiller
 */
public class TestShooter extends CommandBase {

    public TestShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooterPitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooterPitch.setSetpoint(180.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return shooterPitch.atSetpoint();
        
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
