package com.tuboi.changelanguage;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private AppCompatTextView txtWord;
    private AppCompatButton btnPortuguese;
    private AppCompatButton btnEnglish;
    private AppCompatButton btnSpanish;
    private AppCompatButton btnJapanese;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setEvents();

        setTitle(R.string.word);
    }

    private void initialize() {
        txtWord = (AppCompatTextView) findViewById(R.id.txtWord);
        btnPortuguese = (AppCompatButton) findViewById(R.id.btnPortuguese);
        btnEnglish = (AppCompatButton) findViewById(R.id.btnEnglish);
        btnSpanish = (AppCompatButton) findViewById(R.id.btnSpanish);
        btnJapanese = (AppCompatButton) findViewById(R.id.btnJapanese);
    }

    private void setEvents() {
        btnPortuguese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews("pt");
            }
        });

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews("en");
            }
        });

        btnSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews("es");
            }
        });

        btnJapanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews("ja");
            }
        });
    }

    private void updateViews(String languageCode) {
        LocaleHelper.setLocale(this, languageCode);

        txtWord.setText(R.string.word);
        setTitle(R.string.word);
    }
}
