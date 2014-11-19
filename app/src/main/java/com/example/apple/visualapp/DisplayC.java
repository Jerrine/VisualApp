package com.example.apple.visualapp;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import java.util.Random;


/**
 * Created by apple on 11/2/14.
 */
public class DisplayC extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new displayA(this));
    }

    private static class displayA extends View {
        // CONSTRUCTOR
        public displayA(Context context) {
            super(context);
            setFocusable(true);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);
            Paint p = new Paint();
            p.setAntiAlias(true); // smooths
            p.setColor(Color.WHITE);
            p.setStrokeWidth(2.0f);

            int x1 = 50, y1 = 50, x2 = 80, y2 = 80;

            for (y1 = 50; y1 < 500; ) {
                for (x1 = 50; x1 < 1200; ) {
                    canvas.drawLine(x1, y1, x2, y2, p);
                    x1 += 50;
                    x2 += 50;
                }
                x1 = 50;
                x2 = 80;
                y1 += 50;
                y2 += 50;
            }

            x1 = 50; y1 = 50; x2 = 80; y2 = 80;

            for (y1 = 50; y1 < 500; ) {
                for (x1 = 50; x1 < 1200; ) {
                    Random rnd = new Random();
                    int randomNum1 = rnd.nextInt(100);
                    if (randomNum1 > 50) {
                        canvas.drawLine(x1 + 15, y1 - 4, x2 - 15, y2 + 4, p);   //adding vertical bars on tilted bars
                    } else {
                        canvas.drawLine(x1 - 4, y1 + 15, x2 + 4, y2 - 15, p);   //adding horizontal bars on tilted bars
                    }
                    x1 += 50;
                    x2 += 50;
                }
                x1 = 50;
                x2 = 80;
                y1 += 50;
                y2 += 50;
            }

        }

    }

}
