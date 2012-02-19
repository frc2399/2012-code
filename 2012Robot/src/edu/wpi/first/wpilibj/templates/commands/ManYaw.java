package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author GILLIE ROSEN 
 */
public class ManYaw extends CommandBase {

    public ManYaw() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooterYaw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (oi.getTwistSpeed() < 0.2 && oi.getTwistSpeed() > -0.2){
            shooterYaw.setSetpoint(shooterYaw.getSetpoint());
        } else {
        shooterYaw.setSetpoint(shooterYaw.getSetpoint() + oi.getTwistSpeed());
       // System.out.println("Yaw twist: " + oi.getTwistSpeed());
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
