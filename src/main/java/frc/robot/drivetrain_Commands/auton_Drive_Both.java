/*package frc.robot.drivetrain_Commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class auton_Drive_Both extends Command {
    
     double goalDistanceX, goalDistanceY, startingDistanceX, differenceDistanceX, differenceDistanceY, fullDistanceGoalX, fullDistanceGoalY, SpeedY, SpeedX, timeAllowed;
     int directionX; int directionY;
	public void auton_Drive_Y(double timeAllowedA, double goalDistanceAX, int directionAX,
            double goalDistanceAY, int directionAY) {
    goalDistanceX = goalDistanceAX;
    directionX = directionAX;
    timeAllowed = timeAllowedA;   
    goalDistanceY = goalDistanceAY;
    directionY = directionAY;
    }
   	
    protected void initialize() {
       // double startingDistance = Robot.drivetrain.getdistance();
       // fullDistanceGoalX = startingDistance + goalDistanceX;
       // fullDistanceGoalY = startingDistance + goalDistanceY;
        setTimeout(timeAllowed);
    }
	
	protected void execute() {
     // double currentDistance = Robot.drivetrain.getdistance();
     //  differenceDistanceX =  fullDistanceGoalX - currentDistance * directionX;
     //  differenceDistanceY = fullDistanceGoalY- currentDistance * directionY;

       if ((differenceDistanceX < 1) && (differenceDistanceY < 0)){
           Robot.drivetrain.Stop();
       }
       if  (differenceDistanceY < 10){
           SpeedY = 0.3;
       }
       if (differenceDistanceY > 10){
           SpeedY = 0.6;
       }
       if  (differenceDistanceX < 10){
        SpeedX = 0.2;
       }
       if (differenceDistanceX > 10){
        SpeedX = 0.5;
    }
       if (directionY == -1){
           SpeedY = SpeedY * -1;
       }
       if (directionX == -1){
           SpeedX = SpeedX * -1;
        }
        Robot.drivetrain.auton_Drive(SpeedX, SpeedY, 0);
     protected boolean isFinished(){
      return false;
    }     
    
}
*/