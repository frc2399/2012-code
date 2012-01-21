
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;


/**
 *
 */
public class Feeder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    
    Jaguar feedMotor = new Jaguar(RobotMap.feedMotor);
    Joystick feedButt = new Joystick(RobotMap.feedButt);
    public void initDefaultCommand() {
       // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        //default is set to zero
        feedMotor.set(0);
    }
    
    
    public void teleopCommand(){
        if(feedButt.getRawButton(1) == true){
            feedMotor.set(0.5);
        } else {
            feedMotor.set(0);
        }
    }
}

