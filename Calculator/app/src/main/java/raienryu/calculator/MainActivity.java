package raienryu.calculator;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.System;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    Button clc,add,sub,mult,div,b,be,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    EditText e1,e2,op,res;
    private long startTime;
    private boolean secondBack=false;
    private boolean op1=true;
    private boolean neg=false;
    private boolean op2=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        op = (EditText)findViewById(R.id.op);
        res = (EditText)findViewById(R.id.res);
        clc = (Button)findViewById(R.id.clc);
        add = (Button)findViewById(R.id.add);
        sub = (Button)findViewById(R.id.sub);
        mult = (Button)findViewById(R.id.mult);
        div = (Button)findViewById(R.id.div);
        b = (Button)findViewById(R.id.b);
        be = (Button)findViewById(R.id.be);
        b0 = (Button)findViewById(R.id.b0);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1)
                e1.append(".");
                else if(op2)
                    e2.append(".");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1)
                e1.append("0");
                else if(op2)
                    e2.append("0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(op1)
             e1.append("1");
                else if(op2)
                 e2.append("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1)
                e1.append("2");
                else if(op2)
                    e2.append("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1)
                e1.append("3");
                else if(op2)
                    e2.append("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1)
                e1.append("4");
                else if(op2)
                    e2.append("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1)
                e1.append("5");
                else if(op2)
                    e2.append("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1)
                e1.append("6");
                else if(op2)
                    e2.append("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1)
                e1.append("7");
                else if(op2)
                    e2.append("7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1)
                e1.append("8");
                else if(op2)
                    e2.append("8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1)
                e1.append("9");
                else if(op2)
                    e2.append("9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText("+");
                if(!e1.getText().toString().contentEquals("")) {
                    op1 = false;
                    op2 = true;
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1 && e1.getText().toString().contentEquals("") )
                e1.append("-");
                else if(!op2){
                    op.setText("-");
                    op1=false;
                    op2=true;
                }
                else if(op2 && e2.getText().toString().contentEquals(""))
                e2.append("-");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText("/");
                if(!e1.getText().toString().contentEquals("")) {
                    op1 = false;
                    op2 = true;
                }
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText("*");
                if(!e1.getText().toString().contentEquals("")) {
                    op1 = false;
                    op2 = true;
                }
            }
        });
        clc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().contentEquals("") && e2.getText().toString()
                        .contentEquals("") && op.getText().toString().contentEquals(""))
                Snackbar.make(v,"LOL , what you trying to clear?",Snackbar.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");
                op.setText("");
                res.setText("");
                op1=true;
                op2=false;
            }
        });
        be.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    calculate();
                }
                catch (StringIndexOutOfBoundsException|NumberFormatException e){
                    Snackbar.make(v,"Yeah right! Like that's even gonna work",Snackbar.LENGTH_SHORT)
                            .show();
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
            /*
            **If back was pressed the first time,only show toast
            **else exit the app, provided the user presses back
            **the second time within 2.5 seconds of the first
            */
        if(!secondBack) {
            Toast.makeText(MainActivity.this, "Press Back Again To Exit",
                    Toast.LENGTH_SHORT).show();
            secondBack=!secondBack;
            startTime = System.currentTimeMillis();
        } else if( System.currentTimeMillis()-startTime < 2500)
            super.onBackPressed();
        else {
            secondBack=!secondBack;
            onBackPressed();
        }
    }

    public void calculate(){
        String smartass="-_-";
        char operator = op.getText().toString().charAt(0);
        float a = Float.parseFloat(e1.getText().toString());
        float b = Float.parseFloat(e2.getText().toString());
        float c=0;
        if(operator == '+')
            c=a+b;
        if(operator == '-')
            c=a-b;
        if(operator == '*')
            c=a*b;
        if(operator == '/')
            c=a/b;
        if(Float.isInfinite(c)) {
            res.setTextSize(20);
            res.setText(smartass);
        }
        else
            res.setText(String.valueOf(c));
    }

}
