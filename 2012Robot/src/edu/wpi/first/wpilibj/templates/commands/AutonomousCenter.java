
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Go;
import edu.wpi.first.wpilibj.templates.commands.Spinning;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;


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
        addSequential(new Go(-30.0));
        addSequential(new Spinning(DriveTrain.Turn180));
        addSequential(new Go(30.0));
        //lower the arm to tip the bridge
        
    }
}
