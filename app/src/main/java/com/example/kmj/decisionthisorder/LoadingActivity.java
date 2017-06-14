package com.example.kmj.decisionthisorder;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Handler;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

public class LoadingActivity extends AppCompatActivity {

    ManageDB db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        String data = readData();
        String[] sqls = data.split(";");
        db = new ManageDB(getApplicationContext());
        InsertDB(sqls);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    private String readData(){
        String data = null;
        InputStream is = getResources().openRawResource(R.raw.rests);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        try{
            i=is.read();
            while (i!=-1){
                baos.write(i);
                i=is.read();
            }
            data = new String(baos.toByteArray(),"MS949");
        } catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    private void InsertDB(String[] strs){
        db.execRestaurants("drop table if exists restaurants");
        db.execRestaurants("create table if not exists restaurants (name text,major text,description text,image int,price text,type text,spicy text,country text,distance text,alcohol text);");
        for (int i=0;i<strs.length;i++){
            db.execRestaurants(strs[i]+";");
        }
    }
}
