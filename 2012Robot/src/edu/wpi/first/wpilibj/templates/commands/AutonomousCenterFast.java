
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
public class AutonomousCenterFast extends CommandGroup {
//start bot w both front wheel just inside of key
    public AutonomousCenterFast() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        /**addSequential(new Aim());
        addSequential(new LoadBall());
        addSequential(new ShootBall());
        addSequential(new LoadBall());
        addSequential(new ShootBall());
        */
        //take off 2.5 in for each dist in the slow autonomous commnds
        addSequential(new Go(-27.5, 0.5));
        addSequential(new Spinning(DriveTrain.Turn180Fast, 0.5));
        addSequential(new Go(27.5, 0.5));
        //lower the arm to tip the bridge
        
    }
}
