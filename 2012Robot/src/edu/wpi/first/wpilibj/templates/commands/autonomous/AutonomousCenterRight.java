
package edu.wpi.first.wpilibj.templates.commands.autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A Command that extends CommandGroup to make an Autonomous program for the center position, 
 * aiming for the right hoop.
 * @author Jessie
 */
public class AutonomousCenterRight extends CommandGroup {

    /**
     * Creates an Autonomous Command that uses the directions for aiming using the
     * AutonomousStopRight and moving in the AutonomousCenterDirections.
     */
    public AutonomousCenterRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        addSequential(new AutonomousStopRight());
        addSequential(new AutonomousCenterDirections());
    }
}
