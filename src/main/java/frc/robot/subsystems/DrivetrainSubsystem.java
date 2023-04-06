// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystem extends SubsystemBase {

  private PWMVictorSPX leftFrontMotor, leftBackMotor;
  private PWMVictorSPX rightFrontMotor, rightBackMotor;
  private MotorControllerGroup driveLeft, driveRight;
  private double spin = 1;

  public DrivetrainSubsystem() {
    leftFrontMotor = new PWMVictorSPX(9);
    leftBackMotor = new PWMVictorSPX(8);
    driveLeft = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
    driveLeft.setInverted(false);

    rightFrontMotor = new PWMVictorSPX(0);
    rightBackMotor = new PWMVictorSPX(1);
    driveRight = new MotorControllerGroup(rightFrontMotor, rightBackMotor);
    driveRight.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double x, double y, double speed, boolean inverted) {
    x = x*spin;
    double left = (-y + x)*speed;
    double right = (y + x)*speed;
  
    left = Math.min(left, 1);
    right = Math.min(right, 1);

    left = Math.max(left, -1);
    right = Math.max(right, -1);

    if (inverted) {
        set(left, right);
    }
    else {
        set(left, right);
    }
    SmartDashboard.putNumber("Left", left);
    SmartDashboard.putNumber("Right", right);
  }

  public void setSpin(double speed) {
        spin = speed;
  }

  public void set(double left, double right) {
    driveLeft.set(left);
    driveRight.set(right);
  }
}
