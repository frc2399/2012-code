
package edu.wpi.first.wpilibj.templates.commands;

/**
 * drives the robot in TankDrive based on y-values returned from the joysticks in the OI
 * requires the DriveTrain subsystem
 * @author Emma and Jessie
 */
public class JoystickDrive extends CommandBase {
        private double speed;
    /**
     * Creates a new instance of JoystickDrive.  
     */
    public JoystickDrive(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Drives the robot based on Joystick values from the OI.
     */
    protected void execute() {
        try {
            driveTrain.drive.tankDrive(speed * oi.getLeftSpeed(), speed * oi.getRightSpeed());
        } catch(Exception x){
            
        }
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
