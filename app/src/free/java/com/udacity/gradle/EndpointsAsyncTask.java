package com.udacity.gradle;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.example.android.androidlibrary.JokeActivity;
import com.example.carolinestewart.myapplication.backend.JokeBean;
import com.example.carolinestewart.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by carolinestewart on 7/29/16.
 */
 public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private String mResult;

    public EndpointsAsyncTask(Context context) {
    this.context = context;
    }



    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://android-app-backend.appspot.com/_ah/api/gradle-final-project");

            myApiService = builder.build();

        }
        try {
            return myApiService.putJoke(joke).execute();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

        @Override
        protected void onPostExecute (String result){
            super.onPostExecute(result);
            mResult = result;
            startJokeDisplayActivity();
        }




                private void startJokeDisplayActivity() {
                    Intent intent = new Intent(context, JokeActivity.class);
                    intent.putExtra(JokeActivity.JOKE_KEY, mResult);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }


}