package frc.robot.ballzooka_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class conveyor_Reverse extends Command {
    //boolean conveystate;
    
    protected void initialize() {
    }
	
	
	protected void execute() {
        
         if ((Robot.m_oi.XBOX2.getXButton()) == true) {
                Robot.ballshooter.conveyorReverse();
             }
             else {
               if ((Robot.m_oi.XBOX2.getYButton()) == false) {
               
                   Robot.ballshooter.coveyorOff();
               }
            }
        }
           
       
		
    

		
	

	@Override
	protected boolean isFinished() {
	return false;  
	}
	
	protected void end() {
    Robot.ballshooter.coveyorOff();
    }
	
	protected void Interrupted() {
    end();
    }

}

