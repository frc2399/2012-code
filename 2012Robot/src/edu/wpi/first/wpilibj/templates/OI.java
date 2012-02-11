
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
import edu.wpi.first.wpilibj.templates.commands.Go;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.Spinning;
import edu.wpi.first.wpilibj.templates.commands.TestShooter;
import edu.wpi.first.wpilibj.templates.commands.AutonomousCenter;
import edu.wpi.first.wpilibj.templates.commands.AutonomousRightFast;
import edu.wpi.first.wpilibj.templates.commands.AutonomousCenterFast;


/**
 * the Operator Interface, defines port numbers, joysticks, and commands
 * @author 2399 Programmers
 */
public class OI {
    // Process operator interface input here.
    
    public static int leftStickNum = 1;
    public static int rightStickNum = 3;
    public static int feedButtPort = 7;
    public static int shooterStickNum = 2;
    public static int shooterButtNum = 1;
    public static int goTestButtNum = 3;
    public static int spin180ButtNum = 5;
    public static int spin90ButtNum = 4;
    public static int PIDTestButtNum = 3;
    public static int AutonomousCenterTestButtNum = 5;
    public static int AutonomousRightFastTestButtNum = 2;
    public static int AutonomousCenterFastTestButtNum = 4;
    
    Joystick leftStick = new Joystick(leftStickNum);
    Joystick rightStick = new Joystick(rightStickNum);
    Joystick shooterStick = new Joystick(shooterStickNum);
    StartPickupBall feedOn = new StartPickupBall();
    StopPickupBall feedOff = new StopPickupBall();
    ShootBall shoot = new ShootBall();
    Go goTest = new Go(-36.0, 0.25);
    //these two angles go counter-clockwise
    Spinning spin180 = new Spinning(DriveTrain.Turn180, 0.25);
    Spinning spin90 = new Spinning(DriveTrain.Turn90, 0.25);
    TestShooter testPitch = new TestShooter();
    AutonomousCenter autonomousCenterTest = new AutonomousCenter();
    AutonomousRightFast autonomousRightFastTest = new AutonomousRightFast();
    AutonomousCenterFast autonomousCenterFastTest = new AutonomousCenterFast();
    //buttons
    private final JoystickButton feedButt = new JoystickButton(leftStick, feedButtPort);
    private final JoystickButton shooterButt = new JoystickButton(shooterStick,shooterButtNum);
    private final JoystickButton goTestButt = new JoystickButton(rightStick,goTestButtNum);
    private final JoystickButton spin180Butt = new JoystickButton(rightStick,spin180ButtNum);
    private final JoystickButton spin90Butt = new JoystickButton(rightStick,spin90ButtNum);
    private final JoystickButton PIDTestButt = new JoystickButton(shooterStick,PIDTestButtNum);
    private final JoystickButton AutonomousCenterTestButt = new JoystickButton(leftStick, AutonomousCenterTestButtNum);
    private final JoystickButton AutonomousRightFastTestButt = new JoystickButton(leftStick, AutonomousRightFastTestButtNum);
    private final JoystickButton AutonomousCenterFastTestButt = new JoystickButton(leftStick, AutonomousCenterFastTestButtNum);
    /**
     * When the PickupBall feeder button "feedbutt" is pressed, the PickupBall feeder is turned on,
     * and when it is released the feeder stops.
     */
    public OI(){
        feedButt.whenPressed(feedOn);
        feedButt.whenReleased(feedOff);
        shooterButt.whenPressed(shoot);
        PIDTestButt.whenPressed(testPitch);

        goTestButt.whenPressed(goTest);
        spin180Butt.whenPressed(spin180);
        spin90Butt.whenPressed(spin90);
        
        AutonomousCenterTestButt.whenPressed(autonomousCenterTest);
        AutonomousRightFastTestButt.whenPressed(autonomousRightFastTest);
        AutonomousCenterFastTestButt.whenPressed(autonomousCenterFastTest);
    }

    
    /**
     * gets the speed of the left joystick based on the y-axis position
     * @return the y position of the left joystick
     */
    public double getLeftSpeed() {
        //System.out.println("leftStick.getY() returns" + leftStick.getY());
        return -leftStick.getY();
    }
    
    /**
     * gets the speed of the right joystick based on the y-axis position
     * @return the y position of the right joystick
     */
    public double getRightSpeed() {
        //System.out.println("rightStick.getY() returns" + rightStick.getY());
        return -rightStick.getY();
    }
}

