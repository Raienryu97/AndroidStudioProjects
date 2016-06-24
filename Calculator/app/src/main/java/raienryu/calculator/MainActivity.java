package raienryu.calculator;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.System;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    Button clc,add,sub,mult,div,b,be,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    EditText e1,e2,op,res;
    private long startTime;
    private boolean secondBack=false;
    /*
    **The following booleans when true allow either the
    **first operand or the second operand to be entered
    **Both will not be true at the same time
     */
    private boolean op1=true;
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
                /*
                **After setting an operator, if the first operand is
                **non empty, then make way for the second operand to
                **be entered in. Else keep stuff the default way
                 */
                if(!e1.getText().toString().contentEquals("")) {
                    op1 = false;
                    op2 = true;
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tl;dr : allow expressions like -2 + 3 or -2 * -3 to be calculated
                /*
                **The following cases allow us to give inputs in
                **negative form. If the first operand is empty and
                **the user keys in this button, then we use this click
                **as one that specifies sign and not as an operator.
                **If first operand is already keyed in, then  just use
                **this click to specify the operator. If operand 2 is
                **ready to be keyed in, and this button was clicked
                **while it is empty, then give it as a sign.
                 */
                if(op1 && e1.getText().toString().contentEquals("") )
                e1.append("-");
                else if(!op2){
                    op.setText("-");
                    op1=false;
                    op2=true;
                }
                else if(e2.getText().toString().contentEquals("") && op2)
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
                //Check if user is trying to clear empty stuff
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
                    /*
                    **There are some geniuses out there who would like to press the
                    ** "=" button without even giving any inputs or some people
                    **who won't give complete inputs. Address those people.
                     */
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
        /*
        **Some people just want to watch the world burn, they think
        **division by zero will make this Application force close. No
        **it doesn't force close, just shows infinity, but that would just
        **be boring. So replace it with an emoji, cause ThugLife.....
         */
        if(Float.isInfinite(c)) {
            res.setTextSize(20);
            res.setText(smartass);
        }
        else
            res.setText(String.valueOf(c));
    }

}
