package com.my_domain.homework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class ClockView extends View {

    private RectF rectF;
    private Paint paintRect;
    private Paint paintRound;


    public ClockView(Context context) {
        super(context);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

        rectF = new RectF();

        paintRect = new Paint();
        paintRect.setColor(Color.BLACK);
        paintRect.setAntiAlias(true);

        paintRound = new Paint();
        paintRound.setColor(Color.GRAY);
        paintRect.setAntiAlias(true);

    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.left = getWidth() * 0.05f;
        rectF.top = getHeight() * 0.25f;
        rectF.right = getWidth() - rectF.left;
        rectF.bottom = getHeight() - rectF.top;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawRect(rectF, paintRect);

        canvas.drawCircle(getWidth()/2, getHeight()/2,Math.min(10 * getWidth()/15, getHeight())/2, paintRound);

        paintRect.setStrokeWidth(10);
        for (float i = 0; i < 360; i = i + 6) {
            canvas.save();

            canvas.drawLine(getWidth()/2, getHeight()/2-getHeight() / 4 * 0.9f,getWidth() / 2, getHeight() / 2-getHeight() / 4 * 0.8f, paintRect);

            canvas.rotate(20, getWidth() / 2, getHeight() / 2);

        }
//        paintRect.setStrokeWidth(20);
//        canvas.drawLine(0, 0, getWidth(), getHeight(), paintRect);
    }
}
