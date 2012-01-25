
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.JoystickDrive;
/**
 *
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Jaguar leftFront = new Jaguar(RobotMap.leftFront);
    Jaguar leftRear = new Jaguar(RobotMap.leftRear);
    Jaguar rightFront = new Jaguar(RobotMap.rightFront);
    Jaguar rightRear = new Jaguar(RobotMap.rightRear);
    
    //come back to look at this please:
    drive = new RobotDrive(RobotMap.leftFront,RobotMap.leftRear,RobotMap.rightFront,RobotMap.rightRear);
     
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
    
    
}

