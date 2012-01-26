
package edu.wpi.first.wpilibj.templates;

//imports from First
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//imports from our own code
import edu.wpi.first.wpilibj.templates.commands.StartPickupBall;
import edu.wpi.first.wpilibj.templates.commands.StopPickupBall;
import edu.wpi.first.wpilibj.templates.RobotMap;



public class OI {
    // Process operator interface input here.
    
    public static int leftStickNum = 1;
    Joystick leftStick = new Joystick(leftStickNum);
    public static int rightStickNum = 2;
    Joystick rightStick = new Joystick(rightStickNum);
    
    public static int feedButtPort = 1;
    private final JoystickButton feedButt = new JoystickButton(leftStick, feedButtPort);
    
    StartPickupBall feedOn = new StartPickupBall();
    StopPickupBall feedOff = new StopPickupBall();
    
  
    
    
    public OI(){
        feedButt.whenPressed(feedOn);
        feedButt.whenReleased(feedOff);
    }
    
    public double getLeftSpeed() {
        System.out.println("leftStick.getY() returns" + leftStick.getY());
        return -leftStick.getY();
    }
    
    public double getRightSpeed() {
        System.out.println("rightStick.getY() returns" + rightStick.getY());
        return -rightStick.getY();
    }
}

