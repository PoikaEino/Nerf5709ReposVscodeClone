/*package frc.robot.subsystems;

import frc.robot.Robot;
import java.util.ArrayList;
import java.util.List;
//import org.opencv.core.Core;
import org.opencv.core.*;
//import org.opencv.core.MatOfPoint;
//import org.opencv.core.Rect;
//import org.opencv.core.Scalar;
//import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;

public class vision_Server extends Subsystem { 
    Mat frame = new Mat();
    Mat frameAfterColor = new Mat();
    Mat frameAfterThresh = new Mat();
    Mat frameAfterErode = new Mat();
    Mat contourImg;
    int low1 = 50;
    int low2;
    int low3;
    int high1 = 70;
    int high2;
    int high3;
    double minArea = 17; //1 foot and 5 inches
    double maxArea;
    boolean state = true;
    UsbCamera cam1 = new UsbCamera("cam1", 0);
    UsbCamera cam2 = new UsbCamera("cam2", 1);
    CvSink cvsink = CameraServer.getInstance().getVideo(cam1);
    CvSource outputStream = CameraServer.getInstance().putVideo("imageStream", 5, 5);
   
      protected void initDefaultCommand() {
  

    }
     public void imageOperations() {
        //Reads a single frame from the camera
        cvsink.grabFrame(frame); 
        //Converts it from RGB to HSV
        Imgproc.cvtColor(frame, frameAfterColor, Imgproc.COLOR_BGR2HSV);  
        //Thresholds the image so everything is eithier black or white (white being our reflective tape)
        Core.inRange(frameAfterColor, new Scalar(low1, low2, low3), new Scalar(high1, high2, high3), frameAfterThresh);
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_CROSS, new Size (5,5));
        Imgproc.morphologyEx(frameAfterThresh, frameAfterErode, Imgproc.MORPH_CLOSE, kernel);
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(frameAfterErode, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        for (int i = 0; i < contours.size(); i++) {
            //THESE TEST VALUES WILL HAVE TO BE CHANGED THROUGH TRIAL + ERROR
            //gets one of the contours to test, the i value always changes ("i++"), so the loop will always get another  contour
            Mat contour = contours.get(i);
            //gets the area of the contour and checks to see if it is around the same Area as our reflective tape
            double contourArea = Imgproc.contourArea(contour);

            if (contourArea > minArea && contourArea < maxArea) {
                continue;
            }
             
            //Creates a rectangle around the contour and uses it to get its solidility
             Rect boundRect = Imgproc.boundingRect(contour);
             double solidityRatio = contourArea /(boundRect.width * boundRect.height);

            //The closer solidity is to 1, the closer our rectangle fits the contours
            if ((solidityRatio > 0.9) && (solidityRatio < 1.1)) {
                continue;
            }

            Imgproc.drawContours(contourImg, contours, i, new Scalar(225, 225, 225), -1);
            outputStream.putFrame(contourImg);
            MjpegServer Server = new MjpegServer("ImageOutput", 1182);
            Server.setSource(outputStream);
        }

    }

    
  
}


*/

    