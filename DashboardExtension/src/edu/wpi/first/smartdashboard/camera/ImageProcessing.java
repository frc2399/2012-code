/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.smartdashboard.camera;
import edu.wpi.first.smartdashboard.camera.WPICameraExtension; 
import edu.wpi.first.wpijavacv.WPIImage;
import edu.wpi.first.wpijavacv.WPIColorImage;
/**
 *
 * @author Gillie
 */
public class ImageProcessing extends WPICameraExtension{
    
    @Override
    public WPIImage processImage(WPIColorImage rawImage){
    return rawImage.getRedChannel();   
    }
    
}
