//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
//
//
//@Autonomous
//
//public class MainAutoFirst extends LinearOpMode {
//
////    GyroSensor sensorGyro;
//
//    /* Declare OpMode members. */
//    robotHardware  hardware   = new robotHardware();   // Use a Pushbot's hardware
//    private ElapsedTime     runtime = new ElapsedTime();
//
//    static final double     COUNTS_PER_MOTOR_REV    = 28 ;    // eg: TETRIX Motor Encoder
//    static final double     DRIVE_GEAR_REDUCTION    = 20.0;     // This is < 1.0 if geared UP
//    static final double     WHEEL_DIAMETER_INCHES   = 2.95276 ;     // For figuring circumference
//    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);
//    static final double     DRIVE_SPEED             = 0.45;
//    static final double     REVERSE_SPEED           = 0.3;
//    static final double     TURN_SPEED              = 0.4;
//
//    @Override
//    public void runOpMode() {
//
//        sleep(1000);
//        /*
//         * Initialize the drive system variables.
//         * The init() method of the hardware class does all the work here
//         */
//        hardware.init(hardwareMap);
//
//        // Send telemetry message to signify robot waiting;
//        telemetry.addData("Status", "Resetting Encoders");    //
//        telemetry.update();
//
//        hardware.FrontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        hardware.FrontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        hardware.RearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        hardware.RearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//
//        hardware.FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        hardware.FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        hardware.RearLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        hardware.RearRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//        // Send telemetry message to indicate successful Encoder reset
//        telemetry.addData("Path0",  "Starting at %7d :%7d",
//                hardware.RearRightMotor.getCurrentPosition(),
//                hardware.RearLeftMotor.getCurrentPosition(),
//                hardware.FrontLeftMotor.getCurrentPosition(),
//                hardware.FrontRightMotor.getCurrentPosition());
//        telemetry.update();
//// -3320:
////
//        // Wait for the game to start (driver presses PLAY)
//        waitForStart();
//
//        // Step through each leg of the path,
//        // Note: Reverse movement is obtained by setting a negative distance (not speed)
////        encoderDrive(DRIVE_SPEED, 55, 55, 3);
//          encoderDrive(DRIVE_SPEED, -55, -55, 3);
//
//
//        telemetry.addData("Path", "Complete");
//        telemetry.update();
//    }
//
//    /*
//     *  Method to perform a relative move, based on encoder counts.
//     *  Encoders are not reset as the move is based on the current position.
//     *  Move will stop if any of three conditions occur:
//     *  1) Move gets to the desired position
//     *  2) Move runs out of time
//     *  3) Driver stops the opmode running.
//     */
//
//    public void encoderStrafe (double speed, double leftInches, double rightInches, double timeoutS) {
//
//            int FLRRTarget;
//            int FRRLTarget;
//
//            FLRRTarget = hardware.RearLeftMotor.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
//            FRRLTarget = hardware.RearRightMotor.getCurrentPosition() - (int)(leftInches * COUNTS_PER_INCH);
//
//            hardware.FrontLeftMotor.setTargetPosition(FLRRTarget);
//            hardware.RearRightMotor.setTargetPosition(FLRRTarget);
//            hardware.RearLeftMotor.setTargetPosition(FRRLTarget);
//            hardware.FrontRightMotor.setTargetPosition(FRRLTarget);
//
//            hardware.FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            hardware.FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            hardware.RearRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            hardware.RearLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            runtime.reset();
//            hardware.FrontLeftMotor.setPower(Math.abs(speed));
//            hardware.FrontRightMotor.setPower(Math.abs(speed));
//            hardware.RearRightMotor.setPower(Math.abs(speed));
//            hardware.RearLeftMotor.setPower(Math.abs(speed));
//
//            while (opModeIsActive() &&
//                    (runtime.seconds() < timeoutS) &&
//                    (hardware.RearLeftMotor.isBusy() && hardware.RearRightMotor.isBusy() && hardware.FrontLeftMotor.isBusy() && hardware.FrontRightMotor.isBusy())) {
//
//                // Display it for the driver.
//                telemetry.addData("Path1",  "Running to %7d :%7d", FLRRTarget,  FRRLTarget);
//                telemetry.addData("Path2",  "Running at %7d :%7d",
//                        hardware.FrontRightMotor.getCurrentPosition(),
//                        hardware.FrontLeftMotor.getCurrentPosition(),
//                        hardware.RearRightMotor.getCurrentPosition(),
//                        hardware.RearLeftMotor.getCurrentPosition());
//                telemetry.update();
//            }
//
//            hardware.FrontRightMotor.setPower(0);
//            hardware.FrontLeftMotor.setPower(0);
//            hardware.RearRightMotor.setPower(0);
//            hardware.RearLeftMotor.setPower(0);
//
////             Turn off RUN_TO_POSITION
//            hardware.FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            hardware.FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            hardware.RearRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            hardware.RearLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//        }
//
//    public void encoderDrive (double speed,
//                              double leftInches, double rightInches,
//                              double timeoutS) {
//        int newLeftTarget;
//        int newRightTarget;
//
//        // Ensure that the opmode is still active
//        if (opModeIsActive()) {
//
//            // Determine new target position, and pass to motor controller
//            newLeftTarget = hardware.FrontLeftMotor.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
//            newRightTarget = hardware.FrontRightMotor.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
//
//            hardware.FrontRightMotor.setTargetPosition(-newRightTarget);
//            hardware.FrontLeftMotor.setTargetPosition(-newLeftTarget);
//            hardware.RearRightMotor.setTargetPosition(-newRightTarget);
//            hardware.RearLeftMotor.setTargetPosition(-newLeftTarget);
//
//            // Turn On RUN_TO_POSITION
//            hardware.FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            hardware.FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            hardware.RearRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            hardware.RearLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            // reset the timeout time and start motion.
//            runtime.reset();
//            hardware.FrontLeftMotor.setPower(Math.abs(speed));
//            hardware.FrontRightMotor.setPower(Math.abs(speed));
//            hardware.RearRightMotor.setPower(Math.abs(speed));
//            hardware.RearLeftMotor.setPower(Math.abs(speed));
//
//            // keep looping while we are still active, and there is time left, and both motors are running.
//            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
//            // its target position, the motion will stop.  This is "safer" in the event that the robot will
//            // always end the motion as soon as possible.
//            // However, if you require that BOTH motors have finished their moves before the robot continues
//            // onto the next step, use (isBusy() || isBusy()) in the loop test.
//            while (opModeIsActive() &&
//                    (runtime.seconds() < timeoutS) &&
//                    (hardware.FrontLeftMotor.isBusy() || hardware.RearLeftMotor.isBusy()) || (hardware.FrontRightMotor.isBusy() || hardware.RearRightMotor.isBusy())) {
//
//                // Display it for the driver.
//                telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
//                telemetry.addData("Path2",  "Running at %7d %7d %7d %7d",
//                        hardware.FrontRightMotor.getCurrentPosition(),
//                        hardware.FrontLeftMotor.getCurrentPosition(),
//                        hardware.RearRightMotor.getCurrentPosition(),
//                        hardware.RearLeftMotor.getCurrentPosition());
//                telemetry.update();
//            }
//
//            // Stop all motion;
//            hardware.FrontRightMotor.setPower(0);
//            hardware.FrontLeftMotor.setPower(0);
//            hardware.RearRightMotor.setPower(0);
//            hardware.RearLeftMotor.setPower(0);
//
//            // Turn off RUN_TO_POSITION
//            hardware.FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            hardware.FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            hardware.RearRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            hardware.RearLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//        }
//    }
//}
