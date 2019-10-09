package com.example.test_startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    private TextView tvNumberA, tvNumberB;
    private Button btnResult;

    private int numberA;
    private int numberB;

    public static final String RESULT = "RESULT";
    public static final int RESULT_PINN = 5599;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        getWidget();
        getData();
        setEvent();

    }

    public void getWidget() {
        tvNumberA = (TextView) findViewById(R.id.tv_numberA);
        tvNumberB = (TextView) findViewById(R.id.tv_numberB);
        btnResult = (Button) findViewById(R.id.btn_result);
    }

    public void getData() {
        Intent intent = getIntent();
        numberA = intent.getIntExtra(InputActivity.NUMBER_A, 0);
        numberB = intent.getIntExtra(InputActivity.NUMBER_B, 0);

        tvNumberA.setText(numberA + "");
        tvNumberB.setText(numberB + "");
    }

    public void setEvent() {
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = numberA + numberB;
                Intent intent = new Intent();
                intent.putExtra(RESULT, result);

                //set kết quả lại cho activity đã truyền, chạy đến onActivityResult
                setResult(RESULT_PINN, intent);
                finish();
            }
        });
    }
}
