package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robotHardware;


@Autonomous
public class AutoTest extends LinearOpMode {

    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode() throws InterruptedException {

        hardware.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {

            hardware.FR.setPower(0.33);
            hardware.FL.setPower(0.33);
            hardware.RR.setPower(0.33);
            hardware.RL.setPower(0.33);
            wait(5000);
        }
    }

}
