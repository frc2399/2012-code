
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;
import edu.wpi.first.wpilibj.templates.commands.LiftSmacker;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 * A Subsystem that contains methods for controlling the RampSmacker.  
 * @author Emma and Jessie
 */
public class RampSmacker extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Victor SmackMotor = new Victor(RobotMap.SmackMotor);
    
    private final DigitalInput smackDownSwitch = new DigitalInput(RobotMap.smackDownSwitch);
    private final DigitalInput liftUpSwitch = new DigitalInput(RobotMap.liftUpSwitch);
    
    /**
     * Default: the RampSmacker speed is zero, and the RampSmacker is off.  
     */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
        
    /**
     * Sets the speed of the RampSmacker to a given value.  
     * @param speed a speed between -1 and 1
     */
    public void setSpeed(double speed){
        SmackMotor.set(speed);
    }
    
    /**
     * Gets the value of the bottom switch.  
     * @return true if the bottom switch is tripped, false if it is not.  
     */
    public boolean getDownSwitch(){
        return smackDownSwitch.get();
    }
    
    /**
     * Gets the value of the top switch.  
     * @return true if the top switch is tripped, false if it is not.  
     */
    public boolean getUpSwitch(){
        return liftUpSwitch.get();
    }
}

