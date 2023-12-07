package util;

import org.opencv.core.*;

import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.awt.Rectangle;
import java.awt.geom.*;

public class Detector {
    public static Rectangle getFaceGeometry(String path) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat image = Imgcodecs.imread(path);

        CascadeClassifier faceCascade = new CascadeClassifier("xml/haarcascade_frontalface_alt.xml");

        MatOfRect face = new MatOfRect();
        faceCascade.detectMultiScale(image, face);

        faceCascade = null;

        if (!face.empty()) {
            Rect rect = face.toArray()[0];
            return new Rectangle(
                    rect.x + (rect.width / 9),
                    (rect.y + (rect.height / 2)) - (rect.height / 3),
                    rect.width - (rect.width / 5),
                    (rect.y - ((rect.height / 6) * 2)));
        } else {
            return null;
        }
    }
}
