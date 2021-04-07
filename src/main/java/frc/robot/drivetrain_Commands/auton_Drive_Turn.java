
package frc.robot.drivetrain_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class auton_Drive_Turn extends Command {
     double angleDifference, currentAngle, fullAngleGoal, SpeedY, angleGoal, turnSpeed, timeAllowed;
     Boolean direction;
    public auton_Drive_Turn(int i, double d, boolean b) {
	}

	public void basic_Auton_Command(double timeAllowedC, double angleGoalA, boolean directionC) {
        angleGoalA = angleGoal;
        directionC = direction;
        timeAllowedC = timeAllowed;
        setTimeout(timeAllowed);
    }
   	
    protected void initialize() {
     //  currentAngle = Robot.drivetrain.getGyro()%360;
       fullAngleGoal = currentAngle + angleGoal;
       //Robot.drivetrain.reset();
       //Robot.drivetrain.resetEncoders();
    }
	
	
	protected void execute() {
    //currentAngle = Robot.drivetrain.getGyro()%360;
    if (direction == true) {
        angleDifference = fullAngleGoal - currentAngle;
    }
    if (direction == false) {
        angleDifference = fullAngleGoal - currentAngle * -1;
    }


    if (angleDifference < 1) {
        Robot.drivetrain.Stop();
    }

    if (angleDifference < 10) {
        turnSpeed = 0.7;
    }

    if (angleDifference > 10) {
        turnSpeed = 0.9;
    }
    
    if (direction == true) {
        Robot.drivetrain.auton_Drive(0, 0, turnSpeed);
    }
     
    if (direction == false) {
        Robot.drivetrain.auton_Drive(0, 0, -turnSpeed);
    }
    }

    protected boolean isFinished(){
        return false;
    }
     
}
