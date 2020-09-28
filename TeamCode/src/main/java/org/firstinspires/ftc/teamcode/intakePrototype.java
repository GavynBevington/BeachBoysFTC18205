package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robotHardware;

@TeleOp
public class intakePrototype extends LinearOpMode
{
    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode()
    {

        hardware.init(hardwareMap);

        waitForStart();

        while (opModeIsActive())
        {
            double runIntake = -this.gamepad1.left_stick_y;

            hardware.intakeMotor.setPower(runIntake *2);

        }

    }
}
