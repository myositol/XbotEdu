package competition.subsystems.drive.commands;

import javax.inject.Inject;

import xbot.common.command.BaseCommand;
import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.pose.PoseSubsystem;

public class DriveToPositionCommand extends BaseCommand {

    //pose.getposition in pose subsystem and also fill in settargetposition() method
    DriveSubsystem drive;
    PoseSubsystem pose;
    double targetPosition;

    @Inject
    public DriveToPositionCommand(DriveSubsystem driveSubsystem, PoseSubsystem pose) {
        this.drive = driveSubsystem;
        this.pose = pose;
    }

    public void setTargetPosition(double position) {
        targetPosition = position;
        // This method will be called by the test, and will give you a goal distance.
        // You'll need to remember this target position and use it in your calculations.
    }

    @Override
    public void initialize() {
        // If you have some one-time setup, do it here.
    }

    @Override
    public void execute() {
        if (targetPosition-pose.getPosition()<1) {
            drive.tankDrive(0, 0);
        }
        else if (targetPosition-pose.getPosition()<3) {
            drive.tankDrive(0.1, 0.1);
        }
        else if (targetPosition-pose.getPosition()<4) {
            drive.tankDrive(.8, .8);
        }
        else {
            drive.tankDrive(.75, .75);
        }
        // Here you'll need to figure out a technique that:
        // - Gets the robot to move to the target position
        // - Hint: use pose.getPosition() to find out where you are
        // - Gets the robot stop (or at least be moving really really slowly) at the
        // target position

        // How you do this is up to you. If you get stuck, ask a mentor or student for
        // some hints!
    }

    @Override
    public boolean isFinished() {
        if (targetPosition-pose.getPosition()<.2){
            return true;
        }
        // Modify this to return true once you have met your goal,
        // and you're moving fairly slowly (ideally stopped)
        else{
            return false;
        }
    }
}
