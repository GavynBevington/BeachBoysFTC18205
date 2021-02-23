package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

public class motorTest extends LinearOpMode
{
    private Gyroscope imu;
    private DcMotor LBM;
    private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest;


    @Override
    public void runOpMode()
    {
        imu = hardwareMap.get(Gyroscope.class, "imu");
        LBM = hardwareMap.get(DcMotor.class, "motorTest");
        digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start
        waitForStart();

        float tgtPower = 0;
        //run until end of the match
        while(opModeIsActive())
        {
            tgtPower = -this.gamepad1.left_stick_y;
            LBM.setPower(tgtPower);

            telemetry.addData("TargetPower", tgtPower);
            telemetry.addData("Motor Power", LBM.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }

    }

}
