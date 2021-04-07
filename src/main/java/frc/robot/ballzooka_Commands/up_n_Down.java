package frc.robot.ballzooka_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.ballshooter_Subsystem;

public class up_n_Down extends Command {
    
    
    protected void initialize() {
    }
	
	
	protected void execute() {
    
          if (Robot.m_oi.XBOX2.getAButton()) { 
              if (Robot.m_oi.returnIntakeState() == true) {
                  Robot.ballshooter.down();
              }
              else {
                  Robot.ballshooter.up();
              }
          }
    }
    
          
        
            
       
		
    

		
	

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
    
    
    }
	
	protected void Interrupted() {
    end();
    }

}

