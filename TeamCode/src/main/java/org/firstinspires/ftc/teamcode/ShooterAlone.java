//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//import org.firstinspires.ftc.teamcode.robotHardware;
//
//@TeleOp
//public class ShooterAlone extends LinearOpMode
//{
//
//    robotHardware hardware = new robotHardware();
//
//    @Override
//    public void runOpMode() {
//
//        waitForStart();
//        while (opModeIsActive())
//        {
//            double Shooter = this.gamepad1.right_trigger;
//
//            hardware.Launcher.setPower(Shooter);
//        }
//    }
//}
