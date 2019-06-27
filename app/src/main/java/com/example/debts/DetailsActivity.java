package com.example.debts;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.debts.data.Data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailsActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private DatabaseReference cDatabase;
    private DatabaseReference dDatabase;
    private TextView total_cAmount;
    private TextView total_dAmount;
    private int cInt = 0;
    private int dInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        dDatabase = FirebaseDatabase.getInstance().getReference().child("Debts");
        cDatabase = FirebaseDatabase.getInstance().getReference().child("Credits");
        toolbar = findViewById(R.id.toolbar);
        total_cAmount = findViewById(R.id.totalCAmount);
        total_dAmount = findViewById(R.id.totalDAmount);
        TextView net = findViewById(R.id.totalCDAmount);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int amount = 0;

                for (DataSnapshot snapshot:dataSnapshot.getChildren()){

                    Data data = snapshot.getValue(Data.class);

                    assert data != null;
                    amount += data.getAmount();

                    dInt = amount;
                    String tAmount = String.valueOf(amount);

                    total_dAmount.setText(String.format("Ksh.%s.00", tAmount));
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        cDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int amount = 0;

                for (DataSnapshot snapshot:dataSnapshot.getChildren()){

                    Data data = snapshot.getValue(Data.class);

                    assert data != null;
                    amount += data.getAmount();

                    cInt = amount;

                    String tAmount = String.valueOf(amount);

                    total_cAmount.setText(String.format("Ksh.%s.00", tAmount));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        int netI = cInt - dInt;
        String netS = String.valueOf(netI);

        net.setText(netS);
    }

}
