
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;


/**
 * A Subsystem that contains methods for controlling the Loader.  The Loader is the 
 * topmost conveyor belt.  
 * @author Emma
 */
public class Loader extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Victor loadMotor = new Victor(RobotMap.loadMotor);
    private DigitalInput topSensor = new DigitalInput(RobotMap.topSensor);
    private DigitalInput bottomSensor = new DigitalInput(RobotMap.bottomSensor);
    private DigitalInput middleSensor = new DigitalInput(RobotMap.middleSensor);
    
    /**
     * Default: Sets the Loader speed to zero, turning the Loader off.  
     */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LoadBall());
    }
    
    /**
     * sets the Loader speed
     * @param speed double between -1 and 1
     */
    
    public void setLoaderSpeed(double speed){
        loadMotor.set(speed);
    }
    
    /**
     * Gets the value of the topmost sensor, which is located on the Loader conveyor.  
     * @return the value of the top sensor.  True means the sensor is tripped, false means it is not.  
     */
    public boolean getTop(){
        return topSensor.get();
    }
    
    /**
     * Gets the value of the middle sensor, which is located on the Loader conveyor.  
     * @return the value of the middle sensor.  True means the sensor is tripped, false means it is not.  
     */
    public boolean getBottom(){
        return bottomSensor.get();
    }
    
    /**
     * Gets the value of the bottommost sensor, which is located on the Feeder conveyor.  
     * @return the value of the bottom sensor.  True means the sensor is tripped, false means it is not.  
     */
    public boolean getMiddle(){   
        return middleSensor.get();
    }
                
         
}

