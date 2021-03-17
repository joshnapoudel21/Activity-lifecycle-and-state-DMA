package com.example.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int i = 0;
    private TextView show_count;
    private EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_count = findViewById(R.id.show_count);
        msg = findViewById(R.id.msg);
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                show_count.setVisibility(View.VISIBLE);
                msg.setText(savedInstanceState.getString("reply_text"));
                msg.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if (show_count.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", msg.getText().toString());
        }
    }

    public void count(View view) {
        i++;
        if (show_count !=null)
        {
            show_count.setText(Integer.toString(i));
        }
    }
}