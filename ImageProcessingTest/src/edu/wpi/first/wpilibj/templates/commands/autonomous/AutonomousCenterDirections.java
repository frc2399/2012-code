
package edu.wpi.first.wpilibj.templates.commands.autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;

import edu.wpi.first.wpilibj.templates.commands.autonomous.AutonomousStopTop;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;

/** 
 * A Command that extends CommandGroup to make directions for a Center 
 * Autonomous program.
 * @author Jessie
 */
public class AutonomousCenterDirections extends CommandGroup {

    /**
     * Creates an Autonomous Command for the center position that runs through the following steps:
     * aim at the top target, shoot twice, back up 60 in, and smack down the ramp.
     */
    public AutonomousCenterDirections() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
       
        addSequential(new ShmackDown());
        addSequential(new Go(-86.0, 0.5));

        
    }
}
