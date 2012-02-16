package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.CANJaguar;


/**
 *
 */
public class ShooterPitch extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static final int MaxAngle = 360;
    public static final int MinAngle = 0;
    private Encoder encoder = new Encoder(RobotMap.pitchEncoderA, RobotMap.pitchEncoderB);
    private CANJaguar pitchMotor;

    public ShooterPitch() {
        super(0.01, 0.0, 0.0);
        setSetpointRange(MaxAngle, MinAngle);
        setSetpoint(MinAngle);
        encoder.start();
        enable();

        try {
            pitchMotor = new CANJaguar(RobotMap.pitchMotor);
        } catch (Exception e) {
            System.out.println(e);
        }

        double degreesPerPulse = 1.44;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new Aim(1));
    }

    protected double returnPIDInput() {
        //for sensor
        return encoder.getDistance();
    }

    protected void usePIDOutput(double output) {
        //for motor
        try {
            pitchMotor.setX(output);
        } catch (Exception e) {
        }
    }
    public boolean atSetpoint(){
        return Math.abs(getPosition() - getSetpoint()) < 10;
    }
}