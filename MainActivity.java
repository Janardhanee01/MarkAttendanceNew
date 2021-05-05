package com.example.markattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recycler_view);
        b1=findViewById(R.id.btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);

        List<ModelClass> modelClassList = new ArrayList<>();
        List<ModelClass> modelClassList1 = new ArrayList<>();
        modelClassList.add(new ModelClass(1, "name1",2009 , "cse"));
        modelClassList.add(new ModelClass(2, "name2",2019 , "cse")) ;
        modelClassList.add(new ModelClass(3, "name3",2019 , "cse")) ;
        modelClassList.add(new ModelClass(4, "name4",2019 , "cse")) ;
        modelClassList.add(new ModelClass(5, "name5",2019 , "cse")) ;

        Adapter adapter=new Adapter(modelClassList,this,modelClassList1);
        recyclerview.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names= "";
                for(ModelClass user:modelClassList1)
                {
                    names=names+user.getName()+ " ";
                }
               Toast.makeText(MainActivity.this, names ,Toast.LENGTH_SHORT).show();
            }
        });
    }



}
