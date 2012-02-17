
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Victor;




/**
 *
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Victor shootMotor = new Victor(RobotMap.shootMotor);
    
    public Shooter(){
        
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
    public void setSpeed(double speed){
        shootMotor.set(speed);
    }
    
    public double getShooterSpeed(){
        return shootMotor.get(); 
    }
    public boolean upToSpeed(){
        if(getShooterSpeed() >= .5){
            return true;
        } else {
            return false;
        }
    }

}

