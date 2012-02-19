package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * A Subsystem extending PIDSubsystem that contains methods to control the ShooterPitch.  
 * @author Gillie, Lauren, and Emma
 */
public class ShooterPitch extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static final int MaxAngle = 120;
    public static final int MinAngle = 45;

    public static final double DegPerVolt = 72; 
    public static final double OffsetAngle = 287; //-165.601; 

    private final AnalogChannel encoder = new AnalogChannel(RobotMap.pitchEncoder);
    private CANJaguar pitchMotor;

    public ShooterPitch() {
        super(0.025, 0.0002, 0.0002);
        setSetpointRange(MaxAngle, MinAngle);
        setSetpoint(80);
        enable();

        try {
            pitchMotor = new CANJaguar(RobotMap.pitchMotor);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    
    public void setSetpoint(double setpoint){
    if (setpoint > MaxAngle){
    setpoint = MaxAngle;
    } else if (setpoint < MinAngle){
        setpoint = MinAngle;
    }      
    getPIDController().setSetpoint(setpoint); 
    }
    
    public void initDefaultCommand() {
        // Set the default command for a  subsystem here.
        //setDefaultCommand(new MySpecialCommand());
      //  setDefaultCommand(new Aim(1));
    }

    protected double returnPIDInput() {
        //for sensor
        double voltage = encoder.getAverageVoltage();
        double angle = (-voltage * DegPerVolt) + OffsetAngle;
        SmartDashboard.putDouble("pitchAngle", angle);
                SmartDashboard.putDouble("pitchSetpoint", getSetpoint());
        SmartDashboard.putDouble("pitchVoltage", voltage);
        return angle;
        
    }

    protected void usePIDOutput(double output) {
        //for motor
        try {
            pitchMotor.setX(-output);
        } catch (Exception e) {
        }
    }
    public boolean atSetpoint(){
        return Math.abs(getPosition() - getSetpoint()) < 10; //Needs Testing!!!!
    }
}