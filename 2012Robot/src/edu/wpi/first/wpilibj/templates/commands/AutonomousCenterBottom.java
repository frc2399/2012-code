
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A Command that extends CommandGroup to make an Autonomous program for the Center position, 
 * aiming for the bottom hoop.
 * @author Jessie
 */
public class AutonomousCenterBottom extends CommandGroup {

    /**
     * Creates an Autonomous Command that uses the directions for aiming using the
     * AutonomousStopBottom and moving in the AutonomousCenterDirections.
     */
    public AutonomousCenterBottom() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        addSequential(new AutonomousStopBottom());
        addSequential(new AutonomousCenterDirections());
    }
}
