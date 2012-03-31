
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
     * Creates an Autonomous Command that feeds balls out of the robot instead of 
     * up to the shooter. 
     */
    public MotherTeresa() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addParallel(new UnloadBall());
        addParallel(new FeedBallOn(-1, 0.5));
        
    }
}
