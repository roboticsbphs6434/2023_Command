
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

    CANSparkMax armMotor;
    boolean extend = false;
    double armSpeed = 0;
    
    public Arm() {

        armMotor = new CANSparkMax(60, MotorType.kBrushed);
    }
    
    @Override
    public void periodic() {
        armMotor.set(armSpeed);

       

        SmartDashboard.putNumber("Arm Speed", armMotor.get());
    }
    public void setSpeed(double speed)
    {
        armSpeed = speed; 
    }
    // public void extend()
    // {
    //     extend = true;
    // }
    // public void retract()
    // {
    //     extend = false;
    // }
   
    public void Ground()
    {
        armSpeed = 0.1;
    }
    public void Home()
    {
        armSpeed = -0.1;
    }
    public void Stop()
    {
        armSpeed = 0;
    }

}