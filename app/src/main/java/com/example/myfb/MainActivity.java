package com.example.myfb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfb.database.Mydatabase;
import com.google.android.material.tabs.TabLayout;

import static com.example.myfb.database.Mydatabase.DB_NAME;
import static com.example.myfb.database.Mydatabase.DB_VERSION;

public class MainActivity extends AppCompatActivity {

    Mydatabase myDb;
    ViewPager viewPager;
    MyFragmentAdapter adapter;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new Mydatabase(this, DB_NAME, null, DB_VERSION);;
        viewPager = findViewById(R.id.fragment_pager);
        tabLayout=findViewById(R.id.tab);
        adapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




    }



}
