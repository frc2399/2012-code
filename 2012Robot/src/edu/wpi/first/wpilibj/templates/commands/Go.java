
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jessie and Emma
 */
public class Go extends CommandBase {
    
    double ticksInitial;
    double ticksFinal;
    double distToGo;
    

    public Go(double dist) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        distToGo = dist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ticksInitial = (driveTrain.getRightEncoder() + driveTrain.getLeftEncoder()) / 2;
        //change distToGo
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.setLeftSpeed(0.25);
        driveTrain.setRightSpeed(0.25);
        ticksFinal = (driveTrain.getRightEncoder() + driveTrain.getLeftEncoder()) / 2;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(ticksFinal - ticksInitial >= distToGo){
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.setLeftSpeed(0);
        driveTrain.setRightSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
