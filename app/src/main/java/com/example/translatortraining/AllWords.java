package com.example.translatortraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;

public class AllWords extends AppCompatActivity {
    private TextView allWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_words);
        allWords = findViewById(R.id.allWords);
        String s = "";
        for (Map.Entry<String, String> item : MainActivity.dict.entrySet()) {
            allWords.setText(s += item.getKey() + "; ");
            allWords.setText(s += item.getValue() + "; ");
        }
    }
}