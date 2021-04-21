package com.example.gogasrider.Customs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;

public class ThinText extends androidx.appcompat.widget.AppCompatTextView {
    public ThinText(@NonNull Context context) {
        super(context);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "montserrat.ttf");
        this.setTypeface(face);
    }

    public ThinText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "montserrat.ttf");
        this.setTypeface(face);
    }

    public ThinText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "montserrat.ttf");
        this.setTypeface(face);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
