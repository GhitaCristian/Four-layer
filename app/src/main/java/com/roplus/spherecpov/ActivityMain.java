package com.roplus.spherecpov;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.roplus.spherecpov.AddSession.ActivityAddSession;
import com.roplus.spherecpov.BookSession.ActivityBookSession;
import com.roplus.spherecpov.CheckIn.ActivityCheckIn;
import com.roplus.spherecpov.DeleteSession.ActivityDeleteSession;
import com.roplus.spherecpov.RegisterUser.ActivityRegisterUser;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRegisterUser = (Button) findViewById(R.id.buttonRegister);
        Button buttonBookses = (Button) findViewById(R.id.buttonBookses);
        Button buttonCheckIn = (Button) findViewById(R.id.buttonCheckIn);
        Button buttonAddSession = (Button) findViewById(R.id.buttonAddSession);
        Button buttonDeleteSession = (Button) findViewById(R.id.buttonDeleteSession);

        buttonRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ActivityRegisterUser.class);
                startActivity(intent);
            }
        });
        buttonBookses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ActivityBookSession.class);
                startActivity(intent);
            }
        });
        buttonCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ActivityCheckIn.class);
                startActivity(intent);
            }
        });
        buttonAddSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ActivityAddSession.class);
                startActivity(intent);
            }
        });
        buttonDeleteSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ActivityDeleteSession.class);
                startActivity(intent);
            }
        });
    }
}
