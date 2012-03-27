/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 * @author shannonphillips
 */
public class SpeedEncoder extends Counter implements PIDSource{

    public double pidGet(){
        return 1/getPeriod();
    }
            
            
}
