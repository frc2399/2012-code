
package edu.wpi.first.wpilibj.templates.commands.autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.NewAim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;

/**
 * A Command that extends CommandGroup to make an Autonomous program for the right position, 
 * aiming for the right hoop.
 * @author Gillie and Jessie
 */
public class AutonomousRightRight extends CommandGroup {

    /**
     * Creates an Autonomous Command that uses the directions for aiming using the
     * AutonomousStopRight and moving in the AutonomousRightDirections.
     */
    public AutonomousRightRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        addSequential(new AutonomousStopRight());
        addSequential(new AutonomousRightDirections());
    }
}
