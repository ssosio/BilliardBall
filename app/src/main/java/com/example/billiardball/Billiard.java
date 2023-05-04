package com.example.billiardball;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class Billiard extends View {
    ShapeDrawable mBilliardBall;
    int cx = 50;
    int cy = 50;
    int radius = 50;
    int dir_x = 1;
    int dir_y = 1;

    int step_x = 5;
    int step_y = 15;

    int screen_width = Resources.getSystem().getDisplayMetrics().widthPixels;
    int screen_height = Resources.getSystem().getDisplayMetrics().heightPixels;


    public Billiard(Context context) {
        super(context);
        mBilliardBall = new ShapeDrawable(new OvalShape());
        mBilliardBall.getPaint().setColor(Color.RED);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLUE);
        if (cx <= radius)
            dir_x = 1;
        else if (cx >= screen_width - radius)
            dir_x = -1;

        if (cy <= radius)
            dir_y = 1;
        else if(cy >= screen_height - radius)
            dir_y = -1;

        cx = cx + step_x * dir_x;
        cy = cy + step_y * dir_y;

        mBilliardBall.setBounds(cx-radius, cy-radius, cx+radius,cy+radius);
        mBilliardBall.draw(canvas);


        invalidate();
    }
}
