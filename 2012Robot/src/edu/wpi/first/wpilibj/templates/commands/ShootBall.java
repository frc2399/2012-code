
package edu.wpi.first.wpilibj.templates.commands;

/**this tell the loader to send the ball into the shooter. essentially it is the trigger
 *
 * @author Jessie & Emma
 */
public class ShootBall extends CommandBase {

    public ShootBall() {
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
        if(shooter.upToSpeed() == true){
            loader.setLoaderSpeed(0.25);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished(){
        if(loader.getTop() == false){
            return true;
        }else{
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        loader.setLoaderSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
