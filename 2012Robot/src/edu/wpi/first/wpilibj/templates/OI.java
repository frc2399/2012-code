
package edu.wpi.first.wpilibj.templates;

//imports from First
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//imports from our own code
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.StartPickupBall;
import edu.wpi.first.wpilibj.templates.commands.StopPickupBall;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.TestButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class OI {
    // Process operator interface input here.
    
    public static int leftStickNum = 1;
    public static int rightStickNum = 2;
    public static int feedButtPort = 4;
    public static int shooterStickNum=3;
    public static int shooterButtNum = 3;
    public static int testButt1Port = 1;
    public static int testButt2Port = 1;
    public static int testButt3Port = 1;
    
    
    Joystick leftStick = new Joystick(leftStickNum);
    Joystick rightStick = new Joystick(rightStickNum);
    Joystick shooterStick = new Joystick(shooterStickNum);
    StartPickupBall feedOn = new StartPickupBall();
    StopPickupBall feedOff = new StopPickupBall();
    ShootBall shoot = new ShootBall();
    
    private final JoystickButton feedButt = new JoystickButton(leftStick, feedButtPort);
    private final JoystickButton shooterButt = new JoystickButton(shooterStick,shooterButtNum);
    private final JoystickButton testButt1 = new JoystickButton(leftStick,testButt1Port);
    private final JoystickButton testButt2 = new JoystickButton(rightStick,testButt2Port);
    private final JoystickButton testButt3 = new JoystickButton(shooterStick,testButt3Port);
    
    public OI(){
        feedButt.whenPressed(feedOn);
        feedButt.whenReleased(feedOff);
        shooterButt.whenPressed(shoot);
        
        testButt1.whenPressed(new TestButton("1"));
        testButt2.whenPressed(new TestButton("2"));
        testButt3.whenPressed(new TestButton("3"));
       
          
    }
    
    public double getLeftSpeed() {
        //System.out.println("leftStick.getY() returns" + leftStick.getY());
        return -leftStick.getY();
    }
    
    public double getRightSpeed() {
        //System.out.println("rightStick.getY() returns" + rightStick.getY());
        return -rightStick.getY();
    }
}

