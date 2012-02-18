package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Loader;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A Command extending CommandBase that takes the retrieved balls and places them 
 * in the best possible position for firing.  Does NOT load balls into the shooter, 
 * just organizes so that the actual shooting is an easier process.  
 * Requires Loader. 
 * @author Jessie
 */
public class LoadBall extends CommandBase {

    /**
     * Creates a new instance of LoadBall.  
     */
    public LoadBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(loader);
    }

    // Called just before this Command runs the first time
    /**
     * Sets the speed of the topmost conveyor to zero, so that balls are only moved 
     * when there are open spots, and at no other time. 
     */
    protected void initialize() {
        loader.setLoaderSpeed(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Sets the speed of the topmost conveyor (loader) based on values from sensors next to the 
     * two conveyors.  If the top sensor is tripped (meaning there is a ball there), 
     * the loader is stopped to prevent a ball from being pushed into the shooter.  When this
     * happens, there will also be a printout on the SmartDashboard that says if a ball is 
     * ready or not.  If the middle sensor is tripped and the top sensor is not, the loader 
     * is moved until the top sensor is tripped,at which point the loader will stop.  
     * If the top sensor is tripped, the middle is not, and the bottom (which is located by 
     * the feeder conveyor) is tripped, then the feeder conveyor is moved until the middle 
     * sensor is tripped, thereby moving a ball from the bottom position into the middle one. 
     */
    protected void execute() {
        if (loader.getTop() == true) {
            loader.setLoaderSpeed(0.0);
        }
        if (loader.getMiddle() == true && loader.getTop() == false) {
            loader.setLoaderSpeed(0.25);
        }
        if (loader.getBottom() == true && loader.getTop() == true && loader.getMiddle() == false) {
            feeder.setFeederSpeed(0.25);
        }

        SmartDashboard.putBoolean("ballReady", loader.getTop());
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * This program will NEVER stop, because we want it running for the entire match.  
     * @return false because this must always run, and if it stops we will no longer be able to shoot.  
     */
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
