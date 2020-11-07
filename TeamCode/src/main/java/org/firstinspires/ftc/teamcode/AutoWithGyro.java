package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class AutoWithGyro extends LinearOpMode {

    GyroSensor sensorGyro;

    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode() throws InterruptedException {

        double turnSpeed = 0.15;

        sensorGyro = hardwareMap.gyroSensor.get("gyro");
        int Accumulated;
        int target = 0;

        sleep(1000);
        sensorGyro.calibrate();

        waitForStart();

        while (sensorGyro.isCalibrating()) {
        }

        while (opModeIsActive()) {

            Accumulated = sensorGyro.getHeading();

            while ((Accumulated - target) > 3){
                if (Accumulated > 0) {
                    hardware.FR.setPower(+turnSpeed);
                    hardware.FL.setPower(-turnSpeed);
                    hardware.RL.setPower(-turnSpeed);
                    hardware.RR.setPower(+turnSpeed);
                }

                if (Accumulated < 0) {
                    hardware.FR.setPower(-turnSpeed);
                    hardware.FL.setPower(+turnSpeed);
                    hardware.RL.setPower(+turnSpeed);
                    hardware.RR.setPower(-turnSpeed);
            }
                Accumulated = sensorGyro.getHeading();
                telemetry.addData("heading:", Accumulated);
        }
            hardware.FR.setPower(0);
            hardware.FL.setPower(0);
            hardware.RL.setPower(0);
            hardware.RR.setPower(0);
    }

}
