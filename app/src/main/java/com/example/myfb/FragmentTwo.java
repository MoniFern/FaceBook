package com.example.myfb;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfb.database.Mydatabase;

import java.util.ArrayList;

import static com.example.myfb.database.Mydatabase.DB_NAME;
import static com.example.myfb.database.Mydatabase.DB_VERSION;

public class FragmentTwo extends Fragment {
    Mydatabase mydb;
    SearchView searchView;
    ListView name;
    String s[] ;

    public static FragmentTwo newInstance(){
        FragmentTwo fragmentTwo=new FragmentTwo();
        return fragmentTwo;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mydb = new Mydatabase(getContext(), DB_NAME, null, DB_VERSION);

        searchView = view.findViewById(R.id.searchDt);
        name = view.findViewById(R.id.name);

        viewMen();


    }

    public void viewMen(){
        Cursor rs = mydb.getAll();
        ArrayList<String> data = new ArrayList<>();
        final ArrayAdapter<String>  adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,data);



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

        name.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                adapter.getFilter().filter(s);

                return false;
            }
        });
    }

    }



