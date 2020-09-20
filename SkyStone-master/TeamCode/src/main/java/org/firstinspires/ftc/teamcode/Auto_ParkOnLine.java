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

        waitForStart();

        while(opModeIsActive())
        {

            hardware.backLeftMotor.setPower(1);
            hardware.backRightMotor.setPower(1);

            wait(100);

            hardware.backLeftMotor.setPower(0);
            hardware.backRightMotor.setPower(0);

        }

    }

}
