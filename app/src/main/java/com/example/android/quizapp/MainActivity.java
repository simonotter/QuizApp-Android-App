package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gradeQuiz(View view) {

        // Initialise score to zero
        int score = 0;
        String message;

        // Get answer to question 1
        RadioButton q1RadioButtonA = (RadioButton) findViewById(R.id.q1_RPM_50_75_radio_Button_A);
        Boolean q1AnswerA = q1RadioButtonA.isChecked();
        if (q1AnswerA) {
            // First radio button is checked and is correct answer so no need to check the others
            score += 1;
        }

        // Get answer to question 2
        EditText q2TextBox = (EditText) findViewById(R.id.q2_answer);
        String q2Answer = q2TextBox.getText().toString();
        if (q2Answer.equalsIgnoreCase(getString(R.string.answer2))) {
            score += 1;
        }

        // Get answers to question 3
        CheckBox q3HandPump = (CheckBox) findViewById(R.id.q3_hand_pump);
        Boolean q3AnswerA = q3HandPump.isChecked();

        CheckBox q3TyreLevers = (CheckBox) findViewById(R.id.q3_tyre_levers);
        Boolean q3AnswerB = q3TyreLevers.isChecked();

        CheckBox q3TrackPump = (CheckBox) findViewById(R.id.q3_track_pump);
        Boolean q3AnswerC = q3TrackPump.isChecked();

        CheckBox q3PedalSpanner = (CheckBox) findViewById(R.id.q3_pedal_spanner);
        Boolean q3AnswerD = q3PedalSpanner.isChecked();

        // Correct answer is A and B, but not C and D
        if (q3AnswerA && q3AnswerB && !q3AnswerC && !q3AnswerD) {
            score += 1;
        }

        // Get answer to question 4
        EditText q4TextBox = (EditText) findViewById(R.id.q4_answer);
        String q4Answer = q4TextBox.getText().toString();
        if (q4Answer.equalsIgnoreCase(getString(R.string.answer4))) {
            score += 1;
        }

        // Display final score to the user
        if (score == 4) {
            message = getString(R.string.max_score) + "\n" + getString(R.string.your_score, score);
        } else {
            message = getString(R.string.your_score, score);
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
