package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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
            if (this.gamepad1.a == true) {
                hardware.intakeMotor.setPower(1);
            }

        }

    }

}
