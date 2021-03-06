
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Go;
import edu.wpi.first.wpilibj.templates.commands.Spinning;
import edu.wpi.first.wpilibj.templates.commands.Aim;
import edu.wpi.first.wpilibj.templates.commands.LoadBall;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.commands.ShmackDown;
import edu.wpi.first.wpilibj.templates.commands.AutonomousStopLeft;


/**
 * A Command that extends CommandGroup to make an Autonomous program for the left position, 
 * aiming for the left hoop.
 * @author Lauren and Jessie
 */
public class AutonomousLeftLeft extends CommandGroup {

    /**
     * Creates an Autonomous Command that uses the directions for aiming using the
     * AutonomousStopLeft and moving in the AutonomousLeftDirections.
     */
    public AutonomousLeftLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        addSequential(new AutonomousStopLeft());
        addSequential(new AutonomousLeftDirections());
    }
}
    