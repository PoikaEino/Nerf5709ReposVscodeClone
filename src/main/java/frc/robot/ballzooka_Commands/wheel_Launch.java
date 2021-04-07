package frc.robot.ballzooka_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class wheel_Launch extends Command {
   	
    
    protected void initialize() {
    }
	
	
	protected void execute() {
        //Robot.ballshooter.keepCargo();
		//  while (Robot.m_oi.XBOX2.getBumper(Hand.kLeft) == true) {
        
            
            Robot.ballshooter.releaseTheCargo();
        }
       // }
        
      //  }
      //  }
      
        
    

	
		
	

	@Override
	protected boolean isFinished() {
    return false;
	}
	
	protected void end() {
        Robot.ballshooter.keepCargo();
    }
	
	protected void Interrupted() {
    end();
    }

}

