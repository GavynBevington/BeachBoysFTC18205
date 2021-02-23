import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robotHardware;

@TeleOp
public class MainRobotCode extends LinearOpMode
{
    robotHardware hardware = new robotHardware();

    Servo servo;
    DcMotor wobbleMotor;
    double servoPosition = 0.0;

    @Override
    public void runOpMode()
    {

        servo = hardwareMap.servo.get("servo");
        wobbleMotor = hardwareMap.dcMotor.get("wobbleMotor");

        wobbleMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        hardware.init(hardwareMap);

        waitForStart();

        while (opModeIsActive())
        {
            double xValue = this.gamepad1.left_stick_x;
            double yValue = -this.gamepad1.left_stick_y;
            double turn = -this.gamepad1.right_stick_x;
            double intakePower = this.gamepad2.left_trigger;
            double intakePower2 = this.gamepad2.right_trigger;

            double r = Math.sqrt(xValue*xValue + yValue*yValue);
            double theta = Math.atan2(yValue, xValue) - Math.PI/4;

            double sinPower = r*Math.sin(theta);
            double cosPower = r*Math.cos(theta);

            hardware.FrontRightMotor.setPower(cosPower + turn);
            hardware.FrontLeftMotor.setPower(cosPower - turn);
            hardware.RearLeftMotor.setPower(sinPower - turn);
            hardware.RearRightMotor.setPower(sinPower + turn);

            if (this.gamepad2.left_bumper) {
                hardware.intakeMotor.setPower(-1);
                hardware.intakeMotor2.setPower(-1);
            }

            hardware.intakeMotor2.setPower(intakePower*1.5);
            hardware.intakeMotor.setPower(intakePower2*1.5);

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

            telemetry.addData("sin", sinPower);
            telemetry.addData("cos", cosPower);
            telemetry.addData("intake", intakePower);
            telemetry.update();

        }

    }

}