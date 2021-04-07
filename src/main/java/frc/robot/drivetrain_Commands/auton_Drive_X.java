package frc.robot.drivetrain_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class auton_Drive_X extends Command {
     double goalDistance, startingDistance, differenceDistance, fullDistanceGoal, SpeedX, timeAllowed;
     int direction;
    public auton_Drive_X(double timeAllowedB, double goalDistanceB, int directionB) {
    goalDistanceB = goalDistance;
    directionB = direction;
    timeAllowedB = timeAllowed;
    setTimeout(timeAllowed); 
    }
   	
    
    protected void initialize() {
       //startingDistance = Robot.drivetrain.getdistance();
       fullDistanceGoal = startingDistance + goalDistance;
      
    }
	
	
	protected void execute() {
       //double currentDistance = Robot.drivetrain.getdistance();
      // differenceDistance = fullDistanceGoal - currentDistance * direction;

       if (differenceDistance < 1) {
           Robot.drivetrain.Stop();
       }

       if  (differenceDistance < 10) {
           SpeedX = 0.3;
       }

       if (differenceDistance > 10) {
           SpeedX = 0.6;
           
       }

       if (direction == 1) {
       Robot.drivetrain.auton_Drive(0.0, SpeedX, 0);   
       }
       else if (direction == -1)
        Robot.drivetrain.auton_Drive(0.0, -SpeedX, 0);    
       }

       protected boolean isFinished(){
           return false;
       }
}


