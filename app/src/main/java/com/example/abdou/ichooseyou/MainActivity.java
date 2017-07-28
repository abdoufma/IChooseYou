package com.example.abdou.ichooseyou;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public void alert(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    //private ImageView iv = (ImageView) findViewById(R.id.image);;
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alert("Activity Created!");

        wv = (WebView) findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("file:///android_asset/upload.html");

        JavaScriptInterface jsInterface = new JavaScriptInterface(this);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wv.addJavascriptInterface(jsInterface, "JSInterface");
    }


    private static final int READ_REQUEST_CODE = 42;

    public void performFileSearch(View view) {

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {/*

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                Log.i(TAG, "Uri: " + uri.toString());
                //iv.setImageBitmap(BitmapFactory.decodeFile(PathString));
                iv.setImageResource(R.drawable.unity_chan_ok);

            }
        }*/
    }


    @Override
    protected void onStart() {
        super.onStart();
        //performFileSearch(findViewById(R.id.wv));
    }
}
