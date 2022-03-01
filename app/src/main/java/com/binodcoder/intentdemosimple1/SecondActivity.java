package com.binodcoder.intentdemosimple1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView firstName;
    EditText lastName;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        firstName=(TextView)findViewById(R.id.tv_second_first_name);
        lastName=(EditText)findViewById(R.id.et_second_last_name);
        send=(Button)findViewById(R.id.btn_second_send);

        String fName=getIntent().getStringExtra("first_name");
        firstName.setText(fName);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lName=lastName.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("last_name", lName);
                setResult(RESULT_OK, intent);
                SecondActivity.this.finish();
            }
        });
    }
}