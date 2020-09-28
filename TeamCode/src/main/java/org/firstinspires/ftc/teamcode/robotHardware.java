package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class robotHardware {

    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;
    public Servo firstServo;
    public DcMotor intakeMotor;

    public void init(HardwareMap hardwareMap)
    {
        backLeftMotor =  hardwareMap.dcMotor.get("LBM");
        backRightMotor = hardwareMap.dcMotor.get("RBM");
        firstServo = hardwareMap.servo.get("servo");

        intakeMotor = hardwareMap.dcMotor.get("iM");

        intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
