/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.drivetrain_Commands.ExampleCommand;
import frc.robot.drivetrain_Commands.auton;
//import frc.robot.drivetrain_Commands.auton;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ballshooter_Subsystem;
import frc.robot.subsystems.drivetrain_Subsystem;
//import frc.robot.subsystems.vision_Server;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.I2C.Port;
//camera imports
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static final drivetrain_Subsystem drivetrain = new drivetrain_Subsystem();
  public static final ballshooter_Subsystem ballshooter = new ballshooter_Subsystem();
  //public static final vision_Server vision = new vision_Server();
  public static OI m_oi;
  boolean state;
  private SerialPort arduino;
  private Timer timer;


  
  Command m_autonomousCommand;
  Command command;
  
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  private Compressor MainCompressor;


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    command = new auton();
    MainCompressor = new Compressor(RobotMap.compressor);
    MainCompressor.setClosedLoopControl(true);
    MainCompressor.start();
    m_oi = new OI();
    arduino = new SerialPort(9600, SerialPort.Port.kUSB);
    timer = new Timer();
    timer.start();
    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    //m_chooser.addOption("My Auto", new auton());
    //SmartDashboard.putData("Auto mode", m_chooser);
    //UsbCamera cam1 = new UsbCamera("cam1", 0);
    //UsbCamera cam2 = new UsbCamera("cam2", 1);
    //allows us to view camera feed through dashboard
    //CameraServer.getInstance().startAutomaticCapture(0);
    //CameraServer.getInstance().startAutomaticCapture(1);
    //allows us to get the camera's feed for vision sensing
    //CameraServer.getInstance().getVideo(cam1);
    //CameraServer.getInstance().getVideo(cam2);
    

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    if (timer.get() > 5) {
      System.out.println("sent data to arduino");
      arduino.write(new byte[]{0x12}, 1);
      timer.reset();
    }

    if (arduino.getBytesReceived() > 0){
      System.out.println(arduino.readString());
    
    }
    System.out.println(arduino.getBytesReceived());
    
  }


  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    
    }
    
    
  
  

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
    
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    state = false;
   //Timer timer = new Timer();
   // timer.reset();
   // timer.start();
  // m_autonomousCommand = m_chooser.getSelected();
    
        
   //  String autoSelected = SmartDashboard.getString("Auto Selector",
   //  "Default"); switch(autoSelected) { case "My Auto": m_autonomousCommand
   //  = new auton(); break; case "Default Auto": default:
   //   m_autonomousCommand = new ExampleCommand(); break; }

     //  m_autonomousCommand = new auton();
      if (command != null) {
      command.start();
      }
      // }
	}
    
   

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    
     
    
  

 

/**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    //Robot.vision.imageOperations();
  }

  @Override
  public void teleopInit() {
    state = true;
  
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
      if (command != null) {
      command.cancel();
      
   }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    MainCompressor.setClosedLoopControl(true);
    MainCompressor.start();

  }
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
