package com.example.test_startactivityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    private EditText etNumberA, etNumberB;
    private Button btnStart;

    public static final String NUMBER_A = "NUMBER_A";
    public static final String NUMBER_B = "NUMBER_B";

    public static final int REQUEST_CODE = 2812;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        getWidget();
        setEvent();
    }

    public void getWidget() {
        etNumberA = (EditText) findViewById(R.id.et_numberA);
        etNumberB = (EditText) findViewById(R.id.et_numberB);
        btnStart = (Button) findViewById(R.id.btn_start);
    }

    public void setEvent() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etNumberA.getText().toString()) &&
                        !TextUtils.isEmpty(etNumberB.getText().toString())) {
                    int numberA = Integer.parseInt(etNumberA.getText().toString());
                    int numberB = Integer.parseInt(etNumberB.getText().toString());

                    Intent intent = new Intent(InputActivity.this, OutputActivity.class);
                    intent.putExtra(NUMBER_A, numberA);
                    intent.putExtra(NUMBER_B, numberB);
                    startActivityForResult(intent, REQUEST_CODE);
                } else {
                    Toast.makeText(InputActivity.this, "Please input all", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == OutputActivity.RESULT_PINN) {
                int result = data.getIntExtra(OutputActivity.RESULT, 0);
                Toast.makeText(this, result + "", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
