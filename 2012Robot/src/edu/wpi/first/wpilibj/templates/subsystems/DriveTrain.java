
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
/**
 *contains methods for controlling the DriveTrain
 * @author Jessie and Emma
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Jaguar leftFront = new Jaguar(RobotMap.leftFront);
    Jaguar leftRear = new Jaguar(RobotMap.leftRear);
    Jaguar rightFront = new Jaguar(RobotMap.rightFront);
    Jaguar rightRear = new Jaguar(RobotMap.rightRear);
    
    //which motors we are using to drive the robot
    public RobotDrive drive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
     
    /**
     * Default: DriveTrain subsystem controlled by inputs from the joysticks if no other 
     * commands are using the subsystem
     */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new JoystickDrive());
    }
    public void updateStatus(){

    }
    
}


