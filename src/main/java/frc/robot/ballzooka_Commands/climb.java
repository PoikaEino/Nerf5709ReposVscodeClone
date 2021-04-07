package frc.robot.ballzooka_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class climb extends Command {

    protected void initialize() {
        Robot.ballshooter.climbOff();
    }
	
	protected void execute() {
         while ((Robot.m_oi.XBOX.getAButton()) == true) {
                Robot.ballshooter.climb();
         }
            }
          
	@Override
	protected boolean isFinished() {
	    return false;  
	}
	
	protected void end() {
        Robot.ballshooter.climbOff();
    }
	
	protected void Interrupted() {
        end();
    }
    
}

