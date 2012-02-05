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

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Gillie
 */
public class ImageProcessing extends WPICameraExtension {
NetworkTable testTable;
    public ImageProcessing() {
        super();
        testTable = new NetworkTable();
    }

    @Override
    public WPIImage processImage(WPIColorImage rawImage) {

        NetworkTable.setTeam(2399);
            testTable.putInt("testNum", 6022);
            NetworkTable.getTable("SmartDashboard").putSubTable("test",testTable);
        //   NetworkTable.getTable("SmartDashboard").getSubTable("test").putInt("testNum", 2399);
        return rawImage;
    }
}
