package com.example.translatortraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;
import java.util.Random;

public class CheckingMode extends AppCompatActivity {
    private TextView englishWord;
    private EditText translationText;
    private TextView result;
    private Button check;
    private TextView score;
    private TextView antiScore;

    String en = "";
    String ru = "";
    int countScore = 0;
    int countAntiScore = 0;


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_mode);
        englishWord = findViewById(R.id.englishWord);
        translationText = findViewById(R.id.translationText);
        result = findViewById(R.id.result);
        check = findViewById(R.id.check);
        score = findViewById(R.id.score);
        antiScore = findViewById(R.id.antiScore);
        Random gen = new Random();
        int r = gen.nextInt(MainActivity.dict.size());
        int i = 0;
        for (Map.Entry<String, String> item : MainActivity.dict.entrySet()) {
            if (i == r) {
                en = item.getKey();
                ru = item.getValue();
                break;
            }
            i++;
        }
        englishWord.setText(en);
    }

    public void changeWords(View view) {
        Random gen = new Random();
        int r = gen.nextInt(MainActivity.dict.size());
        int i = 0;
        for (Map.Entry<String, String> item : MainActivity.dict.entrySet()) {
            if (i == r) {
                en = item.getKey();
                ru = item.getValue();
                break;
            }
            i++;
        }
        englishWord.setText(en);
    }

    public void checkWord(View view) {

        englishWord.setText(en);
        String userWord = translationText.getText().toString();
        if (userWord.equals(ru)) {
            result.setText("Correct!");
            countScore++;
            score.setText(String.valueOf(countScore));
        } else {
            result.setText("Incorrect :(");
            countAntiScore--;
            antiScore.setText(String.valueOf(countAntiScore));
        }
        changeWords(view);
    }
}