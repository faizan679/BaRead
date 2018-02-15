package com.example.a1605126.baread;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
  //DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //myDB = new DatabaseHelper(this);
       //addData();
        Button scan_btn = findViewById(R.id.button);


        final Activity activity = this;
        scan_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        IntentIntegrator integrator = new IntentIntegrator(activity);
                        integrator.setPrompt("Scan");
                        integrator.setCameraId(0);
                        integrator.setBeepEnabled(false);
                        integrator.setBarcodeImageEnabled(false);
                        integrator.initiateScan();
                    }
                }
        );
    }
    //ADDING SOME DATA TO THE DATABASE....
   /*public void addData(){
       DatabaseHelper myDB = new DatabaseHelper(this);
       myDB.insertData("123445","MATHS BOOK","130");
        myDB.insertData("3598","ENGLISH BOOK","230");
        myDB.insertData("422353464","HINDI BOOK","200");
        myDB.insertData("4235235","COMPUTER BOOK","400");
    }*/
    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        TextView textView = findViewById(R.id.textView2);
        TextView textView1 = findViewById(R.id.textView3);
       TextView textView2 = findViewById(R.id.textView4);
        //String format = "Format : ";
        //String content = "Content : ";
        if(result != null) {
            if(result.getContents()==null){
                textView.setText(" ");
                textView1.setText(" " );
                textView2.setText("SCANNING CANCELLED...");
                //Toast.makeText(MainActivity.this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else
            {
                if(result.getContents().equals("9788122433234"))
                {
                    textView.setText("Content : " +  result.getContents());
                    textView1.setText("Name : NUMERICAL METHODS (NEW AGE)" );
                    textView2.setText("Price : Rs.475");
                }
                if(result.getContents().equals("9789332549593"))
                {
                    textView.setText("Content : " +  result.getContents());
                    textView1.setText("Name : DISCRETE MATHEMATICS STRUCTURES (PEARSON)." );
                    textView2.setText("Price : Rs.460");
                }
                if(result.getContents().equals("9789332582705"))
                {
                    textView.setText("Content : " +  result.getContents());
                    textView1.setText("Name : FUNDAMENTALS OF DATABASE SYSTEMS (PEARSON)" );
                    textView2.setText("Price : Rs.690");
                }
                if(result.getContents().equals("9781259005275"))
                {
                    textView.setText("Content : " +  result.getContents());
                    textView1.setText("Name : COMPUTER ORGANIZATION (Mc GRAW HILL)." );
                    textView2.setText("Price : Rs.600");
                }
                if(result.getContents().equals("9780070586703"))
                {
                    textView.setText("Content : " +  result.getContents());
                    textView1.setText("Name : ENGINEERING ECONOMICS (Mc GRAW HILL)." );
                    textView2.setText("Price : Rs.600");
                }
                if(result.getContents().equals("9788173716126"))
                {
                    textView.setText("Content : " +  result.getContents());
                    textView1.setText("Name : FUNDAMENTALS OF COMPT. ALGORITHMS." );
                    textView2.setText("Price : Rs.540");
                }
                if(result.getContents().equals("9788126513260"))
                {
                    textView.setText("Content : " +  result.getContents());
                    textView1.setText("Name : COMMUNICATION SYSTEMS (WILEY." );
                    textView2.setText("Price : Rs.500");
                }
                if(result.getContents().equals("1605126"))
                {
                    textView.setText("Content : " +  result.getContents());
                    textView1.setText("NAME : FAIZAN KHAN" );
                    textView2.setText("DETAILS : B.TECH 2nd YEAR CSE");
                }
            }
            /*else {
                textView.setText(content +  result.getContents());
                textView1.setText(format + result.getFormatName());
                //textView2.setText(result.getBarcodeImagePath());
                //Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            }*/
        }
        else {
            textView.setText("Content : " +  result.getContents());
            super.onActivityResult(requestCode, resultCode, data);
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
