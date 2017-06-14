package com.example.kmj.decisionthisorder;

import  android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    LinearLayout main,q1,q2,q3,q4,q5,q6,fail;
    static String sql = "select * from restaurants where (";
    Button bt;
    ProgressBar pb;
    MyTask task;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = (LinearLayout)findViewById(R.id.mainlayout);
        q1 = (LinearLayout)findViewById(R.id.question1);
        q2 = (LinearLayout)findViewById(R.id.question2);
        q3 = (LinearLayout)findViewById(R.id.question3);
        q4 = (LinearLayout)findViewById(R.id.question4);
        q5 = (LinearLayout)findViewById(R.id.question5);
        q6 = (LinearLayout)findViewById(R.id.question6);
        fail = (LinearLayout)findViewById(R.id.fail);
        tv = (TextView)findViewById(R.id.textView);
        pb = (ProgressBar)findViewById(R.id.progressBar);
        bt = (Button)findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fail.setVisibility(View.GONE);
                q1.setVisibility(View.VISIBLE);
                startTimer();
                sql="select * from restaurants where (";
            }
        });
        sql="select * from restaurants where (";
        initTask();

    }

    void initTask(){
        task = new MyTask();
    }

    public void onClick(View v){
        if (v.getId()==R.id.start){
            main.setVisibility(View.GONE);
            q1.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.cheap){
            sql+="price='cheap' and ";
            q1.setVisibility(View.GONE);
            q2.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.expensive){
            sql+="price='expensive' and ";
            q1.setVisibility(View.GONE);
            q2.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.rice){
            sql+="type='rice' and ";
            q2.setVisibility(View.GONE);
            q3.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.noodle){
            sql+="type='noodle' and ";
            q2.setVisibility(View.GONE);
            q3.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.meat){
            sql+="type='meat' and ";
            q2.setVisibility(View.GONE);
            q3.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.snack){
            sql+="type='snack' and ";
            q2.setVisibility(View.GONE);
            q3.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.mild){
            sql+="spicy='mild' and ";
            q3.setVisibility(View.GONE);
            q4.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.hot){
            sql+="spicy='hot' and ";
            q3.setVisibility(View.GONE);
            q4.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.korea){
            sql+="country='korea' and ";
            q4.setVisibility(View.GONE);
            q5.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.china){
            sql+="country='china' and ";
            q4.setVisibility(View.GONE);
            q5.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.japan){
            sql+="country='japan' and ";
            q4.setVisibility(View.GONE);
            q5.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.western){
            sql+="country='western' and ";
            q4.setVisibility(View.GONE);
            q5.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.other){
            sql+="country='other' and ";
            q4.setVisibility(View.GONE);
            q5.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.close){
            sql+="distance='close' and ";
            q5.setVisibility(View.GONE);
            q6.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.far){
            sql+="distance='far' and ";
            q5.setVisibility(View.GONE);
            q6.setVisibility(View.VISIBLE);
            startTimer();
        }
        else if (v.getId()==R.id.no){
            sql+="alcohol='no');";
            task.cancel(true);
            Intent intent = new Intent(MainActivity.this,ResultActivity.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.yes){
            sql+="alcohol='yes');";
            task.cancel(true);
            Intent intent = new Intent(MainActivity.this,ResultActivity.class);
            startActivity(intent);
        }
    }

    class MyTask extends AsyncTask<Integer,Integer,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setProgress(100);
            tv.setText("선택하세요!");
        }

        @Override
        protected Void doInBackground(Integer... params) {
            int i;
            for (i=99;i>=0;i--){
                if (isCancelled()) return null;
                try{
                    Thread.sleep(5);
                    publishProgress(i);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pb.setProgress(values[0]);
            if (pb.getProgress()<50) tv.setText("빨리 선택하세요!");
            else tv.setText("선택하세요!");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pb.setProgress(0);
            tv.setText("시간 종료!");
            choosefail();
        }

        @Override
        protected void onCancelled() {
            tv.setText("선택 완료!");
            super.onCancelled();
        }
    }

    void startTimer(){
        task.cancel(true);
        task = new MyTask();
        task.execute(0);
    }

    void choosefail(){
        q1.setVisibility(View.GONE);
        q2.setVisibility(View.GONE);
        q3.setVisibility(View.GONE);
        q4.setVisibility(View.GONE);
        q5.setVisibility(View.GONE);
        q6.setVisibility(View.GONE);
        fail.setVisibility(View.VISIBLE);
    }

}
