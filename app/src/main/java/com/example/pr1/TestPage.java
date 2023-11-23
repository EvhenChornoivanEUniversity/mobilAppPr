package com.example.pr1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class TestPage extends AppCompatActivity {

    private Button btn_EndTest;

    private TextInputEditText inp_answ1;
    private TextInputLayout frame;
    private SeekBar inp_answ2;
    private TextView barOutput;
    private RadioGroup inp_answ3;
    private RadioGroup inp_answ4;
    private ArrayList<CheckBox> inp_answ5 = new ArrayList<CheckBox>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_page);

        GetAllFormaElements();

        btn_EndTest.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(CheckOnEmptyForms()) CheckAnswers();
                    }
                }
        );
    }

    void GetAllFormaElements() {
        btn_EndTest = (Button) findViewById(R.id.btn_endTest);

        frame = (TextInputLayout) findViewById(R.id.InputFrame);
        inp_answ1 = (TextInputEditText) findViewById(R.id.Input);

        inp_answ2 = (SeekBar) findViewById(R.id.SB);
        barOutput = (TextView) findViewById(R.id.barValueOutput);

        inp_answ3 = (RadioGroup) findViewById(R.id.rad_q3) ;

        inp_answ4 = (RadioGroup) findViewById(R.id.rad_q4);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.checkboxes);
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = linearLayout.getChildAt(i);

            if (childView instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) childView;
                inp_answ5.add(checkBox);
            }
        }
    }

    boolean CheckOnEmptyForms(){
        boolean isEmptyForma = false;
        int emptyCounter = 0;
        if(inp_answ1.getText().toString().equalsIgnoreCase("")){
            emptyCounter++;
            isEmptyForma = true;
        }

        if (inp_answ3.getCheckedRadioButtonId() == -1){
            emptyCounter++;
            isEmptyForma = true;
        }

        if (inp_answ4.getCheckedRadioButtonId() == -1){
            emptyCounter++;
            isEmptyForma = true;
        }

        boolean isCheked = false;
        for (int i = 0; i < inp_answ5.size(); i++) {
            if(inp_answ5.get(i).isChecked()){
                isCheked =true;
                break;
            }
        }
        if(!isCheked){
            emptyCounter++;
            isEmptyForma = true;
        }

        if(isEmptyForma){
            Toast.makeText(this, "Ви не відповіли на " + emptyCounter + " питань", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    void CheckAnswers(){
        if(inp_answ1.getText().toString().equalsIgnoreCase(getString(R.string.test_q1_answer1).toString())){
            frame.setHintTextColor(ColorStateList.valueOf(getResources().getColor(R.color.correct)));
        }else{
            frame.setHintTextColor(ColorStateList.valueOf(getResources().getColor(R.color.wrong)));
        }

        if(inp_answ2.getProgress() == 3){
            barOutput.setTextAppearance(R.style.CorrectAnswer);
        }else{
            barOutput.setTextAppearance(R.style.WrongAnswer);
        }

        RadioButton box = (RadioButton)findViewById(inp_answ3.getCheckedRadioButtonId());
        if(box.getText().toString().equalsIgnoreCase(getString(R.string.test_q3_answer1).toString())){
           box.setTextAppearance(R.style.CorrectAnswer);
        }else{
            box.setTextAppearance(R.style.WrongAnswer);
        }

        RadioButton box2 = (RadioButton) findViewById(inp_answ4.getCheckedRadioButtonId());
        if(box2.getText().toString().equalsIgnoreCase(getString(R.string.test_q4_answer1).toString())){
            box2.setTextAppearance(R.style.CorrectAnswer);
        }else{
            box2.setTextAppearance(R.style.WrongAnswer);
       }

        if(inp_answ5.get(0).isChecked()){
            inp_answ5.get(0).setTextAppearance(R.style.CorrectAnswer);
        }
        if(inp_answ5.get(1).isChecked()){
            inp_answ5.get(1).setTextAppearance(R.style.CorrectAnswer);
        }
        if(inp_answ5.get(2).isChecked()){
            inp_answ5.get(2).setTextAppearance(R.style.WrongAnswer);
        }
    }
}