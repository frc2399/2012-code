/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.smartdashboard.camera;

import edu.wpi.first.smartdashboard.camera.WPICameraExtension;
import edu.wpi.first.wpijavacv.WPIColor;
import edu.wpi.first.wpijavacv.WPIImage;
import edu.wpi.first.wpijavacv.WPIColorImage;
import edu.wpi.first.wpijavacv.WPIBinaryImage;
import edu.wpi.first.wpijavacv.WPIGrayscaleImage;
import edu.wpi.first.wpijavacv.WPIContour;
import edu.wpi.first.wpijavacv.WPIPoint;
import edu.wpi.first.wpijavacv.WPIPolygon;
import java.util.ArrayList;

/**
 *
 * @author Gillie
 */
public class ImageProcessing extends WPICameraExtension {

    @Override
    public WPIImage processImage(WPIColorImage rawImage) {


        /* things to do:
         * color thresholds: red(0,151), green(198,255), blue(0,255)
         * 
         */
        WPIBinaryImage redBinary = rawImage.getRedChannel().getThresholdInverted(150);
        WPIBinaryImage greenBinary = rawImage.getGreenChannel().getThresholdInverted(198);
        WPIBinaryImage blueBinary = rawImage.getBlueChannel().getThreshold(0);
       
        // contains the pixels that show up in all three of the other images
        WPIBinaryImage finalBinary = blueBinary.getAnd(redBinary).getAnd(greenBinary);
        
        finalBinary.dilate(6);
        
        
        return rawImage.getGreenChannel();
    }
}
