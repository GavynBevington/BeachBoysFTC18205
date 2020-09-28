package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.robotHardware;

@Autonomous
public class auto_WithoutEncoders extends LinearOpMode
{

    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode() {

        hardware.init(hardwareMap);

        int pwr = 1;

        waitForStart();

        while(opModeIsActive())  {

            hardware.backLeftMotor.setPower(pwr);
            hardware.backRightMotor.setPower(pwr);

            sleep(1000);
            pwr = 0;

        }

    }

}
