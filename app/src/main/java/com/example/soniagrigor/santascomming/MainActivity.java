package com.example.soniagrigor.santascomming;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements NameFragment.OnFragmentInteractionListener {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        ImageButton  btnNaughty = (ImageButton) findViewById(R.id.btn_naughty);
        btnNaughty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nameFragment=new NameFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.activity_main,nameFragment);
                transaction.commit();

            }
        });
    }

    @Override
    public void onFragmentInteraction() {
        Fragment fragment = null;
        fragment=NameFragment.newInstance("Let's check!");
    }

}
