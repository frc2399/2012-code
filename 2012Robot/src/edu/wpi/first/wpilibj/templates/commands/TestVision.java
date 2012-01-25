package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.image.RGBImage;

/**
 *
 * @author bradmiller
 */
public class TestVision extends CommandBase {

    AxisCamera camera;

    public TestVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        camera = AxisCamera.getInstance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            ColorImage image = camera.getImage();
            BinaryImage greenThreshold = image.thresholdRGB(0,151,198,255,0,255);
            BinaryImage convexHullImage = greenThreshold.convexHull(false);
            
            
        } catch (AxisCameraException ex){
        
        }
        catch (NIVisionException ex) {
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
