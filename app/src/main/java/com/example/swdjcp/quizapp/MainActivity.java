package com.example.swdjcp.quizapp;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


private TextView txtAtm;
    private TextView txtCorr;
private TextView txtQuestion;
private Button mSubmit;
private Button mNext;
private RadioGroup rg;
private RadioButton rb1,rb2,rb3;
private RelativeLayout mRelativeLayout;
private Questions mQuestion = new Questions();


    public int chkRdr;
    public int chkRdr2;
    public int chkRd3;
    public int mAnwsernum ;
    public static int correct, attempt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up controls
        txtQuestion = (TextView) findViewById(R.id.qxtxView);
        txtAtm = (TextView) findViewById(R.id.txtAtm);
        txtCorr = (TextView) findViewById(R.id.txtCorr);
        rg = (RadioGroup) findViewById((R.id.radioGroup));
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        mSubmit = (Button) findViewById(R.id.btnSubmit);
        mSubmit.setBackgroundColor(getResources().getColor(R.color.btncolor));
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relay);


        //change color
        mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.bgcolor));

        //Toast.makeText(this,mQuestion.newanser,Toast.LENGTH_LONG);

            setupQuestions();


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(MainActivity.this, mQuestion.newanser, Toast.LENGTH_LONG).show();
                checkRadio();

            }
        });


    }


        public void checkRadio(){

        int radioButtonID = rg.getCheckedRadioButtonId();
        View radioButton = rg.findViewById(radioButtonID);
        int idx = rg.indexOfChild(radioButton);
       // Toast.makeText(this,"radiobutton" + idx,Toast.LENGTH_LONG).show();

        switch(idx){

            case 0 :
               chkRdr = rb1.getText().length();
               // Toast.makeText(this,"first selected" + chkRdr, Toast.LENGTH_LONG).show();
                attempt = attempt + 1;
                txtAtm.setText("" + attempt);
                checkAnwser(chkRdr);


                break;

            case 1:


                chkRdr2 = rb2.getText().length();

                //Toast.makeText(this,"second selected" + chkRdr2, Toast.LENGTH_LONG).show();
                attempt = attempt +1;
                txtAtm.setText(""+ attempt);
                    checkAnwser(chkRdr2);
                break;


            case 2:


                chkRd3 = rb3.getText().length();
               //
               // chkRd3 = mQuestion.newanser.length();

               // Toast.makeText(this,"third selected" + chkRd3, Toast.LENGTH_LONG).show();

                attempt = attempt + 1;
                txtAtm.setText("" + attempt);

                checkAnwser(chkRd3);

                 break;
        }



        }


      public void checkAnwser(int radiotxt){


            if(radiotxt == mAnwsernum){

                Toast.makeText(this,"Good Job!", Toast.LENGTH_LONG).show();

                correct = correct + 1;

                txtCorr.setText("" + correct);

                MediaPlayer.create(getBaseContext(),R.raw.applause).start();


                setupQuestions();

            }

               else{


               MediaPlayer.create(getBaseContext(),R.raw.fail).start();

                Toast.makeText(this,"Try Again!", Toast.LENGTH_LONG).show();

            }


        }


    public void setupQuestions(){



         rb3.setChecked(false);

        txtQuestion.setText(mQuestion.getQustions());

        mAnwsernum = mQuestion.newanser.length();

        rb1.setText(mQuestion.getopts());

        rb2.setText(mQuestion.getopts());

        chkRdr2 = rb2.getText().length();


        chkRdr = rb1.getText().length();

        rb3.setText(mQuestion.newanser);


        checkdulicate(chkRdr, chkRdr2);


    }



public void checkdulicate(int a , int b){

    if(a == b) {
        //rb2.setText(mQuestion.getopts());
        setupQuestions();

    }

}


}
