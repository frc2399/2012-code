
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Jessie
 */
public class AutonomousCenterTest extends CommandGroup {

    public AutonomousCenterTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addSequential(new AutonomousCenterDirections());
    }

}
