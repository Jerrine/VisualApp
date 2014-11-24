package com.example.apple.visualapp;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;


/**
 * Created by apple on 11/2/14.
 */
public class DisplayC extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new displayC(this));
    }

    private class displayC extends View {
        // CONSTRUCTOR
        public displayC(Context context) {
            super(context);
            setFocusable(true);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);
            Paint p = new Paint();
            p.setAntiAlias(true); // smooths
            p.setColor(Color.WHITE);
            p.setStrokeWidth(2.0f);

            int x1 = 50, y1 = 50, x2 = 70, y2 = 70;

            //
            Random noBar = new Random();
            int randomNum = noBar.nextInt(23*9);
            int counter=0;
            boolean alt = true;
            int [] randomArray = {-2, -1, 0, 1, 2};

            for (int j = 0; j < 9; j++ ) {
                for (int i = 0; i < 23; i++ ) {
                    Random generator = new Random();
                    int randomIndexX = generator.nextInt(randomArray.length);
                    int randomIndexY = generator.nextInt(randomArray.length);
                    int xt = randomArray[randomIndexX];
                    int yt = randomArray[randomIndexY];
                    counter++;
                    //generating the target
                    if(randomNum==counter){
                        canvas.translate(xt ,yt);
                        canvas.drawLine(x1, y1+20, x2, y2-20, p);
                        Context context = getApplicationContext();
                        CharSequence text = "Target: x=" + ((x1+x2)/2) + " y=" + ((y1+y2)/2);
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        if (alt == true) {
                            canvas.drawLine(x1 + 10, y1 - 4, x2 - 10, y2 + 4, p);   //adding vertical bars on tilted bars
                            alt = false;
                        } else {
                            canvas.drawLine(x1 - 4, y1 + 10, x2 + 4, y2 - 10, p);   //adding horizontal bars on tilted bars
                            alt = true;
                        }
                    }else {
                        canvas.translate(xt,yt);
                        canvas.drawLine(x1, y1, x2, y2, p);
                        if (alt == true) {
                            canvas.drawLine(x1 + 10, y1 - 4, x2 - 10, y2 + 4, p);   //adding vertical bars on tilted bars
                            alt = false;
                        } else {
                            canvas.drawLine(x1 - 4, y1 + 10, x2 + 4, y2 - 10, p);   //adding horizontal bars on tilted bars
                            alt = true;
                        }
                    }
                    x1 += 50;
                    x2 += 50;
                }
                x1 = 50;
                x2 = 70;
                y1 += 50;
                y2 += 50;
            }

        }

        //@Override
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int)event.getX();
            int y = (int)event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Context context = getApplicationContext();
                    CharSequence text = "Touching at x:" + x + " and y:" + y;
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
            }

            return true;
        }


    }

}
