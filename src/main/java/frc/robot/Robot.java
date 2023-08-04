package frc.robot;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Robot extends TimedRobot {

  CANSparkMax leftFront;
  CANSparkMax leftBack;
  CANSparkMax rightFront;
  CANSparkMax rightBack; 

  MotorControllerGroup leftGroup;
  MotorControllerGroup rightGroup;

  DifferentialDrive drive;

  Joystick thor;
  Joystick loki;


  @Override
  public void robotInit() {
    leftFront = new CANSparkMax(1, MotorType.kBrushed);
    leftBack = new CANSparkMax(2, MotorType.kBrushed);
    rightFront = new CANSparkMax(3, MotorType.kBrushed);
    rightBack = new CANSparkMax(4, MotorType.kBrushed);

    leftFront.restoreFactoryDefaults();
    leftFront.setInverted(false);
    leftFront.burnFlash();

    leftBack.restoreFactoryDefaults();
    leftBack.setInverted(false);
    leftBack.burnFlash();

    rightFront.restoreFactoryDefaults();
    rightFront.setInverted(true);
    rightFront.burnFlash();

    rightBack.restoreFactoryDefaults();
    rightBack.setInverted(true);
    rightBack.burnFlash();

    leftGroup = new MotorControllerGroup(leftFront, leftBack);
    rightGroup = new MotorControllerGroup(rightFront, rightBack);

    drive = new DifferentialDrive(leftGroup, rightGroup);

    thor = new Joystick(0);
    loki = new Joystick(1);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double leftSpeed = -thor.getY();
    double rightSpeed = -loki.getY();

    drive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
