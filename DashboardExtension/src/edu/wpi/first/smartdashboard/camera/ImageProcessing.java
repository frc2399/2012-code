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
       
        //find color thresholds: red(0,151), green(198,255), blue(0,255)
        WPIBinaryImage redBinary = rawImage.getRedChannel().getThresholdInverted(151);
        WPIBinaryImage greenBinary = rawImage.getGreenChannel().getThreshold(198);
        WPIBinaryImage blueBinary = rawImage.getBlueChannel().getThreshold(0);
       
        // contains the pixels that show up in all three of the other images
        WPIBinaryImage finalBinary = blueBinary.getAnd(redBinary).getAnd(greenBinary);
        
        finalBinary.dilate(6);
        finalBinary.erode(5);
        
        //use contours' getHeight and getWidth to find particles that are big enough to be considered
        WPIContour[] contours = finalBinary.findContours();
        ArrayList<WPIContour> finalContours = new ArrayList<WPIContour>(); 
        
        for (WPIContour c : contours){
           if (c.getHeight() > 15 && c.getWidth() > 20){
               finalContours.add(c);
           }
        }
        
        // find the centers of each of the contours
        double[] contourCentersX = new double[finalContours.size()];
        for (int i = 0; i < finalContours.size(); i++){
           contourCentersX[i] = finalContours.get(i).getX() + 0.5*finalContours.get(i).getWidth();
        }
double[] contourCentersY = new double[finalContours.size()];
        for (int i = 0; i < finalContours.size(); i++){
           contourCentersY[i] = finalContours.get(i).getY() + 0.5*finalContours.get(i).getHeight();
        }            
        
        
     
        return rawImage.getGreenChannel();
    }
}
