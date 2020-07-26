package com.example.translatortraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static HashMap<String, String> dict = new HashMap<>(); //создаем коллецию хэшмэп для наполнения словами

    //объявляем виджеты в коде
    private EditText englishText;
    private EditText russianText;
    private TextView status;
    private Button add;
    private Button allWords;
    private Button checkMode;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        englishText = findViewById(R.id.englishText);
        russianText = findViewById(R.id.russianText);
        status = findViewById(R.id.status);
        add = findViewById(R.id.add);
        allWords = findViewById(R.id.allWords);
        checkMode = findViewById(R.id.checkMode);

        dict.put("yes", "да");
        dict.put("no", "нет");
        dict.put("now", "сейчас");
        dict.put("cat", "кошка");
        dict.put("dog", "собака");
        dict.put("sun", "солнце");
        dict.put("grass", "трава");

    }

    //метод который проверяет введенные слова по нажатию на кнопку ADD
    public void add(View view) {
        String eng = englishText.getText().toString();
        String rus = russianText.getText().toString();
        if (dict.containsKey(eng)) {
            status.setText("Duplicate");
        } else {
            dict.put(eng, rus);
            status.setText("Word Added");
        }
    }

    public void goToAllWords(View view) {
        Intent intent = new Intent(this, AllWords.class);
        startActivity(intent);
    }

    public void goToCheckingMode(View view) {
        Intent intent = new Intent(this, CheckingMode.class);
        startActivity(intent);
    }
}