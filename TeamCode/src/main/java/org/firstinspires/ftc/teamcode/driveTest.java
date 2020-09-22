package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;



@TeleOp

public class driveTest extends LinearOpMode
{
//    //initials for Left Back Motor and Right Back Motor
//    private DcMotor LBM;
//    private DcMotor RBM;
//

    robotHardware hardware= new robotHardware();

    @Override
    public void runOpMode()
    {

        hardware.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive())
        {
            //this whole loop sets up and allows us to do car drive this is from 7203 Kno3 Robotics
            float drive = -this.gamepad1.left_stick_y;
            float turn = this.gamepad1.right_stick_x;

            float leftSPD = ((1 - Math.abs(turn)) * drive + (1 - Math.abs(drive)) * turn + turn + drive) / 2;
            float rightSPD = ((1 - Math.abs(turn)) * drive - (1 - Math.abs(drive)) * turn - turn + drive) /2;

            hardware.backLeftMotor.setPower(leftSPD);
            hardware.backRightMotor.setPower(rightSPD);

        }
    }
}
