package com.example.myapplication6;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
public class MainActivity extends AppCompatActivity {

    Button btn, btn1, btn2, btn3;
    TextView tV11, tV12, tV21, tV22, tV31, tV32;
    EditText eT1, eT2, eT3;
    ImageView iV1, iV2, iV3;
    boolean click1, click2, click3 = false;
    int num, num1;
    int count = 0;
    public static Random rnd=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVars();
        start();
    }

    private void start() {

        num = rnd.nextInt(90)+10;
        num1 = rnd.nextInt(90)+10;
        tV11.setText(String.valueOf(num));
        tV12.setText(String.valueOf(num1));
        num += num1;
    }

    public void reset(View view) {
        click1 = false;
        click2 = false;
        click3 = false;
        count = 0;
        tV11.setText("");
        tV12.setText("");
        tV21.setText("");
        tV22.setText("");
        tV31.setText("");
        tV32.setText("");
        eT1.setText("");
        eT2.setText("");
        eT3.setText("");
        iV1.setImageBitmap(null);
        iV2.setImageBitmap(null);
        iV3 .setImageBitmap(null);
        start();
    }

    public void pressed1(View view) {
        if (!click1 && !click2 && !click3){
            click1 = true;

            String st = eT1.getText().toString();
            int answer = Integer.parseInt(st);

            if (answer == num){
                count++;
                iV1.setImageResource(R.drawable.ve);
            }
            else
                iV1.setImageResource(R.drawable.ex);
            tV21.setText(String.valueOf(num));
            num1 = rnd.nextInt(90)+10;
            tV22.setText(String.valueOf(num1));
            num += num1;

        }
    }

    public void pressed2(View view) {
        if (click1 && !click2 && !click3){
            click2 = true;
            String st = eT2.getText().toString();
            int answer = Integer.parseInt(st);

            if (answer == num){
                count ++;
                iV2.setImageResource(R.drawable.ve);
            }
            else
                iV2.setImageResource(R.drawable.ex);

            tV31.setText(String.valueOf(num));
            num1 = rnd.nextInt(90)+10;
            tV32.setText(String.valueOf(num1));
            num+=num1;
        }
    }

    public void pressed3(View view) {
        if (click1 && click2 && !click3){
            click3 = true;
            String st = eT3.getText().toString();
            int answer = Integer.parseInt(st);
            if (answer == num){
                count ++;
                iV3.setImageResource(R.drawable.ve);
            }
            else
                iV3.setImageResource(R.drawable.ex);
            Toast.makeText(this, count+"/3", Toast.LENGTH_LONG).show();
        }
    }
    private void setVars() {
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        tV11 = findViewById(R.id.tV11);
        tV12 = findViewById(R.id.tV12);
        tV21 = findViewById(R.id.tV21);
        tV22 = findViewById(R.id.tV22);
        tV31 = findViewById(R.id.tV31);
        tV32 = findViewById(R.id.tV32);

        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
        eT3 = findViewById(R.id.eT3);

        iV1 = findViewById(R.id.iV1);
        iV2 = findViewById(R.id.iV2);
        iV3 = findViewById(R.id.iV3);
    }

}