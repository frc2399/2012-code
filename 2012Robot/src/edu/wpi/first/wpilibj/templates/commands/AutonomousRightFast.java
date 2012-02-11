
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
public class AutonomousRightFast extends CommandGroup {
//start bot w front left wheel in corner of key
    public AutonomousRightFast() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        /**addSequential(new Aim());
        addSequential(new LoadBall());
        addSequential(new ShootBall());
        addSequential(new LoadBall());
        addSequential(new ShootBall());
        */
        addSequential(new Go(-17.5, 0.5));
        //counter clockwise
        addSequential(new Spinning(DriveTrain.Turn135Fast, 0.5));
        addSequential(new Go(72.5, 0.5));
        addSequential(new Spinning(DriveTrain.Turn45Fast, 0.5));
        addSequential(new Go(32.5, 0.5));
        //lower the arm to tip the bridge
    }
}