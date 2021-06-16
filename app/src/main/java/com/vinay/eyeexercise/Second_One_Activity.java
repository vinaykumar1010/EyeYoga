package com.vinay.eyeexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.vinay.eyeexercise.Constants;
import com.vinay.eyeexercise.R;

import java.io.Serializable;

import Exercise.FirebaseManager;
import Health.FragmentToActivity;
import Health.OnGetHealthTipListner;

public class Second_One_Activity extends AppCompatActivity implements Serializable, FragmentToActivity {
   private  String newString;
   private  String  receivingString;
   private  ProgressBar progressbar_view ;
    /**
     * XYZFragment, Interface , Firebase Manager
     * Step 1: Declare an Interface.
     * Step 2: Create firebase manager object and call its fetch data function. Pass Interface object in fetch Data function.
     * Step 3: In firebase manager, use this interface object, to call interface functions on success and on error.
     *
     */

    @Override
    public void communicate(String s) {
        Log.i(Constants.TAG, "MData received from fragment: " + s);
//        Log.d("received", s);
    }

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__one_);

        WebView webView = findViewById(R.id.webViewHtml);
        progressbar_view = findViewById(R.id.progressBar);
        progressbar_view.setVisibility(View.VISIBLE);


            //TODO here get the string stored in the string variable and do

          fetchDataFromFirebase(webView);

        progressbar_view.setVisibility(View.VISIBLE);
        // TODO: show progress bar
    }




    private void fetchDataFromFirebase(WebView webView) {
        FirebaseManager firebaseManagerObj = new FirebaseManager();
        firebaseManagerObj.storageData1(new OnGetHealthTipListner() {
            @Override
            public void onFailure() {
                Log.e(Constants.TAG, "firebase request to fetch exercises failed.");
            }

            @Override
            public void onSuccess(String url) {
                // TODO: hide progress bar
                progressbar_view.setVisibility(View.GONE);
                String html1 = url;
                Log.i(Constants.TAG, "Second_One_Activity : onSuccess url: " + url);


                webView.loadUrl(url);


            }
        });
    }


}