
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Go;
import edu.wpi.first.wpilibj.templates.commands.Spinning;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;
import edu.wpi.first.wpilibj.templates.commands.AutonomousAimStart;
import edu.wpi.first.wpilibj.templates.commands.AutonomousStopTop;

/** 
 * A Command that extends CommandGroup to make an Autonomous program for the center position.
 * @author Emma and Jessie
 */
public class AutonomousCenter extends CommandGroup {

    /**
     * Creates an Autonomous Command for the center position that runs through the following steps:
     * aim at the top target, shoot twice, back up 60 in, and smack down the ramp.
     */
    public AutonomousCenter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        addSequential(new AutonomousStopTop());
        
        addSequential(new Go(-60.0, 0.5));
        addSequential(new ShmackDown());
        
        
    }
}
