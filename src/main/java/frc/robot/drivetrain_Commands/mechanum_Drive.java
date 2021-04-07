package frc.robot.drivetrain_Commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.OI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class mechanum_Drive extends Command {
    public mechanum_Drive() {
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize(){
      
    }

    @Override
    protected void execute(){
        //change multiplication if needed
        double ymovement = (Robot.m_oi.XBOX.getX(Hand.kLeft) * 1.3);
        double xmovement = (Robot.m_oi.XBOX.getY(Hand.kLeft) * -1);
        double rotatemovement = (Robot.m_oi.XBOX.getX(Hand.kRight) * 0.5);
   
        //The ymovement and xmovement are seemingly attached to their wrong "get" commands
        //This is because, the imported OI commands falsely picks up the XBOX Controller's X axis as the Y axis, and vice versa
        Robot.drivetrain.TeleopDrive(ymovement, xmovement, rotatemovement);
    }
    
    protected boolean isFinished(){
        return false;
    }

    @Override
    //in end, put what you what to happen when it ends, for example "Robot.subsystem.Stop();"
    protected void end () {
    Robot.drivetrain.Stop();
    }

    protected void interrupted(){

    }
}