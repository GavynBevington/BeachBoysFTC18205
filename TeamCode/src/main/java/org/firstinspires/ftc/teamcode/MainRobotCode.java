import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robotHardware;

@TeleOp
public class MainRobotCode extends LinearOpMode
{
    robotHardware hardware = new robotHardware();

    @Override
    public void runOpMode()
    {

        hardware.init(hardwareMap);

        waitForStart();

        while (opModeIsActive())
        {
            double xValue = this.gamepad1.left_stick_x;
            double yValue = -this.gamepad1.left_stick_y;
            double turn = this.gamepad1.right_stick_x;
            double intakePower = this.gamepad1.right_trigger;

            double r = Math.sqrt(xValue*xValue + yValue*yValue);
            double theta = Math.atan2(yValue, xValue) - Math.PI/4;

            double sinPower = r*Math.sin(theta);
            double cosPower = r*Math.cos(theta);

            hardware.FR.setPower(sinPower - turn);
            hardware.FL.setPower(cosPower + turn);
            hardware.RL.setPower(sinPower + turn);
            hardware.RR.setPower(cosPower - turn);

            hardware.intakeMotor.setPower(intakePower);

            telemetry.addData("sin", sinPower);
            telemetry.addData("cos", cosPower);
            telemetry.update();

        }

    }

}