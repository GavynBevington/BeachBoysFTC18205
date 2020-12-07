//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;
//import org.firstinspires.ftc.teamcode.robotHardware;
//
//@TeleOp
//public class wobblePrototype extends LinearOpMode
//{
//    robotHardware hardware = new robotHardware();
//    Servo servo;
//    public DcMotor wobbleMotor;
//    double servoPos = 0;
//
//    @Override
//            public void runOpMode() throws InterruptedException {
//
//        servo = hardwareMap.servo.get("servo");
//        wobbleMotor = hardwareMap.dcMotor.get("wobbleMotor");
//        servo.setPosition(0);
//
//        waitForStart();
//
//        servo.setPosition(1);
//
//            if (this.gamepad1.b) {
//                wobbleMotor.setPower(-0.5);
//            } else {
//                wobbleMotor.setPower(0);
//        }
//    }
//}