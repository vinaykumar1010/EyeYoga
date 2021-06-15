package com.vinay.eyeexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.io.Serializable;

public class Second_One_Activity extends AppCompatActivity {

    /**
     * XYZFragment, Interface , Firebase Manager
     * Step 1: Declare an Interface.
     * Step 2: Create firebase manager object and call its fetch data function. Pass Interface object in fetch Data function.
     * Step 3: In firebase manager, use this interface object, to call interface functions on success and on error.
     *
     */


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__one_);
        fetchDataFromFirebase();
        // TODO: show progress bar
    }

    private void fetchDataFromFirebase(){
        FirebaseManager firebaseManagerObj = new FirebaseManager();
        firebaseManagerObj.storageData1(new OnGetHealthTipListner() {
            @Override
            public void onFailure() {
                Log.e(Constants.TAG, "firebase request to fetch exercises failed.");
            }

            @Override
            public void onSuccess(String url) {
                // TODO: hide progress bar
                Log.i(Constants.TAG, "Second_One_Activity : onSuccess url: " + url);
                WebView webView = findViewById(R.id.webViewHtml);
                webView.loadUrl(url);
            }
        });
    }

}