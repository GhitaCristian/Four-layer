package com.roplus.spherecpov.Login;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.roplus.spherecpov.ActivityMain;
import com.roplus.spherecpov.R;
import com.roplus.spherecpov.SlopeOp;

public class ActivityLogin extends AppCompatActivity {

    private SlopeOp slopeOp;
    EditText passwordEditText;
    String TAG = "ActivityLogin"; // this tag is used only for Log messages to help the developer
    boolean adminExists = false; // this boolean helps us Toast a message to the user after trying to login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordEditText = (EditText) findViewById(R.id.editTextPassword);
        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("SlopeOp");

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot mydata : dataSnapshot.getChildren()) { // this loop goes through each record of SlopeOp in database
                            slopeOp = mydata.getValue(SlopeOp.class);

                            if (slopeOp.getId() == Integer.parseInt(passwordEditText.getText().toString())){ // checks if the password is in any of the SlopeOp id's
                                Toast toast = Toast.makeText(getBaseContext(), "Logged in", Toast.LENGTH_SHORT);
                                toast.show(); // displays the Logged in message
                                Intent intent = new Intent(getBaseContext(), ActivityMain.class);
                                startActivity(intent);
                                adminExists = true;
                                break;
                            }
                        }
                        if (!adminExists){
                            Toast toast = Toast.makeText(getBaseContext(), "Please try again", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
