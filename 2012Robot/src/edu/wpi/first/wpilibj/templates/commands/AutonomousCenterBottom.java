
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Jessie
 */
public class AutonomousCenterBottom extends CommandGroup {

    public AutonomousCenterBottom() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        addSequential(new AutonomousStopBottom());
        
        addSequential(new Go(-60.0, 0.5));
        addSequential(new ShmackDown());
    }
}
