/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="test oded667", group="Linear Opmode")
//@Disabled
public class TestSystem2 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor trightDrive123 = null;
    private DcMotor brightDrive123 = null;
    private DcMotor bleftDrive123 = null;
    private DcMotor tleftDrive123 = null;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        trightDrive123 = hardwareMap.get(DcMotor.class, "t_right_drive");
        brightDrive123 = hardwareMap.get(DcMotor.class, "b_right_drive");
        tleftDrive123 = hardwareMap.get(DcMotor.class, "t_left_drive");
        bleftDrive123 = hardwareMap.get(DcMotor.class, "b_left_drive");
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            if (gamepad1.right_trigger > 0) {
                trightDrive123.setPower(gamepad1.right_trigger);
                brightDrive123.setPower(gamepad1.right_trigger);
                tleftDrive123.setPower(-gamepad1.right_trigger);
                bleftDrive123.setPower(-gamepad1.right_trigger);
            } else if (gamepad1.left_trigger > 0) {
                trightDrive123.setPower(-gamepad1.left_trigger);
                brightDrive123.setPower(-gamepad1.left_trigger);
                tleftDrive123.setPower(gamepad1.left_trigger);
                bleftDrive123.setPower(gamepad1.left_trigger);
            } else {
                trightDrive123.setPower(0);
                brightDrive123.setPower(0);
                tleftDrive123.setPower(0);
                bleftDrive123.setPower(0);
            }

            if (gamepad1.right_stick_x > 0) {
                trightDrive123.setPower(-gamepad1.right_stick_x);
                brightDrive123.setPower(-gamepad1.right_stick_x);
                tleftDrive123.setPower(-gamepad1.right_stick_x);
                bleftDrive123.setPower(-gamepad1.right_stick_x);
            }

            if (gamepad1.right_stick_x < 0) {
                trightDrive123.setPower(-gamepad1.right_stick_x);
                brightDrive123.setPower(-gamepad1.right_stick_x);
                tleftDrive123.setPower(-gamepad1.right_stick_x);
                bleftDrive123.setPower(-gamepad1.right_stick_x);
            }

            if (gamepad1.dpad_left) {
                    trightDrive123.setPower(-0.5);
                    brightDrive123.setPower(0.5);
                    tleftDrive123.setPower(-0.5);
                    bleftDrive123.setPower(0.5);
            }

            if (gamepad1.dpad_right) {
                trightDrive123.setPower(0.5);
                brightDrive123.setPower(-0.5);
                tleftDrive123.setPower(0.5);
                bleftDrive123.setPower(-0.5);
            }
        }
    }
}