
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;


/**
 *contains methods for controlling the feeder
 * @author Jessie and Emma
 */
public class Feeder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private CANJaguar feedMotor;
    private CANJaguar loadMotor;
       
    public Feeder(){
    try{
       feedMotor = new CANJaguar(RobotMap.feedMotor);
       loadMotor = new CANJaguar(RobotMap.loadMotor);
}
    catch (Exception e){
        System.out.println(e);
        }
    }

    /**
     * Default: PickupBall feeder speed is zero, feeder is off
     */
    public void initDefaultCommand() {
       // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        //default is set to zero
        setFeederSpeed(0.0);
    }
    
    /**
     * sets the feeder speed
     * @param speed double between -1 and 1
     */
    public void setFeederSpeed(double speed){
        try {
            feedMotor.setX(speed);
        } catch (Exception e) {
        }
        try {
            loadMotor.setX(speed);
        } catch (Exception e) {
        }  
    }
}

