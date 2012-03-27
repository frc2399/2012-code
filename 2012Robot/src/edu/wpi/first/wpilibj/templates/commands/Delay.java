
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
/**
 *
 * @author bradmiller
 */
public class Delay extends CommandBase {
    Timer delayTime;
    double wait; 
    public Delay(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        wait = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        delayTime.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (delayTime.get() > wait){
        return true;
        } else {
        return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
