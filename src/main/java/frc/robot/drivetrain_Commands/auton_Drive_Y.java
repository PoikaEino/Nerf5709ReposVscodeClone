package frc.robot.drivetrain_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class auton_Drive_Y extends Command {
     double goalDistance, startingDistance, differenceDistance, fullDistanceGoal, SpeedY, timeAllowed;
     int direction;
	public auton_Drive_Y (double timeAllowedA, double goalDistanceA, int directionA) {
    goalDistanceA = goalDistance;
    directionA = direction;
    timeAllowedA = timeAllowed;   
    }
   	
    
    protected void initialize() {
       //startingDistance = Robot.drivetrain.getdistance();
       fullDistanceGoal = startingDistance + goalDistance;
       setTimeout(timeAllowed);
    }
	
	protected void execute() {
       //double currentDistance = Robot.drivetrain.getdistance();
       //differenceDistance =  fullDistanceGoal - currentDistance * direction;

       if (differenceDistance < 1) {
           Robot.drivetrain.Stop();
       }

       if  (differenceDistance < 10) {
           SpeedY = 0.3;
       }

       if (differenceDistance > 10) {
           SpeedY = 0.6;
           
       }
       if (direction == 1) {
        Robot.drivetrain.auton_Drive(SpeedY, 0.0, 0.0);    
       }
       else if (direction == -1) {
       Robot.drivetrain.auton_Drive(-SpeedY, 0.0, 0.0);
       }
      
    }
    protected boolean isFinished(){
           return false;
    }
     
}




/*
protected void execute() {
    //double currentDistance = Robot.drivetrain.getdistance();
    differenceDistance = goalDistance - fullDistanceGoal * direction;

    if (differenceDistance < 1) {
        Robot.drivetrain.Stop();
    }

    if  (differenceDistance < 10) {
        SpeedY = 0.3;
    }

    if (differenceDistance > 10) {
        SpeedY = 0.6;
        
    }
    if (direction == 1) {
     Robot.drivetrain.auton_Drive(SpeedY, 0.0, 0.0);    
    }
    else if (direction == -1) {
    Robot.drivetrain.auton_Drive(-SpeedY, 0.0, 0.0);
    }
   
 }
 protected boolean isFinished(){
        return false;
 }
  
}
*/

