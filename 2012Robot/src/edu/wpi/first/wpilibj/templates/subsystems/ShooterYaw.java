
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class ShooterYaw extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public ShooterYaw(){
     super(0.0,0.0,0.0);
}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
    
    protected double returnPIDInput(){
        return 0.0;
        //for sensor
    }
    protected void usePIDOutput (double output){
        //for motor
}
}

