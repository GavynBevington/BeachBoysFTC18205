package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DistanceSensor;


public class robotHardware {

    public Servo firstServo;
    public DcMotor intakeMotor;
    public DcMotor Launcher;
    public DcMotor FL;
    public DcMotor FR;
    public DcMotor RR;
    public DcMotor RL;
    public DistanceSensor distanceSensor;
//    public DigitalChannel touch;
//    public DigitalChannel touchTop;

    public void init(HardwareMap hardwareMap)
    {

        firstServo = hardwareMap.servo.get("servo");
        distanceSensor = hardwareMap.get(DistanceSensor.class, "distanceSensor");
//        touch = hardwareMap.get(DigitalChannel.class, "Touch Sensor");
//        touchTop = hardwareMap.get(DigitalChannel.class, "TouchTop");
        Launcher = hardwareMap.dcMotor.get("Shooter");
        FL = hardwareMap.dcMotor.get("FrontLeft");
        FR = hardwareMap.dcMotor.get("FrontRight");
        RR = hardwareMap.dcMotor.get("RearRight");
        RL = hardwareMap.dcMotor.get("RearLeft");


        intakeMotor = hardwareMap.dcMotor.get("iM");

        intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        RL.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
