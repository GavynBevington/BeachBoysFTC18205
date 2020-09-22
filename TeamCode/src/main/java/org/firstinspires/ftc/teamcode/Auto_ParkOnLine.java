package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotHardware;


@Autonomous
public class Auto_ParkOnLine extends LinearOpMode
{

    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode()
    {
        hardware.init(hardwareMap);

        hardware.backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hardware.backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int mVelocity = 288;

        waitForStart();

        while(opModeIsActive())
        {

            hardware.backLeftMotor.setTargetPosition(mVelocity);
            hardware.backRightMotor.setTargetPosition(mVelocity);

            mVelocity = 0;

//            hardware.backLeftMotor.setTargetPosition(mVelocity);
//            hardware.backRightMotor.setTargetPosition(mVelocity);
            hardware.backLeftMotor.setPower(0);
            hardware.backRightMotor.setPower(0);

        }

    }

}
