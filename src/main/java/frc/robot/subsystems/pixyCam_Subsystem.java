/*package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

import io.github.pseudoresonance.pixy2api.*;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

public class pixyCam_Subsystem extends Subsystem {
    public class Pixy2 {

        public final static int PIXY_BUFFERSIZE = 0x104;
        public final static int PIXY_SEND_HEADER_SIZE = 4;
        public final static int PIXY_MAX_PROGNAME = 33;
        public final static int PIXY_DEFAULT_ARGVAL = 0x80000000;
        public final static int PIXY_CHECKSUM_SYNC = 0xc1af;
        public final static int PIXY_NO_CHECKSUM_SYNC = 0xc1ae;
    
        // Packet types
        public final static byte PIXY_TYPE_REQUEST_CHANGE_PROG = 0x02;
        public final static byte PIXY_TYPE_REQUEST_RESOLUTION = 0x0c;
        public final static byte PIXY_TYPE_RESPONSE_RESOLUTION = 0x0d;
        public final static byte PIXY_TYPE_REQUEST_VERSION = 0x0e;
        public final static byte PIXY_TYPE_RESPONSE_VERSION = 0x0f;
        public final static byte PIXY_TYPE_RESPONSE_RESULT = 0x01;
        public final static byte PIXY_TYPE_RESPONSE_ERROR = 0x03;
        public final static byte PIXY_TYPE_REQUEST_BRIGHTNESS = 0x10;
        public final static byte PIXY_TYPE_REQUEST_SERVO = 0x12;
        public final static byte PIXY_TYPE_REQUEST_LED = 0x14;
        public final static byte PIXY_TYPE_REQUEST_LAMP = 0x16;
        public final static byte PIXY_TYPE_REQUEST_FPS = 0x18;
    
        // Return result values
        public final static byte PIXY_RESULT_OK = 0;
        public final static byte PIXY_RESULT_ERROR = -1;
        public final static byte PIXY_RESULT_BUSY = -2;
        public final static byte PIXY_RESULT_CHECKSUM_ERROR = -3;
        public final static byte PIXY_RESULT_TIMEOUT = -4;
        public final static byte PIXY_RESULT_BUTTON_OVERRIDE = -5;
        public final static byte PIXY_RESULT_PROG_CHANGING = -6;
    
        // RC-servo values
        public final static int PIXY_RCS_MIN_POS = 0;
        public final static int PIXY_RCS_MAX_POS = 1000;
        public final static int PIXY_RCS_CENTER_POS = ((PIXY_RCS_MAX_POS - PIXY_RCS_MIN_POS) / 2);
    
        public enum LinkType {
            SPI, I2C, UART;
        }

        public int init() {
            return (PIXY_DEFAULT_ARGVAL);
        }

        public Pixy2 createInstance(Link link) {
            return new Pixy2(link);
        }
   

    

public void initDefaultCommand() {
   
  }
  

    public void reset(){
     //   Gyro.reset();
    }

    public void Line(){
        
    }

    public void colorDetect(){
    }
 
    public void Stop(){
    }
}


*/




