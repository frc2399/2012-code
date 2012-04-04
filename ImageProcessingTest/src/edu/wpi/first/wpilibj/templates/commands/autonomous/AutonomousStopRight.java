
package edu.wpi.first.wpilibj.templates.commands.autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;

import edu.wpi.first.wpilibj.templates.commands.FindReset;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.commands.ShootOff;
import edu.wpi.first.wpilibj.templates.commands.ShootOn;

/** 
 * A Command that extends CommandGroup to make an Autonomous program for the center position.
 * @author Gillie
 */
public class AutonomousStopRight extends CommandGroup {

    /**
     * Creates an Autonomous Command for the center position that runs through the following steps:
     * aim at the top target, shoot twice, back up 30 in, turn 180, move forward 30 in, and smack down the ramp.
     */
    public AutonomousStopRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addSequential(new FindReset());
     
        addParallel(new Aim(2));
        addSequential(new ShootOn(0.4));
        addSequential(new ShootBall());
        addSequential(new ShootBall());
        addSequential(new ShootOff());
        
    }
}
