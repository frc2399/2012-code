package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.Feeder;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;
import edu.wpi.first.wpilibj.templates.subsystems.NetworkTabling;
import edu.wpi.first.wpilibj.templates.subsystems.ShooterPitch;
import edu.wpi.first.wpilibj.templates.subsystems.RampSmacker;
import edu.wpi.first.wpilibj.templates.subsystems.Loader;
import edu.wpi.first.wpilibj.templates.subsystems.ShooterYaw;
/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author 2399 Programmers
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static Feeder feeder = new Feeder();
    public static DriveTrain driveTrain = new DriveTrain();
    public static NetworkTabling networkTabling = new NetworkTabling();
    public static Shooter shooter = new Shooter();
    public static ShooterPitch shooterPitch = new ShooterPitch();
    public static RampSmacker rampSmacker = new RampSmacker();
    public static Loader loader = new Loader();
    public static ShooterYaw shooterYaw = new ShooterYaw();
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(shooter);
        SmartDashboard.putData(feeder);
        SmartDashboard.putData(loader);
        SmartDashboard.putData(rampSmacker);
        //This line doesn't work b/c Gillie's code is currently disabled...can we re-enable it?
        //SmartDashboard.putData(vision);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
