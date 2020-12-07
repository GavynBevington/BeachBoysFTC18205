package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DistanceSensor;


public class robotHardware {

//    public Servo wobbleServo;
//    public DcMotor wobbleMotor;
    public DcMotor intakeMotor;
    public DcMotor intakeMotor2;
    public DcMotor FrontLeftMotor;
    public DcMotor FrontRightMotor;
    public DcMotor RearRightMotor;
    public DcMotor RearLeftMotor;
//    public DistanceSensor distanceSensor;

    public void init(HardwareMap hardwareMap)
    {

//        wobbleServo = hardwareMap.servo.get("servo");
//        distanceSensor = hardwareMap.get(DistanceSensor.class, "distanceSensor");
        intakeMotor2 = hardwareMap.dcMotor.get("intake2");
        FrontLeftMotor = hardwareMap.dcMotor.get("FrontLeft");
        FrontRightMotor = hardwareMap.dcMotor.get("FrontRight");
        RearRightMotor = hardwareMap.dcMotor.get("RearRight");
        RearLeftMotor = hardwareMap.dcMotor.get("RearLeft");
        intakeMotor = hardwareMap.dcMotor.get("iM");



        intakeMotor2.setDirection(DcMotorSimple.Direction.REVERSE);
        intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RearRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
