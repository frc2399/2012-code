package edu.wpi.first.wpilibj.templates.commands;

import java.lang.Math;

/**
 * A Command extending CommandBase that spins the robot for a specified distance 
 * at a given speed.  Used mostly for Autonomous.  
 * Requires DriveTrain.  
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
     * Tells the robot to spin.  
     * @param dist the distance you want the robot to spin.  Think of it an arc from a circle.  
     * @param speed a speed between -1 and 1.  
     */
    public Spinning(double dist, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        distToGo = dist;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    /**
     * Gets the initial values of the left and right encoders on the DriveTrain.  
     */
    protected void initialize() {
        //System.out.println("just pressed the goTestButt");
        rightInitial = driveTrain.getRightEncoder();
        leftInitial = driveTrain.getLeftEncoder();

        //change distToGo
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Sets the speed of the robot, with the wheels moving in different directions 
     * depending on the distance given.  
     */
    protected void execute() {
        if (distToGo >= 0) {
            driveTrain.setSpeed(-speed, speed);
        } else {
            driveTrain.setSpeed(speed, -speed);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * Uses the encoders to determine if the robot has gone the specified distance.  
     * @return true if the robot has gone the specified distance and false if it has not.  
     */
    protected boolean isFinished() {
        rightFinal = driveTrain.getRightEncoder();
        leftFinal = driveTrain.getLeftEncoder();
        double rightDist = rightFinal - rightInitial;
        double leftDist = leftFinal - leftInitial;

        if (Math.abs((rightDist - leftDist) / 2) >= Math.abs(distToGo)) {
            return true;
        } else {
            return false;
        }

    }

    // Called once after isFinished returns true
    /**
     * Sets the DriveTrain speed to zero, stopping the robot.  
     */
    protected void end() {
        driveTrain.setSpeed(0, 0);
        //System.out.println("end method");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
