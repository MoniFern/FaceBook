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
        mydb = new Mydatabase(getContext(), DB_NAME, null, DB_VERSION);
        v1 = view.findViewById(R.id.viewAll);
        viewAll();
    }

    public void viewAll(){

        Cursor rs = mydb.getAll();
        ArrayList<String> data = new ArrayList<>();
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,data);
        if((rs.getCount())==0){
            showMessage("Error","Nothing Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();

        while (rs.moveToNext()){
            buffer.append("Name: "+rs.getString(1)+"\n");
            buffer.append("Age : "+rs.getString(2)+"\n");
            buffer.append("Mark: "+rs.getString(3)+"\n\n");

        }
        s = buffer.toString().split("\n\n");
        for(int i=0;i<(s.length);i++){
            data.add(s[i]);
        }
        v1.setAdapter(adapter);
        //showMessage("data",""+buffer.toString());
    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
