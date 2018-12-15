package com.example.soniagrigor.santascomming;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class Pop extends AppCompatActivity {

    private TextView txtResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_pop);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width= dm.widthPixels;
        int height= dm.heightPixels;

        getWindow().setLayout((int) (width*0.7),(int)(height*0.4));

        Intent myIntent = getIntent();
        if (myIntent.hasExtra("myExtra")){
            TextView txtResponse = (TextView)findViewById(R.id.txt_result);
            String response= myIntent.getStringExtra("myExtra");
            System.out.println("Soniiiiiia:  "+response);
            txtResponse.setText(response);
        }

    }

    public TextView getTxtResponse(){
        return txtResponse;
    }
}
