
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
import edu.wpi.first.wpilibj.templates.commands.manualControl.ManShootBall;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.autonomous.Go;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.autonomous.Spinning;
import edu.wpi.first.wpilibj.templates.commands.testers.TestShooter;
import edu.wpi.first.wpilibj.templates.commands.autonomous.AutonomousStopTop;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;
import edu.wpi.first.wpilibj.templates.commands.LiftSmacker;
import edu.wpi.first.wpilibj.templates.commands.NewAim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.manualControl.ManAim;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.templates.commands.OneWheelDrive;
import edu.wpi.first.wpilibj.templates.commands.FindReset;
import edu.wpi.first.wpilibj.templates.commands.SlowShoot;
import edu.wpi.first.wpilibj.templates.commands.MedShoot;
import edu.wpi.first.wpilibj.templates.commands.ShootWarmUp;

/**
 * the Operator Interface, defines port numbers, joysticks, and commands
 * @author 2399 Programmers
 */
public class OI {
    // Process operator interface input here.
    //shooter stick buttons
    Joystick shooterStick = new Joystick(2);
    public static int shootButtNum = 1;
    public static int slowShootButtNum = 7;
    public static int medShootButtNum = 8;
    public static int ShootWarmUpButtNum = 10;
    public static int triggerButtNum = 2;
    public static int LoadButtNum = 3;
    public static int ManAimButtOnNum = 12;
    public static int ManAimButtOffNum = 11;
    private final JoystickButton shootButt = new JoystickButton(shooterStick, shootButtNum); 
    private final JoystickButton slowShootButt = new JoystickButton(shooterStick, slowShootButtNum);
    private final JoystickButton medShootButt = new JoystickButton(shooterStick, medShootButtNum);
    private final JoystickButton shootWarmUpButt = new JoystickButton(shooterStick, ShootWarmUpButtNum);
    private final JoystickButton triggerButt = new JoystickButton(shooterStick, triggerButtNum);
    private final JoystickButton LoadButt = new JoystickButton(shooterStick, LoadButtNum);
    private final JoystickButton ManAimOnButt = new JoystickButton(shooterStick, ManAimButtOnNum);
    private final JoystickButton ManAimOffButt = new JoystickButton(shooterStick, ManAimButtOffNum);    
    
    //driver buttons
    Joystick leftStick = new Joystick(1);
    Joystick rightStick = new Joystick(3);
    public static int ShmackDownButtNum = 2;
    public static int LiftSmackerButtNum = 3;
    public static int feedButtNum = 3;
    public static int feedButtNegNum = 6;
    public static int slowButtNum = 6; //check this number
    public static int medButtNum = 7;
    public static int oneWheelButtNum = 8;
    public static int fullSpeedButtNum = 9;   
    //right stick
    private final JoystickButton slowButt = new JoystickButton(rightStick, slowButtNum);
    private final JoystickButton medButt = new JoystickButton(rightStick, medButtNum);
    private final JoystickButton oneWheelButt = new JoystickButton(rightStick, oneWheelButtNum);
    private final JoystickButton fullSpeedButt = new JoystickButton(rightStick, fullSpeedButtNum);
    
    private final JoystickButton feedButt = new JoystickButton(shooterStick, feedButtNum);
    private final JoystickButton feedButtNeg = new JoystickButton(shooterStick, feedButtNegNum);
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
    //public static int AutonomousStopTopTestButtNum = 6;
    public static int AutonomousCenterTestButtNum = 6;
    public static int FindResetTestButtNum = 6;
    public static int AutonomousLeftTestButtNum = 7;
    public static int AutonomousRightTestButtNum = 10;
    //right stick
   // private final JoystickButton AutonomousStopTopTestButt = new JoystickButton(rightStick, AutonomousStopTopTestButtNum);
 private final JoystickButton FindResetTestButt = new JoystickButton(rightStick, FindResetTestButtNum);
    //left stick

    
    //making instances of things
    JoystickDrive slowSpeed = new JoystickDrive(0.5);
    JoystickDrive medSpeed = new JoystickDrive(0.75);
    OneWheelDrive oneWheelSpeed = new OneWheelDrive(0.75);
    JoystickDrive fullSpeed = new JoystickDrive(1);
    
    //shooter things
    FeedBallOn feedOn = new FeedBallOn(1, 1);
    FeedBallOff feedOff = new FeedBallOff();
    FeedBallOn feedNeg = new FeedBallOn(-1, 1);
    LoadBall load = new LoadBall();
    ShootOn shootOn = new ShootOn(0.4);
    SlowShoot slowShootOn = new SlowShoot(0.2);
    MedShoot medShootOn = new MedShoot(0.25);
    ShootWarmUp shootWarmUpOn = new ShootWarmUp(0.2);
    ShootOff shootOff = new ShootOff();
    ManShootBall trigger = new ManShootBall();
    ManAim manAim = new ManAim();
        
    //autonomous testing things
    AutonomousStopTop autonomousStopTest = new AutonomousStopTop();
    FindReset findResetTest = new FindReset();
    
    //smacker things
    ShmackDown shmackDown = new ShmackDown();
    LiftSmacker liftSmacker = new LiftSmacker();
    
    //aim things
    NewAim aimTop = new NewAim(1);
    /*
    NewAim aimRight = new NewAim(2);
    NewAim aimLeft = new NewAim(3);
    NewAim aimBottom = new NewAim(4);
    */
    
    /**
     * When the PickupBall feeder button "feedbutt" is pressed, the PickupBall feeder is turned on,
     * and when it is released the feeder stops.
     */
    public OI() {
        //Shooter stick:
        shootButt.whenPressed(shootOn);
        shootButt.whenReleased(shootOff);
        slowShootButt.whenPressed(slowShootOn);
        slowShootButt.whenReleased(shootOff);
        medShootButt.whenPressed(medShootOn);
        medShootButt.whenReleased(shootOff);
        shootWarmUpButt.whenPressed(shootWarmUpOn);
        shootWarmUpButt.whenReleased(shootOff);
        medShootButt.whenReleased(shootOff);
        triggerButt.whileHeld(trigger);
        ShmackDownButt.whenPressed(shmackDown);
        LiftSmackerButt.whenPressed(liftSmacker);
        LoadButt.whenPressed(load);
        ManAimOnButt.whenPressed(manAim);
        ManAimOffButt.whenPressed(aimTop);
        
        //Right Driver stick:
        feedButt.whenPressed(feedOn);
        feedButt.whenReleased(feedOff);
        feedButtNeg.whileHeld(feedNeg);
        slowButt.whenPressed(slowSpeed);
        medButt.whenPressed(medSpeed);
        oneWheelButt.whenPressed(oneWheelSpeed);
        fullSpeedButt.whenPressed(fullSpeed);
        
        FindResetTestButt.whenPressed(findResetTest);
        
        //Left Driver stick:


        //Peef:
        AimTopButt.whenPressed(aimTop);
        /*
        AimRightButt.whenPressed(aimRight);
        AimLeftButt.whenPressed(aimLeft);
        AimBottomButt.whenPressed(aimBottom); 
         */
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

