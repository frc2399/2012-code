package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A Command extending CommandBase that turns both of the Shooter motors on.
 * Requires Shooter.  
 * @author Gillie, Emma and Jessie
 */
public class ShootOn extends CommandBase {

    Timer timer = new Timer();
    private double speed;
    /**
     * Creates an instance of ShootOn.  
     */
    public ShootOn(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    /**
     * Sets the Shooter speed and the timer.  
     */
    protected void initialize() {
        shooter.setSpeed(speed);
        timer.start();
        setTimeout(2.0);

    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Prints to the SmartDashboard if the Shooter is up to speed.  
     */
    protected void execute() {
        SmartDashboard.putBoolean("atSpeed", timer.get() > 1);
        shooter.atSpeed = timer.get() > 1;
        
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * This Command never finishes on its own.  
     * @return false because the program must always run.  
     */
    protected boolean isFinished() {
        return timer.get() > 2;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
