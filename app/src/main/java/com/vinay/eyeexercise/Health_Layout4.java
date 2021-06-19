package com.vinay.eyeexercise;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import Exercise.FirebaseManager;
import Health.OnGetHealthTipListner;

public class Health_Layout4 extends AppCompatActivity {
    private  String newString;
    private  String  receivingString;
    private ProgressBar progressbar_view ;
    Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4);

        if (Build.VERSION.SDK_INT >= 21) {
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.white));
        }

        WebView webView = findViewById(R.id.webViewHtml);
        progressbar_view = findViewById(R.id.progressBar);
        progressbar_view.setVisibility(View.VISIBLE);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);
        TextView textView = findViewById(R.id.toolbar);
        textView.setText("Yoga");
        //TODO here get the string stored in the string variable and do

        progressbar_view.setVisibility(View.VISIBLE);
        webView.setVisibility(View.INVISIBLE);
        fetchDataFromFirebase(webView);


        // TODO: show progress bar
    }

    private void fetchDataFromFirebase(WebView webView) {
        FirebaseManager firebaseManagerObj = new FirebaseManager();
        firebaseManagerObj.storageData4(new OnGetHealthTipListner() {
            @Override
            public void onFailure() {
                Log.e(Constants.TAG, "firebase request to fetch exercises failed.");
            }

            @Override
            public void onSuccess(String url) {
                // TODO: hide progress bar
                String html1 = url;
                Log.i(Constants.TAG, "Second_One_Activity : onSuccess url: " + url);
                progressbar_view.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);

                webView.loadUrl(url);


            }
        });
    }
}