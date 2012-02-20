
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Jessie
 */
public class AutonomousCenterLeft extends CommandGroup {

    public AutonomousCenterLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        addSequential(new AutonomousStopLeft());
        
        addSequential(new Go(-60.0, 0.5));
        addSequential(new ShmackDown());
    }
}
