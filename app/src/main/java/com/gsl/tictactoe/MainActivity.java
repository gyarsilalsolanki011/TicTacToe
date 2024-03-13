package com.gsl.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag = 0;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


    private void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void Chech(View view) {
        Button btnCurrent = (Button) view;

        if (btnCurrent.getText().toString().equals("")) {
            count++;

            if (flag == 0) {
                btnCurrent.setText("x");
                flag = 1;
            } else {
                btnCurrent.setText("o");
                flag = 0;
            }

            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();


                //Conditions

                if (b1.equals(b2) && b2.equals(b3) && !b2.equals("")) {
                    //1
                    newGame(b2);
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    //2
                    newGame(b4);
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    //3
                    newGame(b7);
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    //4
                    newGame(b1);
                } else if (b2.equals(b5) && b5.equals(b8) && !b8.equals("")) {
                    //5
                    newGame(b8);
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    //6
                    newGame(b3);
                } else if (b1.equals(b5) && b5.equals(b9) && !b9.equals("")) {
                    //7
                    newGame(b9);
                } else if (b3.equals(b5) && b5.equals(b7) && !b5.equals("")) {
                    //8
                    newGame(b5);
                } else if (!b1.equals("") && !b2.equals("") && !b3.equals("") && !b4.equals("") && !b5.equals("") && !b6.equals("") && !b7.equals("") && !b8.equals("") && !b9.equals("")) {
                    //9
                    newGame("");
                }
            }
        }

    }
    public void newGame(String b) {
        if (!b1.equals("") && !b2.equals("") && !b3.equals("") && !b4.equals("") && !b5.equals("") && !b6.equals("") && !b7.equals("") && !b8.equals("") && !b9.equals("") && b=="") {
            //Toast.makeText(this, "Winner Is: " + b, Toast.LENGTH_LONG).show();
            Toast toast = new Toast(getApplicationContext());

            View v1 = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.viewContainer));
            toast.setView(v1);
            TextView txtMsg = v1.findViewById(R.id.txtMsg);
            txtMsg.setText("Game is Drown");
            toast.setGravity(Gravity.BOTTOM,  35, 35);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
        } else{
            // Toast.makeText(this, "Game is Drown", Toast.LENGTH_LONG).show();
            Toast toast = new Toast(getApplicationContext());

            View v2 = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.viewContainer));
            toast.setView(v2);
            TextView txtMsg = v2.findViewById(R.id.txtMsg);
            txtMsg.setText("Winner Is: "+b);
            toast.setGravity(Gravity.BOTTOM,  35, 35);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                count = 0;
                flag = 0;
            }
        }, 2000);

    }


}