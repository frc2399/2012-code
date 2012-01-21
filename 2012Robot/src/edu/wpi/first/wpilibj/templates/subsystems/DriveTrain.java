
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
        
/**
 *
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Joystick rightStick, leftStick;
    RobotDrive dt; 
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        rightStick = new Joystick(1);
        leftStick = new Joystick(2);
        dt = new RobotDrive(5,4,1,2);
    }
    
    public void autonomousPeriod() {

}

    
    public void teleopPeriod() {
        double yLeft, yRight;
        yLeft = -leftStick.getRawAxis(2);
        yRight = -rightStick.getRawAxis(2);
        dt.tankDrive (yLeft, yRight);
    }
}
    

