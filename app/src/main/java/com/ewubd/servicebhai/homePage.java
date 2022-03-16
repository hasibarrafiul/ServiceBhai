package com.ewubd.servicebhai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class homePage extends AppCompatActivity {

    Button logout;
    SharedPreferences myPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        logout = findViewById(R.id.homeLogout);
        logout.setOnClickListener(v->logout());
        myPref = getApplicationContext().getSharedPreferences("userId", MODE_PRIVATE);
    }
    void logout(){
        myPref.edit().putInt("loggedInID", -1).apply();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}