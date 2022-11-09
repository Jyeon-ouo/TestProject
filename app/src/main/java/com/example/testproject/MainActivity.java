package com.example.testproject;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText otcAddName = findViewById(R.id.otc_drug_add_name);
    EditText otcAddReason = findViewById(R.id.otc_drug_add_reason);
    EditText otcAddDate = findViewById(R.id.otc_drug_add_date);

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view){
            switch(view.getId()){
                case R.id.otc_drug_add_save:
                    writeNewOtc();
                    break;
            }
        }
    };

    @SuppressLint("ResourceType")
    private void init() {
        Button otcSaveBtn = findViewById(R.id.otc_drug_add_save);
        otcSaveBtn.setOnClickListener((View.OnClickListener) this);
    }

    private void writeNewOtc() {
        otcAdd otcAdd = new otcAdd();
        otcAdd.setOtcName(otcAddName.getText().toString());
        otcAdd.setOtcReason(otcAddReason.getText().toString());
        otcAdd.setOtcDate(otcAddDate.getText().toString());
        databaseReference.child("otcAdd").child("1").push().setValue(otcAdd);
    }

}