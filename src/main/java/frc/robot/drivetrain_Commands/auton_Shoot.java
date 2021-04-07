package frc.robot.drivetrain_Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class auton_Shoot extends Command {

    protected void initialize() {
        Timer timer = new Timer();
        timer.reset();
        timer.start(); 
    }
	
	protected void execute() {
     Robot.ballshooter.autoFire();
}

protected void end () {
    isFinished();
}

   protected boolean isFinished() {
       return true;
   }
}

