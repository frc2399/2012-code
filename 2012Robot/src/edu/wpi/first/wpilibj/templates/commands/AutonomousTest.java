
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Jessie
 */
public class AutonomousTest extends CommandGroup {

    public AutonomousTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
       
        addSequential(new AutonomousCenterDirections());
    }

}
