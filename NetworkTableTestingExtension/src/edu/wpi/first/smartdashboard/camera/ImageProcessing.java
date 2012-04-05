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
import edu.wpi.first.wpijavacv.BinaryImageExtension;
import edu.wpi.first.wpijavacv.WPIGrayscaleImage;
import edu.wpi.first.wpijavacv.WPIContour;
import edu.wpi.first.wpijavacv.WPIPoint;
import edu.wpi.first.wpijavacv.WPIPolygon;

import edu.wpi.first.smartdashboard.robot.Robot;
import edu.wpi.first.wpilibj.networking.NetworkTable;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Gillie
 */
public class ImageProcessing extends WPICameraExtension {
    
    WPIColorImage computerImage;  
    private NetworkTable table;
    
    public ImageProcessing() {
        super();
        NetworkTable.setIPAddress("10.23.99.2");
        table = NetworkTable.getTable("camera");
    }

    @Override
    public WPIImage processImage(WPIColorImage rawImage) {

        //find color thresholds:
        //for green light: red(0,141), green(193,255), blue(0,146)
        //for red light: red(191,255), green(0,158), blue (78,255)
        BinaryImageExtension redBinary = new BinaryImageExtension(rawImage.getRedChannel().getThreshold(191));
        BinaryImageExtension greenBinary = new BinaryImageExtension(rawImage.getGreenChannel().getThresholdInverted(158)); 
        BinaryImageExtension blueBinary = new BinaryImageExtension(rawImage.getBlueChannel().getThreshold(78)); 

        // contains the pixels that show up in all three of the other images
        BinaryImageExtension finalBinary = new BinaryImageExtension(blueBinary.getAnd(redBinary).getAnd(greenBinary));

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

        // set everything currently in the table to -1 so that we can throw out 
        //contours that no longer exist
 
            for (int i = 0; i < (table.getKeys().size()/2); i++) {
                table.beginTransaction();
                table.putDouble("x" + i, -1);
                table.putDouble("y" + i, -1);
                table.endTransaction();
            }

            // put the centers into a table that goes to the robot
            
            for (int i = 0; i < finalContours.size(); i++) {
                table.beginTransaction();
                table.putDouble("x" + i, contourCentersX[i]);
                table.putDouble("y" + i, contourCentersY[i]);
                table.endTransaction();
            }
            
        
       // for (int i = 0; i < centerPoints.length; i++){
       // System.out.println(centerPoints[i].getX() +", " + centerPoints[i].getY());
        //        }

        
        table.beginTransaction();
        table.putBoolean("found", true);
        table.endTransaction();
             /* 
        table.putDouble("distance", 23.0);
        table.putDouble("offset", 0.99);
        table.endTransaction();
        return rawImage;
         */
            return rawImage;
    }
}
