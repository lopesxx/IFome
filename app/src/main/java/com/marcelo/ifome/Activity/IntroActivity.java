package com.marcelo.ifome.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

import com.marcelo.ifome.R;

public class IntroActivity extends AppCompatActivity {

    private ConstraintLayout btnComecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        btnComecar = (ConstraintLayout) findViewById(R.id.btn_comecar);
        btnComecar.setOnClickListener(v -> startActivity(new Intent(IntroActivity.this, MainActivity.class)));
    }
}