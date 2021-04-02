package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double so=0;
    int lines=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtF, txtC;
        final Button btnConvert;
        final RadioButton checC = findViewById(R.id.checC);
        final RadioButton checF = findViewById(R.id.checF);
        final TextView thongtin = (TextView)findViewById(R.id.thongtin);
        txtF =(EditText)findViewById(R.id.txtF);
        txtC =(EditText)findViewById(R.id.txtC);
        btnConvert =(Button)findViewById(R.id.btnConvert);

        txtC.setEnabled(false);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checC.isChecked()) {
                    String s=txtC.getText().toString();
                    if (!s.isEmpty()){
                        double a=Double.parseDouble(s);
                        so=a/1.8+32;
                        so=(double) Math.round(so * 100) / 100;
                        txtF.setText(so+"");
                        if(lines>12){
                            thongtin.setText("C to F:\t"+ txtC.getText().toString()+"->" +so+ "\n");
                            lines=0;
                        }else {
                            thongtin.setText(thongtin.getText().toString()+"C to F:\t"+ txtC.getText().toString()+"->" +so+"\n");
                            lines++;
                        }
                    }
                }
                else {
                    String s=txtF.getText().toString();
                    if (!s.isEmpty()) {
                        double a = Double.parseDouble(s);
                        so = (a - 32) / (1.8);
                        so=(double) Math.round(so * 100) / 100;
                        txtC.setText(so+"");
                        if (lines > 12) {
                            thongtin.setText("F to C:\t" + txtF.getText().toString() + "->" + so+ "\n");
                            lines = 0;
                        } else {
                            thongtin.setText(thongtin.getText().toString()  + "F to C:\t" + txtF.getText().toString() + "->" + so+ "\n");
                            lines++;
                        }
                    }
                }
            }
        });
        checC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtC.setEnabled(true);
                txtC.setText("");
                txtF.setText("");
                txtF.setEnabled(false);
            }
        });
        checF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtF.setEnabled(true);
                txtC.setText("");
                txtF.setText("");
                txtC.setEnabled(false);
            }
        });
    }
}