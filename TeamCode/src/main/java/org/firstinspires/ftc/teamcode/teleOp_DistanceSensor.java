package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous
public class teleOp_DistanceSensor extends LinearOpMode {

    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode() {

        hardware.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            int square = 0;
            double distance = hardware.distanceSensor.getDistance(DistanceUnit.MM);
            if (square == 0) {
                if (hardware.distanceSensor.getDistance(DistanceUnit.MM) <= 70) {
                    square = 3;
                    telemetry.addData("Square:", square);
                    telemetry.update();
                } else if (hardware.distanceSensor.getDistance(DistanceUnit.MM) <= 130 ) {
                    square = 2;
                    telemetry.addData("Square:", square);
                    telemetry.update();
                } else {
                    square = 1;
                    telemetry.addData("Square:", square);
                    telemetry.update();
                }

                if (this.gamepad1.a) {
                    telemetry.addData("distance", distance);
                    telemetry.update();
                }
            }
        }
    }
}
// 0 rings: 140mm - 150mm , 1 ring: 119mm - 125mm, 4 rings: 60mm - 65mm