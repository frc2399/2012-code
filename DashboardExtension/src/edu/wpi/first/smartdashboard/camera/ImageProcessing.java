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
import edu.wpi.first.smartdashboard.robot.Robot;
import edu.wpi.first.wpilibj.networking.NetworkTable;
import java.util.ArrayList;

/**
 *
 * @author Gillie
 */
public class ImageProcessing extends WPICameraExtension {

    public ImageProcessing(){
        super();
        NetworkTable.setTeam(2399);
    }
    @Override
    public WPIImage processImage(WPIColorImage rawImage) {
        
        //find color thresholds: red(0,151), green(198,255), blue(0,255)
        WPIBinaryImage redBinary = rawImage.getRedChannel().getThresholdInverted(151);
        WPIBinaryImage greenBinary = rawImage.getGreenChannel().getThreshold(198);
        WPIBinaryImage blueBinary = rawImage.getBlueChannel().getThreshold(0);

        // contains the pixels that show up in all three of the other images
        WPIBinaryImage finalBinary = blueBinary.getAnd(redBinary).getAnd(greenBinary);

        finalBinary.dilate(7);
        finalBinary.erode(5);

        //use contours' getHeight and getWidth to find particles that are big enough to be considered
        WPIContour[] contours = finalBinary.findContours();
        ArrayList<WPIContour> finalContours = new ArrayList<WPIContour>();

        for (WPIContour c : contours) {
            if (c.getHeight() > 15 && c.getWidth() > 20) {
                finalContours.add(c);
            }
        }

        // find the centers of each of the contours
        double[] contourCentersX = new double[finalContours.size()];
        for (int i = 0; i < finalContours.size(); i++) {
            contourCentersX[i] = finalContours.get(i).getX() + 0.5 * finalContours.get(i).getWidth();
        }
        double[] contourCentersY = new double[finalContours.size()];
        for (int i = 0; i < finalContours.size(); i++) {
            contourCentersY[i] = finalContours.get(i).getY() + 0.5 * finalContours.get(i).getHeight();
        }
        // Puts the center in a 2D array 
        double[][] contourCenters = new double[finalContours.size()][2];
        for (int i = 0; i < finalContours.size(); i++) {
            contourCenters[i][0] = contourCentersX[i];
            contourCenters[i][1] = contourCentersY[i];
        }

        WPIPoint[] centerPoints = new WPIPoint[finalContours.size()];
        for (int i = 0; i < finalContours.size(); i++) {
            centerPoints[i] = new WPIPoint((int) (contourCentersX[i]), (int) (contourCentersY[i]));
        }
        rawImage.drawPoints(centerPoints, WPIColor.RED, 5);
        // figure out a way to return our centers- look up extensions?
        //possibly fixed- see NetworkTable things
        
        // put the centers into a table that goes to the robot
       
        for (int i = 0; i < finalContours.size(); i++) {
          NetworkTable.getTable("camera").putDouble("x" + i, contourCentersX[i]);  
          NetworkTable.getTable("camera").putDouble("y" + i, contourCentersY[i]);
        }
        
        return rawImage;
    }
}
