package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.templates.commands.ManYaw;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A Subsystem extending PIDSubystem that contains methods for controlling the ShooterYaw
 * @author Gillie, Lauren, and Emma
 */
public class ShooterYaw extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static final int MaxAngle = 120;
    public static final int MinAngle = -120;
    private Encoder encoder = new Encoder(RobotMap.yawEncoderA, RobotMap.yawEncoderB);
    private CANJaguar yawMotor;

    public ShooterYaw() {
        super(0.24, 0.09, 0.0);
        setSetpointRange(MaxAngle, MinAngle);
        setSetpoint(0);
        //positive is couterclockwise as seen from above
        encoder.setDistancePerPulse(0.0833750);
        encoder.start();
        enable();

        SmartDashboard.putDouble("YawSetpoint", getSetpoint());
        SmartDashboard.putDouble("encoderAngle", encoder.getDistance());
        try {
            yawMotor = new CANJaguar(RobotMap.yawMotor);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        // setDefaultCommand(new Aim(1));
    }

    protected double returnPIDInput() {
        return -encoder.getDistance();
        //for sensor
    }

    protected void usePIDOutput(double output) {
        //for motor
        try {
            yawMotor.setX(output);
        } catch (Exception e) {
        }
    }

    public boolean atSetpoint() {
        return Math.abs(getPosition() - getSetpoint()) < 5;
    }
}
