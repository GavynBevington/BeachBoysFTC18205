//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//import org.firstinspires.ftc.teamcode.robotHardware;
//
//
//@Autonomous
//
//public class Auto_ParkInSecondSquare extends LinearOpMode {
//
//    /* Declare OpMode members. */
//    robotHardware  hardware   = new robotHardware();   // Use a Pushbot's hardware
//    private ElapsedTime     runtime = new ElapsedTime();
//
//    static final double     COUNTS_PER_MOTOR_REV    = 4 ;    // eg: TETRIX Motor Encoder
//    static final double     DRIVE_GEAR_REDUCTION    = 72.0 ;     // This is < 1.0 if geared UP
//    static final double     WHEEL_DIAMETER_INCHES   = 3.5 ;     // For figuring circumference
//    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
//            (WHEEL_DIAMETER_INCHES * 3.1415);
//    static final double     DRIVE_SPEED             = 0.6;
//    static final double     TURN_SPEED              = 0.4;
//
//    @Override
//    public void runOpMode() {
//
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
//        hardware.backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        hardware.backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        hardware.backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        hardware.backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//        // Send telemetry message to indicate successful Encoder reset
//        telemetry.addData("Path0",  "Starting at %7d :%7d",
//                hardware.backLeftMotor.getCurrentPosition(),
//                hardware.backRightMotor.getCurrentPosition());
//        telemetry.update();
//
//        // Wait for the game to start (driver presses PLAY)
//        waitForStart();
//
//        // Step through each leg of the path,
//        // Note: Reverse movement is obtained by setting a negative distance (not speed)
//        encoderDrive(DRIVE_SPEED,  80,  80, 6.0);  // S1: Forward 80 Inches with 6 Sec timeout
//        encoderDrive(TURN_SPEED,   2, -2, 3.0);  // S2: Turn Right 2 Inches with 3 Sec timeout
//        encoderDrive(DRIVE_SPEED, 5, 5, 2);  // S3: Forward 5 Inches with 2 Sec timeout
//        encoderDrive(TURN_SPEED, -2, 2, 3);  // S4: Turn left 2 Inches with 3 Sec timeout
//        encoderDrive(DRIVE_SPEED, -30, -30, 4.0);  // S5: Reverse 30 Inches with 4 Sec timeout
//
//        sleep(1000);     // pause for servos to move
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
//    public void encoderDrive(double speed,
//                             double leftInches, double rightInches,
//                             double timeoutS) {
//        int newLeftTarget;
//        int newRightTarget;
//
//        // Ensure that the opmode is still active
//        if (opModeIsActive()) {
//
//            // Determine new target position, and pass to motor controller
//            newLeftTarget = hardware.backLeftMotor.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
//            newRightTarget = hardware.backRightMotor.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
//            hardware.backLeftMotor.setTargetPosition(newLeftTarget);
//            hardware.backRightMotor.setTargetPosition(newRightTarget);
//
//            // Turn On RUN_TO_POSITION
//            hardware.backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            hardware.backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            // reset the timeout time and start motion.
//            runtime.reset();
//            hardware.backLeftMotor.setPower(Math.abs(speed));
//            hardware.backRightMotor.setPower(Math.abs(speed));
//
//            // keep looping while we are still active, and there is time left, and both motors are running.
//            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
//            // its target position, the motion will stop.  This is "safer" in the event that the robot will
//            // always end the motion as soon as possible.
//            // However, if you require that BOTH motors have finished their moves before the robot continues
//            // onto the next step, use (isBusy() || isBusy()) in the loop test.
//            while (opModeIsActive() &&
//                    (runtime.seconds() < timeoutS) &&
//                    (hardware.backLeftMotor.isBusy() && hardware.backRightMotor.isBusy())) {
//
//                // Display it for the driver.
//                telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
//                telemetry.addData("Path2",  "Running at %7d :%7d",
//                        hardware.backLeftMotor.getCurrentPosition(),
//                        hardware.backRightMotor.getCurrentPosition());
//                telemetry.update();
//            }
//
//            // Stop all motion;
//            hardware.backLeftMotor.setPower(0);
//            hardware.backRightMotor.setPower(0);
//
//            // Turn off RUN_TO_POSITION
//            hardware.backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            hardware.backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//            //  sleep(250);   // optional pause after each move
//        }
//    }
//}