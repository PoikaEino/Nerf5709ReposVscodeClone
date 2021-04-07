//Format Update 2.0
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//Every motor that controls a moving part of our robot will be listed and numbererd in the RobotMap.
//Restart your count when you move on to a different cateogory of robot.

public class RobotMap {
	//wheels
	public static int 
	DRIVETRAIN_REAR_LEFT_WHEEL = 2,
    DRIVETRAIN_REAR_RIGHT_WHEEL = 3,
    DRIVETRAIN_FRONT_LEFT_WHEEL = 1,
    DRIVETRAIN_FRONT_RIGHT_WHEEL = 0;
	
	//Joysticks
	public static int
    XBOX_CONTROLLER = 0,
    XBOX_CONTROLLER_2 = 1;
	
	//Controller 1 Buttons
	public static final int
    A_BUTTON = 1,
    X_BUTTON = 3,
    Y_BUTTON = 4,
    B_BUTTON = 2,
    RIGHT_BUMPER = 6,
    LEFT_BUMPER = 5;
	
	//Controller 2 Buttons
	public static final int 
    A_BUTTON_2 = 1,
    B_BUTTON_2 = 2;
	
	//Ballshooter Motors
	public static final int
    LEFT_LAUNCH_WHEEL = 4,
    RIGHT_LAUNCH_WHEEL = 5,
    CONVEYOR = 6,
    INTAKE_MOTOR = 7,
    CLIMB_MOTOR = 8;
	
	public static final int
    SOLENOID = 1;
	
	public static final int
    compressor = 02;
	
	//Encoders
    // public static final int 
     //Left_EncoderA = 0,
     //Left_EncoderB = 1,
    // Right_EncoderA = 2,
    // Right_EncoderB = 3;
}


