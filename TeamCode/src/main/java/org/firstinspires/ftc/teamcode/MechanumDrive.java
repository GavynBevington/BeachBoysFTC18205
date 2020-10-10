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
            double turn = this.gamepad1.right_stick_x;
            double strafe = this.gamepad1.left_stick_x;


            Double[] proportionate = {Math.abs(FLI), Math.abs(FRI), Math.abs(RRI), Math.abs(RLI)};
            double scale = Collections.max(Arrays.asList(proportionate));

            hardware.FL.setPower(FLI / scale);
            hardware.FR.setPower(FRI / scale);
            hardware.RR.setPower(RRI / scale);
            hardware.RL.setPower(RLI / scale);

        }
    }
}
