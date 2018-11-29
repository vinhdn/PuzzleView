package com.jcmore2.collage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;

/**
 * Card View is a Collage item
 *
 * @author Juan Carlos Moreno (jcmore2@gmail.com)
 */
public class CardView extends CircleImageView {

    private MultiTouchListener mtl;

    public CardView(Context context) {
        this(context, null);
        init();
    }

    public CardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public CardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        this.setScaleType(ScaleType.CENTER_CROP);
        mtl = new MultiTouchListener();
        this.setOnTouchListener(mtl);
        mtl.setRandomPosition(this);
        setBorderWidth(10);
        setFixRadius(10);
        setBorderColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /**
     * Function use to block movement in Card
     */
    public void setFixedItem() {

        mtl.isRotateEnabled = false;
        mtl.isScaleEnabled = false;
        mtl.isTranslateEnabled = false;
    }

}