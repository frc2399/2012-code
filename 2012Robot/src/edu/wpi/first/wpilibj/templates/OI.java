
package edu.wpi.first.wpilibj.templates;

//imports from First
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//is this right?? 
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;

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
import edu.wpi.first.wpilibj.templates.commands.AutonomousLeft;
import edu.wpi.first.wpilibj.templates.commands.AutonomousRight;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;
import edu.wpi.first.wpilibj.templates.commands.LiftSmacker;
import edu.wpi.first.wpilibj.templates.commands.Aim;

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
    public static int goTestButtNum = 7;
    public static int spin180ButtNum = 5;
    public static int spin90ButtNum = 4;
    public static int PIDTestButtNum = 3;
    public static int AutonomousCenterTestButtNum = 2;
    public static int AutonomousLeftTestButtNum = 4;
    public static int AutonomousRightTestButtNum = 5;
    public static int ShmackDownButtNum = 3;
    public static int LiftSmackerButtNum = 2;
    public static int AimTopButtNum = 1;
    public static int AimRightButtNum = 2;
    public static int AimLeftButtNum = 3;
    public static int AimBottomButtNum = 4; 
    
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
    AutonomousLeft autonomousLeftTest = new AutonomousLeft();
    AutonomousRight autonomousRightTest = new AutonomousRight();
    ShmackDown shmackDown = new ShmackDown();
    LiftSmacker liftSmacker = new LiftSmacker();
    Aim aimTop = new Aim("top");
    Aim aimRight = new Aim("right");
    Aim aimLeft = new Aim("left");
    Aim aimBottom = new Aim("Bottom");
    
    
    //buttons
    private final JoystickButton feedButt = new JoystickButton(leftStick, feedButtPort);
    private final JoystickButton shooterButt = new JoystickButton(shooterStick,shooterButtNum);
    private final JoystickButton goTestButt = new JoystickButton(rightStick,goTestButtNum);
    private final JoystickButton spin180Butt = new JoystickButton(rightStick,spin180ButtNum);
    private final JoystickButton spin90Butt = new JoystickButton(rightStick,spin90ButtNum);
    private final JoystickButton PIDTestButt = new JoystickButton(shooterStick,PIDTestButtNum);
    private final JoystickButton AutonomousCenterTestButt = new JoystickButton(leftStick, AutonomousCenterTestButtNum);
    private final JoystickButton AutonomousLeftTestButt = new JoystickButton(leftStick, AutonomousLeftTestButtNum);
    private final JoystickButton AutonomousRightTestButt = new JoystickButton(leftStick, AutonomousRightTestButtNum);
    private final JoystickButton ShmackDownButt = new JoystickButton(rightStick,ShmackDownButtNum);
    private final JoystickButton LiftSmackerButt = new JoystickButton(rightStick,LiftSmackerButtNum);
    private final DigitalIOButton AimTopButt = new DigitalIOButton(AimTopButtNum);
    private final DigitalIOButton AimRightButt = new DigitalIOButton(AimRightButtNum);
    private final DigitalIOButton AimLeftButt = new DigitalIOButton(AimLeftButtNum);
    private final DigitalIOButton AimBottomButt = new DigitalIOButton(AimBottomButtNum);
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
        AutonomousLeftTestButt.whenPressed(autonomousLeftTest);
        AutonomousRightTestButt.whenPressed(autonomousRightTest);
        
        ShmackDownButt.whenPressed(shmackDown);
        LiftSmackerButt.whenPressed(liftSmacker);
        
        AimTopButt.whenPressed(aimTop);
        AimRightButt.whenPressed(aimRight);
        AimLeftButt.whenPressed(aimLeft);
        AimBottomButt.whenPressed(aimBottom);
        
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

