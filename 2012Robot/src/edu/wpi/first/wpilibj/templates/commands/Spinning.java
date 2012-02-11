
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jessie and Emma
 */
public class Spinning extends CommandBase {
    
    double inchesInitial;
    double inchesFinal;
    double distToGo;
    double speed;
    
    /**
     * 
     * @param dist the distance you want to go
     */
    public Spinning(double dist, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        distToGo = dist;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //System.out.println("just pressed the goTestButt");
            inchesInitial = (driveTrain.getRightEncoder() - driveTrain.getLeftEncoder()) / 2;
        
        //change distToGo
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (distToGo >= 0){
            driveTrain.setSpeed(-speed, speed);
            inchesFinal = (driveTrain.getRightEncoder() - driveTrain.getLeftEncoder()) / 2;
        } else {
            driveTrain.setSpeed(speed, -speed);
            inchesFinal = (-driveTrain.getRightEncoder() + driveTrain.getLeftEncoder()) / 2;
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(distToGo >= 0 && inchesFinal - inchesInitial >= distToGo){
            return true;
        } else if(distToGo < 0 && inchesFinal - inchesInitial <= distToGo) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.setSpeed(0, 0);
        //System.out.println("end method");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
