package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DistanceSensor;


public class robotHardware {

    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;
    public Servo firstServo;
    public DcMotor intakeMotor;
    public DcMotor FL;
    public DcMotor FR;
    public DcMotor RR;
    public DcMotor RL;
    public DistanceSensor distanceSensor;

    public void init(HardwareMap hardwareMap)
    {
        backLeftMotor =  hardwareMap.dcMotor.get("LBM");
        backRightMotor = hardwareMap.dcMotor.get("RBM");
        firstServo = hardwareMap.servo.get("servo");
        distanceSensor = hardwareMap.get(DistanceSensor.class, "distanceSensor");
        FL = hardwareMap.dcMotor.get("FrontLeft");
        FR = hardwareMap.dcMotor.get("FrontRight");
        RR = hardwareMap.dcMotor.get("RearRight");
        RL = hardwareMap.dcMotor.get("RearLeft");

        intakeMotor = hardwareMap.dcMotor.get("iM");

        intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        RL.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
