// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
  public static final class ShoulderConstants {
    public static final int shoulderSparkMaxID = 2;
    public static final double shoulderArmP = 0.0;
    public static final double shoulderArmD = 0.0;
    public static final double shoulderArmI = 0.0;
    public static final double stopSpeed = 0.0;
    public static final double c_levelOneReference = 0.0;
    public static final double c_levelOneTarget = 3.0;
    public static int shoulderStickPort;
  }

  public static final class extensionConstants {
    public static final int extensionSparkMaxID = 3;
    public static final double extensionArmP = 0.0;
    public static final double extensionArmD = 0.0;
    public static final double extensionArmI = 0.0;
  }

  public static class ControllerConstants {
    public static final int shoulderStickPort = 1;
  }

















}
