
package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
//IMPORTANT- FIND NEW CAN IMPORT
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Timer;
//Use this to list commands for the drivetrain that will be called in Drivetrain commands.
import edu.wpi.first.wpilibj.VictorSP;

public class ballshooter_Subsystem extends Subsystem {

  // creates the launch wheel motors
  SpeedController leftLaunchWheel = new Spark(4);
  SpeedController rightLaunchWheel = new Spark(5);

  // private VictorSPX Raise_Lower = new VictorSPX(RobotMap.Forklift_raise_lower);
  // creates the rest of the motors needed for ballshooter
  public VictorSPX conveyor = new VictorSPX(RobotMap.CONVEYOR);
  public VictorSPX intakeMotor = new VictorSPX(RobotMap.INTAKE_MOTOR);
  public Solenoid up_Down = new Solenoid(02, RobotMap.SOLENOID);
  public PWMVictorSPX climber = new PWMVictorSPX(RobotMap.CLIMB_MOTOR);
  public Compressor compressor = new Compressor(02);

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  }

  // used for auton
  public void autoFire() {
    // use pneumatics to set rear down
    leftLaunchWheel.set(1);
    rightLaunchWheel.set(-1);
    Timer.delay(2);
    conveyor.set(ControlMode.PercentOutput,-0.5);
    // Set conveyor
    Timer.delay(1);
    conveyor.set(ControlMode.PercentOutput, 0);
    leftLaunchWheel.set(0);
    rightLaunchWheel.set(0);
  }

  public void autoIntake() {
      intakeMotor.set(ControlMode.PercentOutput, 1);
      conveyor.set(ControlMode.PercentOutput, 1);
      Timer.delay(2);
      intakeMotor.set(ControlMode.PercentOutput, 0);
      conveyor.set(ControlMode.PercentOutput, 0);
    }



    //Function for setting the conveyor forward
     public void conveyorOn() {
      conveyor.set(ControlMode.PercentOutput, -0.5);
    }

    // Function for setting the conveyor in reverse
    public void conveyorReverse() {
     conveyor.set(ControlMode.PercentOutput, 0.5);
    }

     public void coveyorOff() {
      conveyor.set(ControlMode.PercentOutput, 0);
   }

   //Sets the pneumatics for intake down.
   public void down() {
     up_Down.set(false);
   }
   
   // Sets the pneumatics for intake up.
   public void up() {
     up_Down.set(true);
   }
   
    //Starts the outake wheels so the cargo is released
    public void releaseTheCargo() {
      leftLaunchWheel.set(1);
      rightLaunchWheel.set(-1);
    }
    
    public void releaseTheCargoSLOW() {
      leftLaunchWheel.set(0.5);
      rightLaunchWheel.set(-0.5);
    }
   
    public void keepCargo() {
      leftLaunchWheel.set(0);
      rightLaunchWheel.set(0);
    }
 
    //Starts the climb motor
    public void climb() {
      climber.set(1);
    }
    
    //Sets climb motor in reverse, this shouldn't be done in game.
    public void reverseClimb() {
      climber.set(-1);
    }

    public void climbOff() {
      climber.set(0);
    }
    
    //Starts intake wheels motor
    public void intakeOn() {
      intakeMotor.set(ControlMode.PercentOutput, 0.6);
    }

    public void intakeOff() {
      intakeMotor.set(ControlMode.PercentOutput, 0);
    }
    
    public void Stop () {
    conveyor.set(ControlMode.PercentOutput, 0);
    leftLaunchWheel.set(0);
    rightLaunchWheel.set(0);
    intakeMotor.set(ControlMode.PercentOutput, 0);
   }
}


