
package frc.robot.ballzooka_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class intake_Set extends Command {
    boolean intakewheelstate = false;	
    
    protected void initialize() {
    }
	
	protected void execute() {

        if(Robot.m_oi.XBOX2.getBButton() == true) {     
                Robot.ballshooter.intakeOn();
        }

        else {
            Robot.ballshooter.intakeOff();
        }

    }
	

	@Override
	protected boolean isFinished() {
      return false;
	}
	
	protected void end() {
        Robot.ballshooter.intakeOff();
    }
	
	protected void Interrupted() {
    end();
    }

}

