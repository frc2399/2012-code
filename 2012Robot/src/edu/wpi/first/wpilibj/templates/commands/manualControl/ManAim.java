
package edu.wpi.first.wpilibj.templates.commands.manualControl;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author bradmiller
 */
public class ManAim  extends CommandGroup {

    public ManAim() {
        addParallel(new ManYaw());
        addParallel(new ManPitch());
    }

} 