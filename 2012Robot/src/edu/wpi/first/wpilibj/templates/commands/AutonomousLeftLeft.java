
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
 *
 * @author bradmiller
 */
public class AutonomousLeftLeft extends CommandGroup {

    public AutonomousLeftLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addSequential(new AutonomousAimStart());
        addParallel(new Aim(3));
        addSequential(new ShootOn());
        addSequential(new ShootBall());
        addSequential(new ShootBall());
        addSequential(new ShootOff());
        addSequential(new Go(-20.0, 0.5));
        //counter clockwise
        addSequential(new Spinning(DriveTrain.Turn45Fast, 0.5));
        addSequential(new Go(-74.0, 0.5));
        //clockwise
        addSequential(new Spinning(DriveTrain.TurnNeg45Fast, 0.5));
        addSequential(new Go(-27.0, 0.5));
        addSequential(new ShmackDown());
    }
}
    