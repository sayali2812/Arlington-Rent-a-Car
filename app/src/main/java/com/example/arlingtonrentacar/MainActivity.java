package com.example.arlingtonrentacar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_username, editText_password;
    String username, password;
    Intent intent;
    //ashwini
    UserDao mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //ashwini
        mydb = new UserDao(this);
        addRecordsToDb();
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
                    //ashwini: redirected to manager home screen for testing
                    startActivity(new Intent(this, ManagerHomeScreen.class));
//                }
            }
        }

    }
    //ashwini
    public void addRecordsToDb(){
        String rec1= mydb.addRecord("Prajakta","Waikar","prajuw","prajPass1","17282","Renter","prajakta1@gmail.com","9877545409","str2","pune","MH","62525","yes");
        String rec2= mydb.addRecord("Ashwini","Trale","ashut","ashuPass2","17283","Manager","ashwinit6@gmail.com","9877006745","str1","pune","MH","62585","no");
        String rec3= mydb.addRecord("Shubham","Patil","shubhp","shubhPass3","17284","Admin","shubhamp123@gmail.com","9187092454","str3","pune","MH","60585","no");
    }
}
