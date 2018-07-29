package com.my_domain.homework.hw4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;

import com.my_domain.homework.Builders.PaintBuilder;

public class CircleDiagram extends View {
    private Paint red = PaintBuilder.getInstance().setAntiAlias(true).setColor(Color.RED).setStyle(Paint.Style.FILL).getPaint();
    private Paint green = PaintBuilder.getInstance().setAntiAlias(true).setColor(Color.GREEN).setStyle(Paint.Style.FILL).getPaint();
    private Paint blue = PaintBuilder.getInstance().setAntiAlias(true).setColor(Color.BLUE).setStyle(Paint.Style.FILL).getPaint();
    private float oneDegree;
    private float twoDegree;
    private float threeDegree;
    private RectF rectF = new RectF();

    public CircleDiagram(Context context) {
        super(context);
    }

    public CircleDiagram(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleDiagram(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleDiagram(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setData(Editable a, Editable b, Editable c) {
        calculateData(a, b, c);
    }

    private void calculateData(Editable a, Editable b, Editable c) {
        float sum = Float.valueOf(a.toString()) + Float.valueOf(b.toString()) + Float.valueOf(c.toString());
        float oneDeal = (Float.valueOf(a.toString()) * 100) / sum;
        float twoDeal = (Float.valueOf(b.toString()) * 100) / sum;
        float threeDeal = (Float.valueOf(c.toString()) * 100) / sum;
        oneDegree = 360 * (oneDeal / 100);
        twoDegree = 360 * (twoDeal / 100);
        threeDegree = 360 * (threeDeal / 100);
        invalidate();
    }

    private void drawRect() {
        rectF.left = getWidth() * 0.05f;
        rectF.top = getHeight() * 0.25f;
        rectF.bottom = getHeight() - rectF.top;
        rectF.right = getWidth() - rectF.left;
    }

    private void drawDiagramme(Canvas canvas) {
        drawRect();
        canvas.drawArc(rectF, 0f, oneDegree, true, red);
        canvas.drawArc(rectF, oneDegree, twoDegree, true, blue);
        canvas.drawArc(rectF, oneDegree + twoDegree, threeDegree, true, green);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDiagramme(canvas);
    }
}
