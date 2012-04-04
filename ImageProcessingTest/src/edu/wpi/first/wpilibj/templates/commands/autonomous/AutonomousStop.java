
package edu.wpi.first.wpilibj.templates.commands.autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.NewAim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;

import edu.wpi.first.wpilibj.templates.commands.FindReset;

/** 
 * A Command that extends CommandGroup to make an Autonomous program for the center position.
 * @author Gillie
 */
public class AutonomousStop extends CommandGroup {

    /**
     * Creates an Autonomous Command for the center position that runs through the following steps:
     * aim at the top target, shoot twice, back up 30 in, turn 180, move forward 30 in, and smack down the ramp.
     */
    public AutonomousStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addSequential(new FindReset());

        /*addParallel(new Aim(1));
        addSequential(new ShootOn());
        addSequential(new ShootBall());
        addSequential(new ShootBall());
        addSequential(new ShootOff());
         * 
         */
        
    }
}
