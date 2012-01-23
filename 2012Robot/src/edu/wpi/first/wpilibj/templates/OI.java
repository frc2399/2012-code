
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
    
    public static int feedButtPort = 1;
    Joystick stickOne = new Joystick(1);
    private final JoystickButton feedButt = new JoystickButton(stickOne, feedButtPort);
    
    StartPickupBall feedOn = new StartPickupBall();
    StopPickupBall feedOff = new StopPickupBall();
    
    
    public OI(){
        feedButt.whenPressed(feedOn);
        feedButt.whenReleased(feedOff);
    }
}

