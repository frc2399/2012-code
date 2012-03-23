
package edu.wpi.first.wpilibj.templates.commands;

/**
 * A Command that extends CommandBase that tells the loader to send the ball 
 * into the shooter. Essentially it is the trigger.
 * Requires Loader
 * @author Jessie & Emma
 */
public class ShootBall extends CommandBase {

    /**
     * Creates an instance of ShootBall.
     */
    public ShootBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(loader);
    }

    // Called just before this Command runs the first time
    /**
     * Sets the initial loader speed to zero so that a ball is not loaded if the 
     * Shooter is not up to speed.  This prevents the balls from getting shot out
     * at a sadly low speed and just kind of falling instead of going where we want 
     * them to.  
     */
    protected void initialize() {
        loader.setLoaderSpeed(0.0);
        
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Only sets the Loader speed if the Shooter is up to speed.  If the Shooter
     * is up to speed, turns on the Loader.  
     */
    protected void execute() {
            loader.setLoaderSpeed(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * Stops the Loader if there are no more balls in the topmost position on the 
     * conveyor.  If not, the motor keeps running.  
     * @return true if the top sensor is no longer tripped and false if it is.  
     */
    protected boolean isFinished(){
        if(loader.getTop() == false){
            return true;
        }else{
            return false;
        }
    }

    // Called once after isFinished returns true
    /**
     * Sets the Loader speed to zero and stops the conveyor.  
     */
    protected void end() {
      //  loader.setLoaderSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
