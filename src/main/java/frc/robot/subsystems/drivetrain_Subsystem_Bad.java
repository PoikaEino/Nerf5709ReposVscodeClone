package frc.robot.subsystems;
import frc.robot.drivetrain_Commands.mechanum_Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.Robot;
import frc.robot.OI;
//Use this to list commands for the drivetrain that will be called in Drivetrain commands.

public class drivetrain_Subsystem_Bad extends Subsystem {
    //Creates the four driving spark motors
    SpeedController frontRightMotor = new Spark(0);
    SpeedController frontLeftMotor = new Spark(1);
    SpeedController  rearRightMotor = new Spark(3);
    SpeedController rearLeftMotor = new Spark(2);
    //Creates the Gyro
    private ADXRS450_Gyro Gyro = new ADXRS450_Gyro();

      Encoder encoder = new Encoder (0, 1);
      Encoder encoder2= new Encoder (0, 2);
      Encoder encoder3= new Encoder (0, 3);
      Encoder encoder4 = new Encoder (0, 4);

   // Creates the number that will be plugged in and used to control the Motors. This number will be changed constantly by the joystick.
    double frontRightMotorSpeed = 0;
    double frontLeftMotorSpeed = 0;
    double rearRightMotorSpeed = 0;
    double rearLeftMotorSpeed = 0;
   
    //public MecanumDrive drive = new MecanumDrive(frontRightMotor, frontLeftMotor, rearRightMotor, rearLeftMotor);
    // y will be used to mean speed

public void initDefaultCommand() {
    // Sets default command
    setDefaultCommand(new mechanum_Drive());
  }
    //Auto drive. The Auto commands fill in what the three paramaters should be.
    public void auton_Drive (double forward, double sideways, double rotate) {
    double kp = 0.03;
    if (forward == 0) {
    kp = 0.07;
    }   
    double angle = Gyro.getAngle();
      {
        if (forward < 0) {
        angle = angle * -1;
        }
      }
    rotate = -angle * kp - rotate;
    frontRightMotor.set((forward + sideways - rotate) * -1);
    frontLeftMotor.set((forward - sideways - rotate) * -1);
    rearRightMotor.set(forward - sideways + rotate);
    rearLeftMotor.set(forward + sideways + rotate);
    }
    
    public void TeleopDrive(double ymovement, double xmovement, double rotatemovement) {
        //These combinations (with the plus and -) match up with what the value of each movement
        //stat will be for each motor during that movement stat's 'positive' movement.
        //The front motors are inverted, hence the multiplying by -1
        frontRightMotorSpeed = ymovement + xmovement;
        frontLeftMotorSpeed = ymovement - xmovement;
        rearRightMotorSpeed = ymovement - xmovement;
        rearLeftMotorSpeed = ymovement + xmovement;

        if (frontRightMotorSpeed > 1){
            frontRightMotorSpeed = 1;
        }
        else if (frontRightMotorSpeed < -1){
            frontRightMotorSpeed = -1;
        }

        if (frontLeftMotorSpeed > 1){
            frontLeftMotorSpeed = 1;
        }
        else if (frontLeftMotorSpeed < -1){
           frontLeftMotorSpeed = -1;
        }

        if (rearLeftMotorSpeed > 1){
            rearLeftMotorSpeed = 1;
        }
        else if (rearLeftMotorSpeed < -1){
           rearLeftMotorSpeed = -1;
        }

          if (rearRightMotorSpeed > 1){
            rearRightMotorSpeed = 1;
        }
        else if (rearRightMotorSpeed < -1){
           rearRightMotorSpeed = -1;
        }

        frontRightMotor.set(((frontRightMotorSpeed) + rotatemovement) * -1);
        frontLeftMotor.set(((frontLeftMotorSpeed) + rotatemovement) * -1);
        rearRightMotor.set((rearRightMotorSpeed) - rotatemovement);
        rearLeftMotor.set((rearLeftMotorSpeed) - rotatemovement);
        
        if (Math.abs(frontRightMotorSpeed) > 1 || Math.abs(rearRightMotorSpeed) > 1 || Math.abs(rearRightMotorSpeed) > 1 || Math.abs(rearLeftMotorSpeed) > 1) {
            double max = 0;
            //finds the largest of the two values and copes it to the "max" double
            max = Math.max(Math.abs(frontRightMotorSpeed), Math.abs(rearRightMotorSpeed));
            max = Math.max(Math.abs(frontLeftMotorSpeed), max);
            max = Math.max(Math.abs(rearRightMotorSpeed), max);
            frontRightMotorSpeed = frontRightMotorSpeed / max;
            rearRightMotorSpeed = rearRightMotorSpeed / max;
            frontLeftMotorSpeed = frontLeftMotorSpeed / max;
            frontRightMotorSpeed = frontRightMotorSpeed / max;
            rearRightMotorSpeed = rearRightMotorSpeed / max;

        }
     }

   
    public void getGyro() {
      //  return Gyro.getRate();
    }

    public void getEncoder() {
     //   return encoder.getRaw();
    }

    public void getEncoder2() {
     //   return encoder2.getRaw();
    }
    
    public void getEncoder3() {
       // return encoder3.getRaw();
    }

    public void getEncoder4() {
       // return encoder4.getRaw();
    }

    public void resetEncoders(){
     //   encoder.reset();
     //   encoder2.reset();
      //  encoder3.reset();
      //  encoder4.reset();
    }

    public void reset(){
        Gyro.reset();
    }

    public double getdistance() {
        return encoder2.getRaw();
    }
 
    public void Stop(){
     //sets xmovement, ymovement, and turnmovement to 0.
    Robot.drivetrain.TeleopDrive(0, 0, 0);
    //comment out if it wont run
    }
}
 
