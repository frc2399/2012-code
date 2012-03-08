/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpijavacv;

import java.util.ArrayList;
import edu.wpi.first.wpijavacv.WPIBinaryImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_core.*;

/**
 *
 * @author Gillie
 */
public class BinaryImageExtension extends WPIBinaryImage {

    public BinaryImageExtension(IplImage image) {
        super(image);
    }

        public BinaryImageExtension(WPIBinaryImage wpiImage) {
            super(wpiImage.image);
       // this.image = wpiImage.image;
    }
    
    @Override
    public WPIContour[] findContours() {
        validateDisposed();

        IplImage tempImage = IplImage.create(image.cvSize(), image.depth(), 1);

        cvCopy(image, tempImage);

        final CvMemStorage storage = CvMemStorage.create();
        WPIMemoryPool pool = new WPIMemoryPool() {

            @Override
            protected void disposed() {
                cvClearMemStorage(storage);
                storage.release();
            }
        };

        CvSeq contours = new CvSeq();
        cvFindContours(tempImage, storage, contours, 256, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_TC89_KCOS);
        ArrayList<WPIContour> results = new ArrayList();
        while (!isNull(contours)) {
            WPIContour contour = new WPIContour(cvCloneSeq(contours, storage));
            results.add(contour);
            pool.addToPool(contour);
            contours = contours.h_next();
        }

        tempImage.release();
        WPIContour[] array = new WPIContour[results.size()];
        return results.toArray(array);
    }
}
