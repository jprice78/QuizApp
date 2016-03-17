
package com.example.swdjcp.quizapp;

import java.util.Random;

/**
 * Created by swdjcp on 3/15/2016.
 */
public class Questions {
   public String mQuestions [] = {"Who is the CEO of FaceBook?" , "What kind of programing language is java? " , "Who was the original creator of Java?", "Who is CEO of Twitter?"};
    public String mAnwser[] = {"Mark Zuckerberg", "Object Oriented " , "Sun MicroSystems" , "Jack Dorsey"};
    public String mOps[] = {"Pesident Obama", "HTC", "Aurora", "Vitamin Water","Sony", "LG","Sharp"};
    public String newanser;


     public int randnum;

    public String getQustions(){


        String q = "";

        Random randomGen = new Random();

        randnum = randomGen.nextInt(mQuestions.length);

        q = mQuestions[randnum];

        newanser = mAnwser[randnum];


        return q;

    }



    public String getopts(){

        String g = "";

        Random randomGen2 = new Random();

        randnum = randomGen2.nextInt(mOps.length);

        g = mOps[randnum];


        return g;
    }





}
