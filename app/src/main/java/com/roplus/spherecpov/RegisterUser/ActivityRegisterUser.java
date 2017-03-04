package com.roplus.spherecpov.RegisterUser;

import android.content.Intent;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.roplus.spherecpov.ActivityMain;
import com.roplus.spherecpov.R;

public class ActivityRegisterUser extends AppCompatActivity {

    EditText editTextFirstName, editTextLastName, editTextEmail;
    Button buttonRegisterUser;

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        final RegisterRepo registerRepo = new RegisterRepo(); // use registerRepo to write to database

        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        buttonRegisterUser = (Button) findViewById(R.id.buttonRegisterUser);

        buttonRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = editTextFirstName.getText().toString()+editTextLastName.getText().toString();
                final String email = editTextEmail.getText().toString();
                final int index = email.indexOf("@");

                registerRepo.checkUserExists(email.substring(0,index),email.substring(index+1,email.length()), new RegisterRepo.onCheckUserExist(){

                    @Override
                    public void exist(){
                        Toast toast = Toast.makeText(getBaseContext(), "User exists",Toast.LENGTH_SHORT);
                        toast.show();
                    }

                    @Override
                    public void nonExist(){
                        User user = new User(editTextFirstName.getText().toString(), editTextLastName.getText().toString(),email.substring(0,index),email.substring(index+1,email.length()));
                        registerRepo.writeUser(user);
                    }

                });





                Toast toast = Toast.makeText(getBaseContext(), "User registered", Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(getBaseContext(), ActivityMain.class);
                startActivity(intent);
            }
        });

    }

}
