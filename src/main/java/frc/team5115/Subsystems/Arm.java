package frc.team5115.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team5115.Robot.RobotContainer;
import edu.wpi.first.wpilibj.DigitalInput; 

import static frc.team5115.Constants.*;

public class Arm {
    TalonSRX Talon1;
    double DCMOTORSPEED;
    public DigitalInput ArmStopper1;
    DigitalInput ArmStopper2;

    public Arm(){
        DCMOTORSPEED = 0.5;
        ArmStopper1 = new DigitalInput(0);
        ArmStopper2 = new DigitalInput(1);
        Talon1 = new TalonSRX(5);
    }

    public void Stop(){
        Talon1.set(ControlMode.PercentOutput, 0);
    }

    public void Open(){
        if(ArmStopper1.get() == true){
            Stop();
        } else{
            Talon1.set(ControlMode.PercentOutput, DCMOTORSPEED);
        }
        System.out.println("I DID IT");
    }
    
    public void Close(){
        Talon1.set(ControlMode.PercentOutput, -DCMOTORSPEED);
        if(ArmStopper2.get() == true){
            Stop();
        }
        System.out.println("I DID IT");
    }
}
