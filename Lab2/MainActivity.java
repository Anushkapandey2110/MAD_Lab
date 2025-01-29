package com.example.calculatorapp;



import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private Button but0;
    private Button but1;

    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but6;
    private Button but7;
    private Button but8;
    private Button but9;
    private Button add;
    private Button mul;
    private Button div;
    private Button clr;
    private Button sub;
    private Button equal;
    private EditText display;
    char operator;
    int operand1;
    int operand2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        but0 = findViewById(R.id.btn0);
        but1 = findViewById(R.id.btn1);
        but2 = findViewById(R.id.btn2);
        but3 = findViewById(R.id.btn3);
        but4 = findViewById(R.id.btn4);
        but5 = findViewById(R.id.btn5);
        but6 = findViewById(R.id.btn6);
        but7 = findViewById(R.id.btn7);
        but8 = findViewById(R.id.btn8);
        but9 = findViewById(R.id.btn9);
        add = findViewById(R.id.btnADD);
        sub = findViewById(R.id.btnSUB);
        mul = findViewById(R.id.btnMUL);
        div = findViewById(R.id.btnDIV);
        clr = findViewById(R.id.btnC);
        equal = findViewById(R.id.btnEQ);
        display = findViewById(R.id.editTextText);

        View.OnClickListener NumberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button ClickedButton = (Button) v;
                String currentText = display.getText().toString();
                display.setText(currentText + ClickedButton.getText().toString());


            }
        };
        but0.setOnClickListener(NumberListener);
        but1.setOnClickListener(NumberListener);
        but2.setOnClickListener(NumberListener);
        but3.setOnClickListener(NumberListener);
        but4.setOnClickListener(NumberListener);
        but5.setOnClickListener(NumberListener);
        but6.setOnClickListener(NumberListener);
        but7.setOnClickListener(NumberListener);
        but8.setOnClickListener(NumberListener);
        but9.setOnClickListener(NumberListener);

        View.OnClickListener operatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button ClickedOperator = (Button) v;
                operand1 = Integer.parseInt(display.getText().toString());
                operator = ClickedOperator.getText().charAt(0);
                display.setText("");

            }
        };
        add.setOnClickListener(operatorListener);
        sub.setOnClickListener(operatorListener);
        mul.setOnClickListener(operatorListener);
        div.setOnClickListener(operatorListener);

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
                operand1 = 0;
                operand2 = 0;
                operator = '\0';
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operand2 = Integer.parseInt(display.getText().toString());

                int result = 0;
                switch (operator) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        if (operand2 != 0) {
                            result = operand1 / operand2;
                        } else {
                            display.setText("Error");
                            return;
                        }
                        break;
                }
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("op1", operand1);
                intent.putExtra("op2", operand2);
                intent.putExtra("ope", operator);
                intent.putExtra("res", result);
                startActivity(intent);
            }

        });
    }
}
