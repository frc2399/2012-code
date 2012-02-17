
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.RobotMap;
// import sensor for Ed

/**
 *
 */
public class Loader extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Victor loadMotor= new Victor(RobotMap.loadMotor);
    private DigitalInput topSensor = new DigitalInput(RobotMap.topSensor);
    private DigitalInput bottomSensor = new DigitalInput(RobotMap.bottomSensor);
    private DigitalInput middleSensor = new DigitalInput(RobotMap.middleSensor);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setLoaderSpeed(0.0);
    }
    
    /**
     * sets the feeder speed
     * @param speed double between -1 and 1
     */
    
    public void setLoaderSpeed(double speed){
        loadMotor.set(speed);
    }
    
    public boolean getTop(){
        return topSensor.get();
    }
    
    public boolean getBottom(){
        return bottomSensor.get();
    }
    
    public boolean getMiddle(){   
        return middleSensor.get();
    }
                
         
}

