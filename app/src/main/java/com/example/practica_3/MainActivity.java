package com.example.practica_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    Button btn11;
    Button btn12;
    Button btn13;
    Button btn14;
    Button btn15;
    Button btn16;
    Button btn17;
    Button btn18;
    Button btn19;
    Button btn20;
    TextView txv;
    double priNum;
    String opera = "+";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn10=findViewById(R.id.btn10);
        btn11=findViewById(R.id.btn11);
        btn12=findViewById(R.id.btn12);
        btn13=findViewById(R.id.btn13);
        btn14=findViewById(R.id.btn14);
        btn15=findViewById(R.id.btn15);
        btn16=findViewById(R.id.btn16);
        btn17=findViewById(R.id.btn17);
        btn18=findViewById(R.id.btn18);
        btn19=findViewById(R.id.btn19);
        btn20=findViewById(R.id.btn20);
        txv = findViewById(R.id.txv);

        btn3.setOnClickListener(view -> {
            priNum = 0;
            txv.setText("0");
        });

        btn2.setOnClickListener(view -> txv.setVisibility(View.GONE));
        btn1.setOnClickListener(view -> {
            txv.setVisibility(View.VISIBLE);
            txv.setText("0");
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(btn18);
        nums.add(btn13);
        nums.add(btn14);
        nums.add(btn15);
        nums.add(btn9);
        nums.add(btn10);
        nums.add(btn11);
        nums.add(btn5);
        nums.add(btn6);
        nums.add(btn7);

        for (Button b : nums) {
            b.setOnClickListener(view -> {
                if (!txv.getText().toString().equals("0")) {
                    txv.setText(txv.getText().toString() + b.getText().toString());
                } else {
                    txv.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(btn4);
        opers.add(btn8);
        opers.add(btn12);
        opers.add(btn16);
        for (Button b : opers){
            b.setOnClickListener(view -> {
                priNum = Double.parseDouble(txv.getText().toString());
                opera = b.getText().toString();
                txv.setText("0");
            });
        }

        btn19.setOnClickListener(view -> {
            String num = txv.getText().toString();
            if (num.length()>1){
                txv.setText(num.substring(0, num.length()-1));
            } else if (num.length() == 1 && !num.equals("0")){
                txv.setText("0");
            }
        });

        btn17.setOnClickListener(view -> {
            if (!txv.getText().toString().contains(".")){
                txv.setText(txv.getText().toString() + ".");
            }
        });

        btn20.setOnClickListener(view -> {
            double segnum = Double.parseDouble(txv.getText().toString());
            double resul;
            switch (opera){
                case "/":
                    resul = priNum/segnum;
                    break;
                case "X":
                    resul = priNum*segnum;
                    break;
                case "+":
                    resul = priNum+segnum;
                    break;
                case "-":
                    resul = priNum-segnum;
                    break;
                default:
                    resul = priNum+segnum;
            }
            txv.setText(String.valueOf(resul));
            priNum = resul;
        });

        /*View.OnClickListener listener=new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        };

        B.setOnClickListener(listener);*/
    }
}