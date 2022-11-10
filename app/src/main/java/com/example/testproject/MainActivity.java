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

    //파이어베이스 데이터베이스 연동
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    //databaseReference : 데이터베이스의 특정 위치로 연결
    private final DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        Button otcAddSaveBtn = findViewById(R.id.otc_drug_add_save);
        Button otcAddCancelBtn = findViewById(R.id.otc_drug_add_cancel);
        EditText otcAddNameEdit = findViewById(R.id.otc_drug_add_name);
        EditText otcAddReasonEdit = findViewById(R.id.otc_drug_add_reason);
        EditText otcAddDateEdit = findViewById(R.id.otc_drug_add_date);

        otcAddSaveBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view){
                addOtcList(otcAddName.getText().toString(), otcAddReason.getText().toString(), otcAddDate.getText().toString());
           }
        });
    }

    //값을 파이어베이스 Realtime database로 넘기는 함수
    public void addOtcList(String otcAddName, String otcAddReason, String otcAddDate){
        //otcAdd.java에서 선언했던 함수
        otcAdd otcAdd = new otcAdd(otcAddName, otcAddReason, otcAddDate);

        //child : 해당 키 위치로 이동하는 함수
        databaseReference.child("otcManagementList").child(otcAddName).setValue(otcAddReason, otcAddDate);
    }

    @SuppressLint("ResourceType")
    private void init() {
        Button otcSaveBtn = findViewById(R.id.otc_drug_add_save);
        otcSaveBtn.setOnClickListener((View.OnClickListener) this);
    }



}