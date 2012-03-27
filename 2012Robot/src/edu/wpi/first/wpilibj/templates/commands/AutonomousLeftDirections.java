
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 * A Command that extends CommandGroup to make directions for a Left 
 * Autonomous program.
 * @author Jessie
 */
public class AutonomousLeftDirections extends CommandGroup{

    /**
     * Creates an Autonomous Command for the left position that runs through the following steps:
     * aim at the top target, shoot twice, back up 20 in, turn 45 counter clockwise, 
     * move backward 64 in, turn 45 clockwise, move backward 27 in, and smack down the ramp.
     */
    public AutonomousLeftDirections() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        addSequential(new ShmackDown());
        addSequential(new Go(-20.0, 0.75));
        //counter clockwise
        addSequential(new Spinning(DriveTrain.Turn45Fast, 0.5));
        addSequential(new Go(-74.0, 0.75));
        //clockwise
        addSequential(new Spinning(DriveTrain.TurnNeg45Fast, 0.5));
        addSequential(new Go(-53.0, 0.75));
    }
}
