
package frc.robot.commands.Drivetrain;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DT_Arcade extends CommandBase {
        private final DrivetrainSubsystem m_drivetrain;
        private DoubleSupplier m_x, m_y, m_speed;
        private BooleanSupplier m_trigger;
 

    public DT_Arcade(DrivetrainSubsystem drivetrain, DoubleSupplier x, DoubleSupplier y, DoubleSupplier speed, BooleanSupplier trigger) {
        m_drivetrain = drivetrain;
        m_x = x;
        m_y = y;
        m_speed = speed;
        m_trigger = trigger;
        addRequirements(drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (m_trigger.getAsBoolean()) {
            m_drivetrain.arcadeDrive(0, m_y.getAsDouble(), 0.5*(1+m_speed.getAsDouble()), false); 
        } else {
            m_drivetrain.arcadeDrive(m_x.getAsDouble()*0.7, m_y.getAsDouble(), 0.5*(1+m_speed.getAsDouble()), false);
        }
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