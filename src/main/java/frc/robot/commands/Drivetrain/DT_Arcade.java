
package frc.robot.commands.Drivetrain;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DT_Arcade extends CommandBase {
        private final DrivetrainSubsystem m_drivetrain;
        private DoubleSupplier m_x, m_y, m_speed;
        private BooleanSupplier m_trigger;
 

    public DT_Arcade(DrivetrainSubsystem drivetrain, DoubleSupplier x, DoubleSupplier y) {
        m_drivetrain = drivetrain;
        m_x = x;
        m_y = y;
        addRequirements(drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
            m_drivetrain.arcadeDrive(m_y.getAsDouble(), m_y.getAsDouble(), 0.5, false); 
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}