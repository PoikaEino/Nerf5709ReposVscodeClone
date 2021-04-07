/*
package frc.robot.ballzooka_Commands;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;


public class colorWheelTest extends Command {
    String colorGoal;

    protected void initialize() {

    }
	
	protected void execute() {
    colorGoal = DriverStation.getInstance().getGameSpecificMessage();
    if (colorGoal.charAt(0) == 'B') {
        stopOnBlue();
    }
    
    if (colorGoal.charAt(0) == 'G') {
        stopOnGreen();
    }

    if (colorGoal.charAt(0) == 'R') {
        stopOnRed();
    }

    if (colorGoal.charAt(0) == 'Y') {
        stopOnYellow();
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

    void stopOnBlue(){

    }

    void stopOnGreen(){

    }

    void stopOnRed(){

    }

    void stopOnYellow(){
        
    }

}
*/
