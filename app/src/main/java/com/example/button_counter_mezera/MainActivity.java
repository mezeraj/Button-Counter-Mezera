package com.example.button_counter_mezera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button upBtn;
    private Button downBtn;
    private Button clearBtn;
    private TextView counterTxt;
    private int counter = 0;
    private String strCounter;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        String saveCount = counterTxt.getText().toString();
        savedInstanceState.putString("key",saveCount);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String saveCount = savedInstanceState.getString("key");
        counterTxt.setText(saveCount);
        counter = Integer.parseInt(saveCount);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        upBtn = (Button)findViewById(R.id.upBtn);
        downBtn = (Button)findViewById(R.id.downBtn);
        clearBtn = (Button)findViewById(R.id.clearBtn);
        counterTxt = (TextView)findViewById(R.id.counterTxt);

        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                strCounter = Integer.toString(counter);
                counterTxt.setText(strCounter);
            }
        });
        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                strCounter = Integer.toString(counter);
                counterTxt.setText(strCounter);
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                strCounter = Integer.toString(counter);
                counterTxt.setText(strCounter);
            }
        });
    }
}
