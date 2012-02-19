package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class ShooterPitch extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static final int MaxAngle = 360;
    public static final int MinAngle = 0;
    public static final double DegPerVolt = 0.0123; //This number is arbitrary. We need to find the real one.
    public static final double OffsetAngle = 15; // This number is also arbitrary!!!
    private final AnalogChannel encoder = new AnalogChannel(RobotMap.pitchEncoder);
    private CANJaguar pitchMotor;

    public ShooterPitch() {
        super(0.0, 0.0, 0.0);
        setSetpointRange(MaxAngle, MinAngle);
        setSetpoint(MinAngle);
        enable();

        try {
            pitchMotor = new CANJaguar(RobotMap.pitchMotor);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
      //  setDefaultCommand(new Aim(1));
    }

    protected double returnPIDInput() {
        //for sensor
        double voltage = encoder.getVoltage();
        double angle = (voltage * DegPerVolt) + OffsetAngle;
        SmartDashboard.putDouble("printednumber", angle);
        return angle;
        
    }

    protected void usePIDOutput(double output) {
        //for motor
        try {
            pitchMotor.setX(output);
        } catch (Exception e) {
        }
    }
    public boolean atSetpoint(){
        return Math.abs(getPosition() - getSetpoint()) < 10; //Needs Testing!!!!
    }
}