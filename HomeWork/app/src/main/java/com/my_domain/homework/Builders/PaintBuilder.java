package com.my_domain.homework.Builders;

import android.graphics.Paint;

public class PaintBuilder {
    private Paint paint = new Paint();

    public static PaintBuilder getInstance() {
        return new PaintBuilder();
    }

    public PaintBuilder setColor(int color) {
        paint.setColor(color);
        return this;
    }

    public PaintBuilder setStrokeWidth(float width) {
        paint.setStrokeWidth(width);
        return this;
    }

    public PaintBuilder setAntiAlias(boolean on) {
        paint.setAntiAlias(on);
        return this;
    }

    public PaintBuilder setStyle(Paint.Style style) {
        paint.setStyle(style);
        return this;
    }

    public PaintBuilder setSizeText(float px) {
        paint.setTextSize(px);
        return this;
    }

    public Paint getPaint() {
        return paint;
    }
}
