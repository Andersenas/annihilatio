package com.my_domain.homework.Builders;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;

public class CanvasBuilder {
    private Canvas canvas;

    private CanvasBuilder(Canvas canvas) {
        this.canvas = canvas;
    }

    public static CanvasBuilder getInstance(Canvas canvas){
        return new CanvasBuilder(canvas);
    }

    public CanvasBuilder rotate(float degrees, float px, float py) {
        canvas.rotate(degrees, px, py);
        return this;
    }

    public CanvasBuilder drawLine(float startX, float startY, float stopX, float stopY,
                                  @NonNull Paint paint) {
        canvas.drawLine(startX, startY, stopX, stopY, paint);
        return this;
    }

    public CanvasBuilder drawText(@NonNull String text, float x, float y, @NonNull Paint paint) {
        canvas.drawText(text, x, y, paint);
        return this;
    }

    public CanvasBuilder drawCircle (float cx, float cy, float radius, @NonNull Paint paint) {
        canvas.drawCircle(cx, cy, radius, paint);
        return this;
    }




    public Canvas getCanvas() {
        return canvas;
    }

}
