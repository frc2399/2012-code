
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Loader;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author Jessie
 */
public class LoadBallOff extends CommandBase {
    
    public LoadBallOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(loader);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        loader.setLoaderSpeed(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //true == interrupted
        //if there is a ball at the top, stop
        if(loader.getTop() == true){
            loader.setLoaderSpeed(0.0);
        } 
        if(shooter.getShooterSpeed() < 0.25){
            loader.setLoaderSpeed(0.0);
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
