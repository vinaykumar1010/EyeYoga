package com.vinay.eyeexercise;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import Exercise.FirebaseManager;
import Health.OnGetHealthTipListner;

public class Health_Layout2 extends AppCompatActivity {
    private  String newString;
    private  String  receivingString;
    private ProgressBar progressbar_view ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);


        WebView webView = findViewById(R.id.webViewHtml);
        progressbar_view = findViewById(R.id.progressBar);
        progressbar_view.setVisibility(View.VISIBLE);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);
        TextView textView = findViewById(R.id.toolbar);
        textView.setText("Layout2");
        //TODO here get the string stored in the string variable and do

        fetchDataFromFirebase(webView);

        progressbar_view.setVisibility(View.VISIBLE);
        // TODO: show progress bar
    }

    private void fetchDataFromFirebase(WebView webView) {
        FirebaseManager firebaseManagerObj = new FirebaseManager();
        firebaseManagerObj.storageData2(new OnGetHealthTipListner() {
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