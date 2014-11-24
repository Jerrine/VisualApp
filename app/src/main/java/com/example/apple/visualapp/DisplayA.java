package com.example.apple.visualapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by apple on 11/2/14.
 */
public class DisplayA extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_a);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.confirmButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, DisplayC.class);
                startActivity(intent);
            }
        });
    }

}