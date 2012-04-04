
package edu.wpi.first.wpilibj.templates.commands.autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.NewAim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;

import edu.wpi.first.wpilibj.templates.commands.FeedBallOff;
import edu.wpi.first.wpilibj.templates.commands.FeedBallOn;
import edu.wpi.first.wpilibj.templates.commands.SetPitch;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.commands.ShootOff;
import edu.wpi.first.wpilibj.templates.commands.ShootOn;

/** 
 * A Command that extends CommandGroup to make an Autonomous program for the center position.
 * @author Gillie
 */
public class AutonomousStopTop extends CommandGroup {

    /**
     * Creates an Autonomous Command for the center position that runs through the following steps:
     * aim at the top target, shoot twice, back up 30 in, turn 180, move forward 30 in, and smack down the ramp.
     */
    public AutonomousStopTop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //addSequential(new FindReset());

      //  addParallel(new Aim(1));
        addSequential(new SetPitch(105));
        
        addSequential(new ShootOn(0.4));
        addParallel(new FeedBallOn(1, 0.5));
        addSequential(new ShootBall());
        //addSequential(new ShootOn());
        addSequential(new ShootBall());
        addSequential(new FeedBallOff());
        addSequential(new ShootOff());
        
    }
}
