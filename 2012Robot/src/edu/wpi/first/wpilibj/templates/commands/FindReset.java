package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.templates.subsystems.ShooterYaw;

/**
 *
 * @author bradmiller
 */
public class FindReset extends CommandBase {

    private boolean isSwitchFound;
    public FindReset() {
        // This is to reset the encoder.
        requires(shooterYaw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooterYaw.setSetpoint(30.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (shooterYaw.getSwitch() == true && shooterYaw.atSetpoint() == true) {
            shooterYaw.setSetpoint(-30.0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (shooterYaw.getSwitch() == false) {
            isSwitchFound = true;
            return true;
        } else if (shooterYaw.getSetpoint() < -29.0 && shooterYaw.getSwitch() == true){
            isSwitchFound = false;
            return true;
        }
        else {
            return false;
        }

    }

    // Called once after isFinished returns true
    protected void end() {
        
        if (isSwitchFound == true){
           shooterYaw.setSetpoint(7.0); 
        } else {
           shooterYaw.setSetpoint(0.0);
        }
        shooterYaw.resetEncoder();
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
 