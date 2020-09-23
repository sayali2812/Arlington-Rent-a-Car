package com.example.arlingtonrentacar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText_username, editText_password;
    String username, password;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void checkValidUser(View view){
        String db_password = "test", db_password_query, role = "User";
        editText_username = findViewById(R.id.edittext_username);
        editText_password = findViewById(R.id.edittext_password);
        username = editText_username.getText().toString().trim();
        password = editText_password.getText().toString().trim();

        if(username.length()!=0 && password.length()!=0){
//          check for username and password using db query
            if(!password.equalsIgnoreCase(db_password)){
                editText_username.setText("");
                editText_password.setText("");
            }
//          if they match start an activity according to the role
            else{
//                if(role.trim().toLowerCase() == "user"){
                    startActivity(new Intent(this, testactivity.class));
//                }
            }
        }

    }
}
