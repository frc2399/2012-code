package edu.wpi.first.wpilibj.templates;

//imports from First
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//is this right?? 
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;

//imports from our own code
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.FeedBallOn;
import edu.wpi.first.wpilibj.templates.commands.FeedBallOff;
import edu.wpi.first.wpilibj.templates.commands.ShootOn;
import edu.wpi.first.wpilibj.templates.commands.ShootOff;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Go;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.Spinning;
import edu.wpi.first.wpilibj.templates.commands.TestShooter;
import edu.wpi.first.wpilibj.templates.commands.AutonomousStop;
import edu.wpi.first.wpilibj.templates.commands.AutonomousCenter;
import edu.wpi.first.wpilibj.templates.commands.AutonomousLeft;
import edu.wpi.first.wpilibj.templates.commands.AutonomousRight;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;
import edu.wpi.first.wpilibj.templates.commands.LiftSmacker;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.ManAim;

/**
 * the Operator Interface, defines port numbers, joysticks, and commands
 * @author 2399 Programmers
 */
public class OI {
    // Process operator interface input here.
    //shooter stick buttons
    Joystick shooterStick = new Joystick(2);
    public static int shootButtNum = 1;
    public static int triggerButtNum = 2;
    public static int LoadButtNum = 3;
    public static int ManAimButtOnNum = 12;
    public static int ManAimButtOffNum = 11;
    private final JoystickButton shootButt = new JoystickButton(shooterStick, shootButtNum); 
    private final JoystickButton triggerButt = new JoystickButton(shooterStick, triggerButtNum);
    private final JoystickButton LoadButt = new JoystickButton(shooterStick, LoadButtNum);
    private final JoystickButton ManAimOnButt = new JoystickButton(shooterStick, ManAimButtOnNum);
    private final JoystickButton ManAimOffButt = new JoystickButton(shooterStick, ManAimButtOffNum);    
    
    //driver buttons
    Joystick leftStick = new Joystick(1);
    Joystick rightStick = new Joystick(3);
    public static int ShmackDownButtNum = 2;
    public static int LiftSmackerButtNum = 3;
    public static int feedButtNum = 1;
    public static int feedButtNegNum = 10;
    //right stick
    private final JoystickButton feedButt = new JoystickButton(rightStick, feedButtNum);
    private final JoystickButton feedButtNeg = new JoystickButton(rightStick, feedButtNegNum);
    //left stick
    private final JoystickButton ShmackDownButt = new JoystickButton(leftStick, ShmackDownButtNum);
    private final JoystickButton LiftSmackerButt = new JoystickButton(leftStick, LiftSmackerButtNum);
    
    //peef buttons
    public static int AimTopButtNum = 4;
    public static int AimRightButtNum = 8;
    public static int AimLeftButtNum = 3;
    public static int AimBottomButtNum = 7;
    private final DigitalIOButton AimTopButt = new DigitalIOButton(AimTopButtNum);
    private final DigitalIOButton AimRightButt = new DigitalIOButton(AimRightButtNum);
    private final DigitalIOButton AimLeftButt = new DigitalIOButton(AimLeftButtNum);
    private final DigitalIOButton AimBottomButt = new DigitalIOButton(AimBottomButtNum);
    
    //autonomous testing buttons
    public static int AutonomousStopTestButtNum = 6;
    public static int AutonomousCenterTestButtNum = 6;
    public static int AutonomousLeftTestButtNum = 7;
    public static int AutonomousRightTestButtNum = 10;
    //right stick
    private final JoystickButton AutonomousStopTestButt = new JoystickButton(rightStick, AutonomousStopTestButtNum);

    //left stick
    private final JoystickButton AutonomousCenterTestButt = new JoystickButton(leftStick, AutonomousCenterTestButtNum);
    private final JoystickButton AutonomousLeftTestButt = new JoystickButton(leftStick, AutonomousLeftTestButtNum);
    private final JoystickButton AutonomousRightTestButt = new JoystickButton(leftStick, AutonomousRightTestButtNum);
    
    //making instances of things
    //shooter things
    FeedBallOn feedOn = new FeedBallOn(1);
    FeedBallOff feedOff = new FeedBallOff();
    FeedBallOn feedNeg = new FeedBallOn(-1);
    LoadBall load = new LoadBall();
    ShootOn shootOn = new ShootOn();
    ShootOff shootOff = new ShootOff();
    ShootBall trigger = new ShootBall();
    ManAim manAim = new ManAim();
        
    //autonomous testing things
    AutonomousStop autonomousStopTest = new AutonomousStop();
    AutonomousCenter autonomousCenterTest = new AutonomousCenter();
    AutonomousLeft autonomousLeftTest = new AutonomousLeft();
    AutonomousRight autonomousRightTest = new AutonomousRight();
    
    //smacker things
    ShmackDown shmackDown = new ShmackDown();
    LiftSmacker liftSmacker = new LiftSmacker();
    
    //aim things
    Aim aimTop = new Aim(1);
    Aim aimRight = new Aim(2);
    Aim aimLeft = new Aim(3);
    Aim aimBottom = new Aim(4);

    /**
     * When the PickupBall feeder button "feedbutt" is pressed, the PickupBall feeder is turned on,
     * and when it is released the feeder stops.
     */
    public OI() {
        //Shooter stick:
        shootButt.whenPressed(shootOn);
        shootButt.whenReleased(shootOff);
        triggerButt.whenPressed(trigger);
        ShmackDownButt.whenPressed(shmackDown);
        LiftSmackerButt.whenPressed(liftSmacker);
        LoadButt.whenPressed(load);
        ManAimOnButt.whenPressed(manAim);
        ManAimOffButt.whenPressed(aimTop);
        
        //Right Driver stick:
        feedButt.whenPressed(feedOn);
        feedButt.whenReleased(feedOff);
        feedButtNeg.whileHeld(feedNeg);
        
        AutonomousStopTestButt.whenPressed(autonomousStopTest);
        
        //Left Driver stick:
        AutonomousCenterTestButt.whenPressed(autonomousCenterTest);
        AutonomousLeftTestButt.whenPressed(autonomousLeftTest);
        AutonomousRightTestButt.whenPressed(autonomousRightTest);

        //Peef:
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

    public double getTwistSpeed() {
        return -shooterStick.getTwist();
    }

    public double getThrottle() {
        return shooterStick.getThrottle();
    }
}
