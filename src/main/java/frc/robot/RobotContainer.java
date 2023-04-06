package frc.robot;

import frc.robot.commands.Drivetrain.DT_Arcade;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();


  // Declare all the subsystems
  public final DrivetrainSubsystem m_drivetrain = new DrivetrainSubsystem();

// Joysticks
//private final controller controller1 = new controller(1);
private final XboxController controller = new XboxController(0);

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  RobotContainer() {
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    // SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

    CameraServer.startAutomaticCapture();
    configureButtonBindings();

  
    // m_chooser.setDefaultOption("Drive forwards", new DT_AutoArcadeDrive(m_drivetrain, 0, 1, 0.2, 1));
    
    // m_drivetrain.setDefaultCommand(new DT_Arcade(m_drivetrain, () -> controller.getX(), () -> controller.getY(), () -> controller.getThrottle(), () -> controller.getTrigger()));
  
  
    // SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }


public void init() {}
private void configureButtonBindings() {


  final JoystickButton button_A = new JoystickButton(controller, 1);
  final JoystickButton button_B = new JoystickButton(controller, 2);
  final JoystickButton button_X = new JoystickButton(controller, 3);
  final JoystickButton button_Y = new JoystickButton(controller, 4);

  final JoystickButton button_LB = new JoystickButton(controller, 5);
  final JoystickButton button_RB = new JoystickButton(controller, 6);

  final JoystickButton back = new JoystickButton(controller, 7);
  final JoystickButton start = new JoystickButton(controller, 8);
  //final JoystickButton left_joystick_button = new JoystickButton(controller, 9);
  //final JoystickButton right_joystick_button = new JoystickButton(controller, 10);
  final JoystickAnalogButton button_LT = new JoystickAnalogButton(controller, 2);
  final JoystickAnalogButton button_RT = new JoystickAnalogButton(controller, 3);

  //final POVButton xbox_dpad_Up = new POVButton(controller, 180);
  //final POVButton xbox_dpad_Down = new POVButton(controller, 0);
  final POVButton xbox_dpad_Left = new POVButton(controller, 90);
  final POVButton xbox_dpad_Right = new POVButton(controller, 270);

}

//  button_RT.onTrue(new Intake_Close(m_intake));
      
  //joystickButton10.onTrue(new DT_SetSpin(m_drivetrain, 0.7));
  //joystickButton12.onTrue(new DT_SetSpin(m_drivetrain, 1));


  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }
  

}
