
package edu.wpi.first.wpilibj.templates.commands;

/**
 * A Command that extends CommandBase used mainly for Autonomous modes.  
 * Moves the robot forward and backward at a specified speed for a specified distance, then stops. 
 * @author Jessie and Emma
 */
public class Go extends CommandBase {
    
    double ticksInitial;
    double ticksFinal;
    double distToGo;
    double speed;
    
    /**
     * Moves the robot either forward or backward at a certain speed then stops.
     * @param dist the distance you want to go in inches
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
    /**
     * sets the initial value from the encoders by taking the average of the two DriveTrain encoders.
     */
    protected void initialize() {
        ticksInitial = (driveTrain.getRightEncoder() + driveTrain.getLeftEncoder()) / 2;
        //change distToGo
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * moves the robot at the given speed and updates the average value of the two DriveTrain encoders.
     */
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
    /**
     * takes the average value from execute and compares it to the inputed distance.
     * @return true if the robot has reached its destination and false if it has not.
     */
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
    /**
     * sets the speed of the DriveTrain to zero, making the robot stop moving along the floor.  
     */
    protected void end() {
        driveTrain.setSpeed(0, 0);
        System.out.println("end method");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
