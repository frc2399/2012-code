
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A Command that extends CommandGroup to make an Autonomous program for the Center position, 
 * aiming for the Left hoop.
 * @author Jessie
 */
public class AutonomousCenterLeft extends CommandGroup {

    /**
     * Creates an Autonomous Command that uses the directions for aiming using the
     * AutonomousStopLeft and moving in the AutonomousCenterDirections.
     */
    public AutonomousCenterLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        addSequential(new AutonomousStopLeft());
        addSequential(new AutonomousCenterDirections());
    }
}
