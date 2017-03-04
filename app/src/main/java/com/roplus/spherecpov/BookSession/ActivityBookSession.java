package com.roplus.spherecpov.BookSession;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.roplus.spherecpov.R;

public class ActivityBookSession extends AppCompatActivity {

    EditText editTextUsername, editTextDay, editTextMonth, editTextYear, editTextStartHour, editTextEndHour;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_session);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextDay = (EditText) findViewById(R.id.editTextDay);
        editTextMonth = (EditText) findViewById(R.id.editTextMonth);
        editTextYear = (EditText) findViewById(R.id.editTextYear);

        Button buttonBook = (Button) findViewById(R.id.buttonBook);
        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String day = editTextDay.getText().toString();
                String month = editTextMonth.getText().toString();
                String year = editTextYear.getText().toString();
                String startHour = editTextStartHour.getText().toString();
                String endHour = editTextEndHour.getText().toString();


                mDatabase.child("Bookings").child(day+"-"+month+"-"+year).child(startHour+"-"+endHour).setValue(username);
                mDatabase.child("Bookings").child(day+"-"+month+"-"+year).child("id").setValue(day+month+year);
            }
        });

    }
}
