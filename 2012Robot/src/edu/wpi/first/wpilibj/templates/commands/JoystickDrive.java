
package edu.wpi.first.wpilibj.templates.commands;

/**
 *drives the robot in TankDrive based on y-values returned from the joysticks in the OI
 * requires the DriveTrain subsystem
 * @author Emma and Jessie
 */
public class JoystickDrive extends CommandBase {

    public JoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.drive.tankDrive(oi.getLeftSpeed(), oi.getRightSpeed());
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
