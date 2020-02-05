package com.example.visumed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.visumed.entidades.Drug;
import com.example.visumed.entidades.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DrugDetailsActivity extends AppCompatActivity {

    TextView name;
    TextView indications;
    TextView counterIndications;
    TextView dosage;

    private static User user = new User();
    private static Drug drug = new Drug();
    private static final ArrayList<Drug> drugs = new ArrayList<Drug>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_details);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Detalhes de medicamento");

        getSupportActionBar().setElevation(0);
        final FirebaseAuth auth = FirebaseAuth.getInstance();
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        final DatabaseReference drUser = firebaseDatabase.getReference("users/" + firebaseUser.getUid());

        name = (TextView) findViewById(R.id.drug_name);
        indications = (TextView) findViewById(R.id.drug_indications);
        counterIndications = (TextView) findViewById(R.id.drug_counterIndications);
        dosage = (TextView) findViewById(R.id.drug_dosage);

        drUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference ref = db.getReference("drugs");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    Drug drug = postSnapshot.getValue(Drug.class);
                    System.out.println(drug);
                    if(drug.getName().equals(name)){
                        name.setText(drug.getName());
                        indications.setText(drug.getIndications());
                        counterIndications.setText(drug.getCounterIndications());
                        dosage.setText(drug.getDosage());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
