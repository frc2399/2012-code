
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
 * @author Emma and Jessie
 */
public class AutonomousCenter extends CommandGroup {

    public AutonomousCenter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        /**addSequential(new Aim());
        addSequential(new LoadBall());
        addSequential(new ShootBall());
        addSequential(new LoadBall());
        addSequential(new ShootBall());
        */
        addSequential(new Go(-30.0, 0.5));
        addSequential(new Spinning(DriveTrain.Turn180, 0.5));
        addSequential(new Go(30.0, 0.5));
        //lower the arm to tip the bridge
        
    }
}
