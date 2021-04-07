package frc.robot.ballzooka_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class reverseClimb extends Command {
    //boolean conveystate;
    
    protected void initialize() {
    }
	
	protected void execute() {
        Robot.ballshooter.climbOff();
         while ((Robot.m_oi.XBOX.getBButton()) == true) {
                Robot.ballshooter.reverseClimb();
         }
     }
          
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

