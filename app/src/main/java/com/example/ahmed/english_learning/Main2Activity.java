package com.example.ahmed.english_learning;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    String shapes[], numbers[], fruits[], letters[], colors[], animals[], months[], days[];
    ImageView iv_photo;
    TextView txt_words;
    int id_intent;
    int i = -1;
    String swap_array[];
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        shapes = getResources().getStringArray(R.array.shapes);
        numbers = getResources().getStringArray(R.array.numbers);
        fruits = getResources().getStringArray(R.array.fruits);
        letters = getResources().getStringArray(R.array.letters);
        colors = getResources().getStringArray(R.array.colors);
        animals = getResources().getStringArray(R.array.animals);
        months = getResources().getStringArray(R.array.months);
        days = getResources().getStringArray(R.array.days);

        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        txt_words = (TextView) findViewById(R.id.txt_words);

        id_intent = (int) getIntent().getExtras().get("id");

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {
                    textToSpeech.setLanguage(Locale.US);
                } else {
                    Toast.makeText(Main2Activity.this, " this language not supported", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void btn_next(View view) {
        switch (id_intent) {
            case R.id.btn_animals:
                swap_array = animals;
                next();
                fun();
                break;
            case R.id.btn_shapes:
                swap_array = shapes;
                next();
                fun();
                break;
            case R.id.btn_numbers:
                swap_array = numbers;
                next();
                fun();
                break;
            case R.id.btn_letters:
                swap_array = letters;
                next();
                fun();
                break;
            case R.id.btn_fruits:
                swap_array = fruits;
                next();
                fun();
                break;
            case R.id.btn_colors:
                swap_array = colors;
                next();
                fun();
                break;
            case R.id.btn_days:
                swap_array = days;
                next();
                txt_words.setText(days[i]);
                textToSpeech.speak(days[i], TextToSpeech.QUEUE_FLUSH, null);
                break;
            case R.id.btn_months:
                swap_array = months;
                next();
                txt_words.setText(months[i]);
                textToSpeech.speak(months[i], TextToSpeech.QUEUE_FLUSH, null);
                break;
        }
    }

    public void btn_back(View view) {
        switch (id_intent) {
            case R.id.btn_animals:
                swap_array = animals;
                back();
                fun();
                break;
            case R.id.btn_shapes:
                swap_array = shapes;
                back();
                fun();
                break;
            case R.id.btn_numbers:
                swap_array = numbers;
                back();
                fun();
                break;
            case R.id.btn_letters:
                swap_array = letters;
                back();
                fun();
                break;
            case R.id.btn_fruits:
                swap_array = fruits;
                back();
                fun();
                break;
            case R.id.btn_colors:
                swap_array = colors;
                back();
                fun();
                break;
            case R.id.btn_days:
                back();
                txt_words.setText(days[i]);
                textToSpeech.speak(days[i], TextToSpeech.QUEUE_FLUSH, null);
                break;
            case R.id.btn_months:
                back();
                txt_words.setText(months[i]);
                textToSpeech.speak(months[i], TextToSpeech.QUEUE_FLUSH, null);
                break;
        }
    }

    public void fun() {
        iv_photo.setImageResource(getResources().getIdentifier(swap_array[i], "drawable", getPackageName()));
        txt_words.setText(swap_array[i]);
        textToSpeech.speak(swap_array[i], TextToSpeech.QUEUE_FLUSH, null);
    }

    public void next() {
        i++;
        if (i == swap_array.length) {
            i = 0;
        }
    }

    public void back() {
        i--;
        if (i < 0) {
            i = swap_array.length - 1;
        }
    }
}
