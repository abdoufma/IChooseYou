package com.example.abdou.ichooseyou;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

public class JavaScriptInterface {
    private Activity activity;

    public JavaScriptInterface(Activity activiy) {
        this.activity = activiy;
    }

    @android.webkit.JavascriptInterface
    public void startVideo(String videoAddress){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(videoAddress), "video/mp4");
        activity.startActivity(intent);
    }

    public void performFileSearch(View view) {
        //((MainActivity)getActivity()).startChronometer();
        //MainActivity ma = new MainActivity();
        //ma.performFileSearch(view);


    }
    }
