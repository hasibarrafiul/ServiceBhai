package com.ewubd.servicebhai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class problemShow extends AppCompatActivity {

    private ListView postShow;
    MyDatabaseHelper DB;
    ArrayList<postedProblem> arrayList;
    customProblemAdapter customProblemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_show);

        postShow = findViewById(R.id.postShow);
        DB= new MyDatabaseHelper(this);

        arrayList = new ArrayList<>();
        loadDatainList();

    }
    public void loadDatainList(){
        arrayList = DB.getProblems();
        customProblemAdapter = new customProblemAdapter(this,arrayList, 0);
        postShow.setAdapter(customProblemAdapter);
        customProblemAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}