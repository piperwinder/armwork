// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShoulderConstants;

public class shoulderSubsystem extends SubsystemBase {
  /** making variables */
    private CANSparkMax shoulderNEO;
    private SparkMaxPIDController shoulderController;
    private SparkMaxLimitSwitch shoulderSwitch;
    private RelativeEncoder shoulderEncoder; 

    /**
     * constructor
     */
    public shoulderSubsystem() {
        /* giving substance to names */
        shoulderNEO = new CANSparkMax(ShoulderConstants.shoulderSparkMaxID, MotorType.kBrushless);
        
        shoulderController = shoulderNEO.getPIDController(); 
        shoulderSwitch = shoulderNEO.getReverseLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyOpen);

        shoulderEncoder = shoulderNEO.getEncoder();
        shoulderEncoder.setPositionConversionFactor(100.0);

        shoulderController.setP(ShoulderConstants.shoulderArmP);
        shoulderController.setI(ShoulderConstants.shoulderArmI);
        shoulderController.setD(ShoulderConstants.shoulderArmD);

    shoulderNEO.setIdleMode(IdleMode.kBrake);

    shoulderNEO.burnFlash();
  }

  public void c_levelOne(){
    shoulderController.setReference(ShoulderConstants.c_levelOneReference, CANSparkMax.ControlType.kPosition);
    shoulderEncoder.setPosition(ShoulderConstants.c_levelOneTarget);
  }


  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */

   /*states */
  public boolean shoulderSwitchState() {
    return shoulderSwitch.isPressed();
  }
/*commands */
  public void stopShoulder(){
    shoulderNEO.set(ShoulderConstants.stopSpeed);
  }

  public void setHome() {
    shoulderEncoder.setPosition(0.0);
  }

  public void move(double speed) {
    shoulderNEO.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Shoulder LimSwitch", shoulderSwitchState());
    SmartDashboard.putNumber("Shoulder Position", shoulderEncoder.getPosition());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  
}
