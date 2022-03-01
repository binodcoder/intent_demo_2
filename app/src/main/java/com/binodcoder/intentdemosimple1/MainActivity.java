package com.binodcoder.intentdemosimple1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText firstName;
    Button send;
    TextView fullName;
    final int rCode=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName=(EditText)findViewById(R.id.et_main_first_name);
        send=(Button)findViewById(R.id.btn_main_send);
        fullName=(TextView)findViewById(R.id.tv_main_full_name);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName=firstName.getText().toString();
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("first_name", fName);
                startActivityForResult(intent, rCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String fName=firstName.getText().toString();
        String lName=data.getStringExtra("last_name");
        if(requestCode == rCode){
            if(resultCode==RESULT_OK){
                fullName.setText(fName+" "+lName);
            }

        }
    }
}