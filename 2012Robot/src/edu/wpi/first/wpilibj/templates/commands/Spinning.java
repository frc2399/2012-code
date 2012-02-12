
package edu.wpi.first.wpilibj.templates.commands;
import java.lang.Math;

/**
 *
 * @author Jessie and Emma
 */
public class Spinning extends CommandBase {
    
    double rightInitial;
    double leftInitial;
    double rightFinal;
    double leftFinal;
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
            rightInitial = driveTrain.getRightEncoder();
            leftInitial = driveTrain.getLeftEncoder();
        
        //change distToGo
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (distToGo >= 0){
            driveTrain.setSpeed(-speed, speed);
        } else {
            driveTrain.setSpeed(speed, -speed);
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        rightFinal = driveTrain.getRightEncoder();
        leftFinal = driveTrain.getLeftEncoder();
        double rightDist = rightFinal - rightInitial;
        double leftDist = leftFinal - leftInitial;
        
        if(Math.abs((rightDist - leftDist)/2) >= Math.abs(distToGo)){
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
