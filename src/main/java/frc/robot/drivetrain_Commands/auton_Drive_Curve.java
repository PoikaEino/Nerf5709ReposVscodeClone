
package frc.robot.drivetrain_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class auton_Drive_Curve extends Command {
     double increment, exponential;
     Boolean direction;
     double turnValue;
    public void basic_Auton_Command(double incrementA, double exponentialA, Boolean directionA) {
        increment = incrementA;
        direction = directionA;
        exponential = exponentialA;
        //setTimeout();
    }
   	
    protected void initialize() {
    
    }
	
	
	protected void execute() {
        //addSequential
        //Auton_Drive_Turn(turnValue);

        
    }

    protected boolean isFinished() {
    return false;
    }
    
}

