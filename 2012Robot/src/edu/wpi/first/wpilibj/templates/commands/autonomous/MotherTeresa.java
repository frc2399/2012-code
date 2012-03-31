
package edu.wpi.first.wpilibj.templates.commands.autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.FeedBallOn;
import edu.wpi.first.wpilibj.templates.commands.UnloadBall;
/** 
 * A Command that extends CommandGroup to make an Autonomous program for the center position.
 * @author Gillie
 */
public class MotherTeresa extends CommandGroup {

    /**
     * Creates an Autonomous Command for the center position that runs through the following steps:
     * aim at the top target, shoot twice, back up 30 in, turn 180, move forward 30 in, and smack down the ramp.
     */
    public MotherTeresa() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //addSequential(new FindReset());
       // addSequential(new AutonomousAimStart());
      //  addParallel(new Aim(1));
        addParallel(new UnloadBall());
        addParallel(new FeedBallOn(-1, 0.5));
        
    }
}
