package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;


@Autonomous(name = "Auto_ParkOnLine", group = "Autonomous")

public class Auto_ParkOnLine
{

    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode()
    {

        hardware.init(hardwareMap);

        hardware.hdLBM.setMode(DcMotor.RunMode,RUN_ENCODER_USING_ENCODER);

        double mVelocity = 288;

        waitForStart();

        while(opModeIsActive())
        {

            hardware.backLeftMotor.setVelocity(mVelocity);
            hardware.backRightMotor.setVelocity(mVelocity);

            wait(100);


            hardware.backLeftMotor.setVelocity(0);
            hardware.backRightMotor.setVelocity(0);
            hardware.backLeftMotor.setPower(0);
            hardware.backRightMotor.setPower(0);

        }

    }

}
