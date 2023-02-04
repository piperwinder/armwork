package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.extensionConstants;

public class extensionSubsystem extends SubsystemBase {
    private CANSparkMax extensionNEO;
    private SparkMaxPIDController extensionController;
    private SparkMaxLimitSwitch extensionSwitch;
    private RelativeEncoder extensionEncoder; 

    public extensionSubsystem() {
        /* giving substance to names */
        extensionNEO = new CANSparkMax(extensionConstants.extensionSparkMaxID, MotorType.kBrushless);
        
        extensionController = extensionNEO.getPIDController(); 
        extensionSwitch = extensionNEO.getReverseLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyOpen);

        extensionEncoder = extensionNEO.getEncoder();
        extensionEncoder.setPositionConversionFactor(100.0);

        extensionController.setP(extensionConstants.extensionArmP);
        extensionController.setI(extensionConstants.extensionArmI);
        extensionController.setD(extensionConstants.extensionArmD);

    extensionNEO.setIdleMode(IdleMode.kBrake);

    extensionNEO.burnFlash();
  }

  public boolean extensionSwitchState() {
    return extensionSwitch.isPressed();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Extension LimSwitch", extensionSwitchState());
    SmartDashboard.putNumber("Extension Position", extensionEncoder.getPosition());
  }

}
