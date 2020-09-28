package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robotHardware;

@TeleOp

public class servoTele extends LinearOpMode {

    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode() {

        hardware.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            if (this.gamepad1.a == true) {
                hardware.firstServo.setPosition(30);
            } else {
                hardware.firstServo.setPosition(0);
            }
        }
    }
}
