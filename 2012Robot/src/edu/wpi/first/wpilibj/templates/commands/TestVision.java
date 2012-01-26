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
    CriteriaCollection cc;

    public TestVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        camera = AxisCamera.getInstance();
        cc = new CriteriaCollection();
        cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 20, 400, false);
        cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 15, 400, false);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            ColorImage image = camera.getImage();
            BinaryImage greenThreshold = image.thresholdRGB(0, 187, 189, 255, 0, 225);
            BinaryImage convexHullImage = greenThreshold.convexHull(false);
            BinaryImage noSmallParticles = convexHullImage.removeSmallObjects(false, 7);
            BinaryImage foundParticles = noSmallParticles.particleFilter(cc);

            /* what to do with ParticleAnalysisReport:
             * want center of particles, number of particles
             * we'll just print it for now
             */
            ParticleAnalysisReport[] reports = foundParticles.getOrderedParticleAnalysisReports();  // get list of results
            System.out.println("Number of particles: " + reports.length);
            for (int i = 0; i < reports.length; i++) {                                // print results
                ParticleAnalysisReport r = reports[i];
                double centerX = r.boundingRectLeft + 0.5 * r.boundingRectWidth;
                double centerY = r.boundingRectTop + 0.5 * r.boundingRectHeight;
                System.out.println("Particle: " + i + " center: (" + centerX + "," + centerY +")");
            }

        } catch (AxisCameraException ex) {
        } catch (NIVisionException ex) {
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
