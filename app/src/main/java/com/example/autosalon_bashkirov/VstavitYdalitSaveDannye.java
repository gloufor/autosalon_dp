package com.example.autosalon_bashkirov;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VstavitYdalitSaveDannye {
    private DatabaseReference databaseReference;
    public VstavitYdalitSaveDannye(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(User.class.getSimpleName());
    }
    public Task<Void> add(User emp){
        return databaseReference.push().setValue(emp);
    }
}
