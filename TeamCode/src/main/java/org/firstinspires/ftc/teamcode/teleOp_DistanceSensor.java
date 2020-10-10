package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class teleOp_DistanceSensor extends LinearOpMode {

    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode() {

        hardware.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            double distanceValue = hardware.distanceSensor.getDistance(DistanceUnit.INCH);

            telemetry.addData("dist.: ", distanceValue);

            if (distanceValue >= 1 && distanceValue <= 2.5) {

                telemetry.addData("value: ", "1");

            }
        }
    }
}
