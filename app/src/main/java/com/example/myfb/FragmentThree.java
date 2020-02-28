package com.example.myfb;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfb.database.Mydatabase;

import java.util.ArrayList;

import static com.example.myfb.database.Mydatabase.DB_NAME;
import static com.example.myfb.database.Mydatabase.DB_VERSION;

public class FragmentThree extends Fragment {
    Mydatabase mydb;
    View view;
    String s[] ;
    ListView v1;


    public static FragmentThree newInstance(){
        FragmentThree fragmentThree=new FragmentThree();

        return fragmentThree;


    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_three, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



}
