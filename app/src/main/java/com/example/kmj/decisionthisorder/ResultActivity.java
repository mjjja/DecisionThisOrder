package com.example.kmj.decisionthisorder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Data> data = new ArrayList<>();
    ArrayAdapter<Data> adapter;
    ManageDB db = null;
    String sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        db = new ManageDB(getApplicationContext());
        setListView();
        init();
    }

    void setListView(){
        listView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ItemActivity.class);
                intent.putExtra("data",data.get(position));
                startActivity(intent);
            }

        });
    }

    void init(){
        sql=MainActivity.sql;
        showData(db.execSELECTRestaurants(sql));
    }

    void onClick(View v){
        if (v.getId()==R.id.button){
            Intent intent = new Intent(ResultActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    private void showData(Cursor recordSet){
        try{
            recordSet.moveToFirst();
            if (!recordSet.moveToNext()) return;

            data.clear();
            while(recordSet.moveToNext()){
                data.add(new Data(recordSet.getString(0),recordSet.getString(1),recordSet.getString(2),recordSet.getInt(3)));
            }

            recordSet.close();
            adapter.notifyDataSetChanged();
        }catch (SQLiteException e){
            e.printStackTrace();
        }
    }
}
