
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Go;
import edu.wpi.first.wpilibj.templates.commands.Spinning;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;

/**
 * A Command that extends CommandGroup to make an Autonomous program for the right position.
 * @author Emma and Jessie
 */
public class AutonomousRight extends CommandGroup {

    /**
     * Creates an Autonomous Command for the right position that runs through the following steps:
     * aim at the top target, shoot twice, back up 20 in, turn 45 clockwise, 
     * move backward 64 in, turn 45 clockwise, move backward 27 in, and smack down the ramp.
     */
    public AutonomousRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        addSequential(new AutonomousAimStart());
        addParallel(new Aim(1));
        addSequential(new ShootOn());
        addSequential(new ShootBall());
        addSequential(new ShootBall());
        addSequential(new ShootOff());
        
        addSequential(new Go(-20.0, 0.5));
        //clockwise
        addSequential(new Spinning(DriveTrain.TurnNeg45Fast, 0.5));
        addSequential(new Go(-64.0, 0.5));
        //counter clockwise
        addSequential(new Spinning(DriveTrain.Turn45Fast, 0.5));
        addSequential(new Go(-27.0, 0.5));
        addSequential(new ShmackDown());
    }
}
