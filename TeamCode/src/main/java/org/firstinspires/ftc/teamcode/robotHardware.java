package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class robotHardware {

    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;

    public void init(HardwareMap hardwareMap)
    {
        backLeftMotor =  hardwareMap.dcMotor.get("LBM");
        backRightMotor = hardwareMap.dcMotor.get("RBM");

        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
