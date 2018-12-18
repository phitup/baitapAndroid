package com.example.phitup.baitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView txtQuestion, txtCount;
    Button btnTrue, btnFalse, btnPre, btnNext;
    ArrayList<String> questionList, answerList;
    int Result, i = 0, count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        final String[] question_list = getResources().getStringArray(R.array.list_question);
        questionList = new ArrayList<>(Arrays.asList(question_list));

        String[] answer_list = getResources().getStringArray(R.array.list_answer);
        answerList = new ArrayList<>(Arrays.asList(answer_list));

        txtQuestion.setText(questionList.get(i));

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result = 1;
                XuLy();
            }
        });

        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result = 0;
                XuLy();
            }
        });

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i - 1;
                if(i <= -1){
                    i = 0;
                }
                CheckQuestionSize();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if(i > questionList.size() - 1){
                    i = questionList.size() -1;
                }
                txtQuestion.setText(questionList.get(i));
            }
        });

    }

    public void XuLy(){


            if (Integer.parseInt(answerList.get(i)) == Result) {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                i++;
                count++;
                txtCount.setText(String.valueOf(count));
                CheckQuestionSize();
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
                i++;
                txtCount.setText(String.valueOf(count));
                CheckQuestionSize();
            }

    }

    public void CheckQuestionSize(){
        if(i >= questionList.size()) {
            txtQuestion.setText("Số câu đã hết \nTổng câu trả lời đúng là : " + count);
            btnTrue.setVisibility(View.INVISIBLE);
            btnFalse.setVisibility(View.INVISIBLE);
            btnPre.setVisibility(View.INVISIBLE);
            btnNext.setVisibility(View.INVISIBLE);
        }else{
            txtQuestion.setText(questionList.get(i));
        }

    }

    private void AnhXa() {
        txtQuestion = findViewById(R.id.textViewQuestion);
        btnTrue = findViewById(R.id.btnTrue);
        btnFalse = findViewById(R.id.btnFalse);
        txtCount = findViewById(R.id.textViewCount);
        btnPre = findViewById(R.id.btnPre);
        btnNext = findViewById(R.id.btnNext);
    }
}
