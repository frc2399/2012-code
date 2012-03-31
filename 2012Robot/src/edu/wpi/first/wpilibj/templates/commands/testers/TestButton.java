
package edu.wpi.first.wpilibj.templates.commands.testers;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author bradmiller
 */
public class TestButton extends CommandBase {
String displayText;
    public TestButton(String text) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        displayText=text;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putString("joystick buttons", displayText);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
