
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;
import edu.wpi.first.wpilibj.templates.commands.LiftSmacker;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 *
 */
public class RampSmacker extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Victor SmackMotor = new Victor(RobotMap.SmackMotor);
    
    private final DigitalInput smackDownSwitch = new DigitalInput(RobotMap.smackDownSwitch);
    private final DigitalInput liftUpSwitch = new DigitalInput(RobotMap.liftUpSwitch);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setSpeed(0.0);
    }
        
    public void setSpeed(double speed){
        SmackMotor.set(speed);
    }
    public boolean getDownSwitch(){
        return smackDownSwitch.get();
   
    }
    public boolean getUpSwitch(){
        return liftUpSwitch.get();
    }
}

