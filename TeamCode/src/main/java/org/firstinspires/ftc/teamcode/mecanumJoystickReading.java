package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.lang.Math;

@TeleOp (name = "mecanumTest", group = "mecanum")
public class mecanumJoystickReading extends LinearOpMode {

    robotHardware hardware = new robotHardware();

@Override
    public void runOpMode() {

        hardware.init(hardwareMap);

        telemetry.addData("Status: ", "Intitialized");

        waitForStart();

        while(opModeIsActive()) {
            double xValue = this.gamepad1.left_stick_x;
            double yValue = -this.gamepad1.left_stick_y;
            double turn = this.gamepad1.right_stick_x;
            double intake = this.gamepad1.right_trigger;

            double r = Math.sqrt(xValue*xValue + yValue*yValue);
            double theta = Math.atan2(yValue, xValue) - Math.PI/4;

            double sinPower = r*Math.sin(theta);
            double cosPower = r*Math.cos(theta);

            hardware.FrontRightMotor.setPower(sinPower - turn);
            hardware.FrontLeftMotor.setPower(cosPower + turn);
            hardware.RearLeftMotor.setPower(sinPower + turn);
            hardware.RearRightMotor.setPower(cosPower - turn);

            hardware.intakeMotor.setPower(intake);

            telemetry.addData("Power:", intake);
            telemetry.addData("sin:", sinPower);
            telemetry.addData("cos:", cosPower);
            telemetry.update();
        }
    }
}
