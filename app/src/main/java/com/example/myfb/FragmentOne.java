package com.example.myfb;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myfb.database.Mydatabase;

import static com.example.myfb.database.Mydatabase.DB_NAME;
import static com.example.myfb.database.Mydatabase.DB_VERSION;

public class FragmentOne extends Fragment{

    Mydatabase dataBaseManager;
    EditText name,age,mark;
    String nm,ag,mkr;
    Button insert;
    public static FragmentOne newInstance(){
        FragmentOne fragmentOne=new FragmentOne();
        return fragmentOne;




    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBaseManager = new Mydatabase(getContext(),DB_NAME,null,DB_VERSION);

        name=view.findViewById(R.id.editText2);
        age = view.findViewById(R.id.editText3);
        mark = view.findViewById(R.id.editText4);
        insert = view.findViewById(R.id.submit);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm = name.getText().toString();
                ag = age.getText().toString();
                mkr = mark.getText().toString();

                boolean inserted = dataBaseManager.insertData(""+nm,""+ag,""+mkr);

                if(inserted==true){
                    showMessage(""+nm,"Insert Successfully");
                    name.setText("");
                    age.setText("");
                    mark.setText("");
                }
                else{
                    showMessage("Error","Connection goes wrong!");
                    name.setText("");
                    age.setText("");
                    mark.setText("");
                }
            }
        });

    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
