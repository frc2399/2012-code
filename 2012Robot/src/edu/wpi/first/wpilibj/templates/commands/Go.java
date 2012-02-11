
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jessie and Emma
 */
public class Go extends CommandBase {
    
    double ticksInitial;
    double ticksFinal;
    double distToGo;
    double speed;
    
    /**
     * 
     * @param dist the distance you want to go
     * @param speed any speed between -1 and 1
     */
    public Go(double dist, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        if(dist >= 0){
            distToGo = dist - 4.25;
        } else {
            distToGo = dist + 4.25;
        }
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("just pressed the goTestButt");
        ticksInitial = (driveTrain.getRightEncoder() + driveTrain.getLeftEncoder()) / 2;
        //change distToGo
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (distToGo >= 0){
            driveTrain.setSpeed(speed, speed);
            ticksFinal = (driveTrain.getRightEncoder() + driveTrain.getLeftEncoder()) / 2;
            System.out.println("ticksFinal is:" + ticksFinal);
        } else {
            driveTrain.setSpeed(-speed, -speed);
            ticksFinal = (driveTrain.getRightEncoder() + driveTrain.getLeftEncoder()) / 2;
            System.out.println("ticksFinal is:" + ticksFinal);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(distToGo >= 0 && ticksFinal - ticksInitial >= distToGo){
            return true;
        } else if(distToGo < 0 && ticksFinal - ticksInitial <= distToGo) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.setSpeed(0, 0);
        System.out.println("end method");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
