package com.geeks.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean isOperationClick = false;
    private String operation;
    private Integer first, second, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);

        MaterialButton nextActivity = findViewById(R.id.next_activity);

        nextActivity.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActiviity.class);
            intent.putExtra("key1", textView.getText().toString());
            startActivity(intent);

        });
    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            first = 0;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);        }
        isOperationClick = false;    }

    public void onOperationClick(View view) {
        if (view.getId() == R.id.btn_plus) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "-";
        } else if (view.getId() == R.id.btn_multp) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "*";
        } else if (view.getId() == R.id.btn_divid) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "/";
        } else if (view.getId() == R.id.btn_equal) {
            second = Integer.valueOf(textView.getText().toString());
            if (operation.equals("+")) {
                sum = first + second;
                textView.setText(sum.toString());
            } else if (operation.equals("-")) {
                sum = first - second;
                textView.setText(sum.toString());
            } else if (operation.equals("*")) {
                sum = first * second;
                textView.setText(sum.toString());
            } else if (operation.equals("/")) {
                if (second == 0) {
                    textView.setText("Error");
                } else {
                    sum = first / second;
                    textView.setText(sum.toString());
                }
            }
        }
        isOperationClick = true;
    }
}
