package com.ewubd.servicebhai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class userProfile extends AppCompatActivity {

    MyDatabaseHealper DB;
    SharedPreferences myPref;
    private TextView userName, userAddress, userEmail, userPhone, userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        DB= new MyDatabaseHealper(this);
        userName = findViewById(R.id.tv_profile_name_dynamic);
        userEmail = findViewById(R.id.tv_profile_email_dynamic);
        userAddress = findViewById(R.id.tv_profile_address_dynamic);
        userPhone = findViewById(R.id.tv_profile_phone_dynamic);
        userType = findViewById(R.id.tv_profile_type_dynamic);

        myPref = getApplicationContext().getSharedPreferences("userId", MODE_PRIVATE);
        int userid = myPref.getInt("loggedInID", -1);
        String profile[]= DB.getUserProfleInfo(userid);
        userName.setText(profile[1]);
        userEmail.setText(profile[2]);
        userAddress.setText(profile[3]);
        userPhone.setText(profile[4]);
        userType.setText(profile[5]);
    }
}