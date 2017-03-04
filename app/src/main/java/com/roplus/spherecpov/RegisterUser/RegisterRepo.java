package com.roplus.spherecpov.RegisterUser;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by test on 04-Mar-17.
 */

public class RegisterRepo {

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    public void writeUser(User user){
        mDatabase.child("Users").push().setValue(user);
    }

    public interface onCheckUserExist{
        void exist();
        void notExist();
    }

    public void checkUserExists(final String emailAddress, final String emailDomain){
        DatabaseReference myRef = database.getReference("Users");
        myRef.addValueEventListener(new ValueEventListener() {
            boolean userExists;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot mydata : dataSnapshot.getChildren()){
                    User user = mydata.getValue(User.class);

                    if (user.getEmailAddress().equals(emailAddress) &&
                            user.getEmailDomain().equals(emailDomain)){
                        onCheckUserExist.exist();
                        userExists = true;
                        break;
                    }
                }
                if (!userExists){
                    onCheckUserExist.notExist();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
