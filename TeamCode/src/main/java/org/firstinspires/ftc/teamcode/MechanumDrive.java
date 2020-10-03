package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.Arrays;
import java.util.Collections;

@TeleOp
public class MechanumDrive extends LinearOpMode {

    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode() {

        hardware.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            double driveY = -this.gamepad1.left_stick_y;
            double Turn = this.gamepad1.right_stick_x;
            double strafe = this.gamepad1.left_stick_x;
            Double[] proportionate = {Math.abs(driveY + Turn + strafe), Math.abs(driveY - Turn - strafe), Math.abs(driveY + Turn - strafe), Math.abs(driveY - Turn + strafe)};
            double scale = Collections.max(Arrays.asList(proportionate));

            hardware.FL.setPower(driveY + Turn + strafe / scale);
            hardware.FR.setPower(driveY - Turn - strafe / scale);
            hardware.RR.setPower(driveY + Turn - strafe / scale);
            hardware.RL.setPower(driveY - Turn + strafe / scale);

        }
    }
}
