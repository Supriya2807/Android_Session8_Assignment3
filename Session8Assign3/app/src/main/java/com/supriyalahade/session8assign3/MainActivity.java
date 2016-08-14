package com.supriyalahade.session8assign3;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    ProgressBar progressBar1,progressBar2,progressBar3,progressBar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button)findViewById(R.id.button_download);
        progressBar1=(ProgressBar)findViewById(R.id.progressBar1);
        progressBar2=(ProgressBar)findViewById(R.id.progressBar2);
        progressBar3=(ProgressBar)findViewById(R.id.progressBar3);
        progressBar4=(ProgressBar)findViewById(R.id.progressBar4);

        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        MyTask myTask1 = new MyTask(progressBar1);
        myTask1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        MyTask myTask2 = new MyTask(progressBar2);
        myTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        MyTask myTask3 = new MyTask(progressBar3);
        myTask3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        MyTask myTask4 = new MyTask(progressBar4);
        myTask4.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }


    class MyTask extends AsyncTask<Void,Integer,Void>{

        ProgressBar myProgressBar;

        public MyTask(ProgressBar target) {

            myProgressBar = target;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }




        @Override
        protected Void doInBackground(Void... voids) {
            for(int i=0;i<100;i++){

                try {
                    Thread.sleep(500);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            myProgressBar.setProgress(values[0]);
            button.setEnabled(false);
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            button.setEnabled(true);
        }
    }
}
