package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
public class tele extends LinearOpMode
{

    Servo servo;
    DcMotor wobbleMotor;
    double servoPosition = 0.0;

    @Override
    public void runOpMode() {

        servo = hardwareMap.servo.get("servo");
        wobbleMotor = hardwareMap.dcMotor.get("wobbleMotor");

        wobbleMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

    while (opModeIsActive()) {

            if (this.gamepad1.a) {
                servoPosition = 0.7;
                servo.setPosition(servoPosition);
                telemetry.addData("Servo Position:", servo.getPosition());
                telemetry.update();
            } else if (this.gamepad1.b) {
                servoPosition = 0.0;
                servo.setPosition(servoPosition);
                telemetry.addData("Servo Position:", servo.getPosition());
                telemetry.update();
            }

            if (this.gamepad1.dpad_up) {
                wobbleMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                wobbleMotor.setPower(0.3);
            } else if (this.gamepad1.dpad_down) {
                wobbleMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                wobbleMotor.setPower(0.6);
            } else {
                wobbleMotor.setPower(0);
            }
        }
//      servo.setPosition(servoPosition);
//        sleep(2000);
//
//        servoPosition = 0.0;
//        servo.setPosition(servoPosition);

    }
}
