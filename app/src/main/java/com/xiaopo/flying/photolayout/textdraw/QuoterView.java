package com.xiaopo.flying.photolayout.textdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class QuoterView extends View {

    public QuoterView(Context context) {
        super(context);
    }

    public QuoterView(Context context,
        @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public QuoterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBubbles(canvas);
    }

    private void drawBubbles(final Canvas c) {
        final String texts[] = new String[]{
            "Hi there, I'm a blue bubble.",
            "Me too!",
            "There are a lot of bubbles around here. And all of them are blue.",
            "And now for something compeletly different. According to en.wikipedia.org, the " +
                "origin of this phrase \" is credited to Christopher Trace, founding presenter of" +
                " the children's television programme Blue Peter, who used it (in all " +
                "seriousness) as a link between segments\". Interesting, isn't it?",
            "Lorem ipsum is so boring.",
            "Draw text in a given rectangle and automatically wrap lines.",
            "This class is designed to be used in games and therefore tries to minimize " +
                "allocations after instantiation because those will trigger the GC more often " +
                "which causes a slight but noticeable delay.",
            "So, if you want to use this in a game, you should make the instance a class member, " +
                "allocate it once and reuse it.",
            "Don't forget to rotate your device!",
        };
        final int cells = (int) Math.ceil(Math.sqrt(texts.length));
        final int margin = 8;
        final int totalMargin = (cells + 1) * margin;
        final int w = (c.getWidth() - totalMargin) / cells;
        final int h = (c.getHeight() - totalMargin) / cells;

        for (int n = 0, l = texts.length, x = margin, y = margin;
             n < l; ) {
            drawBubble(
                c,
                x,
                y,
                w,
                h,
                texts[n]);

            if (++n % cells == 0) {
                x = margin;
                y += h + margin;
            } else
                x += w + margin;
        }
    }

    /** Draw a text bubble */
    private void drawBubble(
        final Canvas c,
        final int x,
        final int y,
        final int width,
        final int height,
        final String text) {
        final TextRect textRect;

        // set up font
        {
            final Paint fontPaint = new Paint();
            fontPaint.setColor(Color.WHITE);
            fontPaint.setAntiAlias(true);
            fontPaint.setTextSize(24);
            fontPaint.setTextAlign(Paint.Align.CENTER);
            textRect = new TextRect(fontPaint);
        }

        final int h = textRect.prepare(
            text,
            width - 8,
            height - 8);

        // draw bubble
        {
            final Paint p = new Paint();
            p.setColor(Color.BLUE);
            p.setStyle(Paint.Style.FILL);
            p.setAntiAlias(true);

            c.drawRoundRect(
                new RectF(x, y, x + width, y + h + 8),
                4,
                4,
                p);
        }

        textRect.draw(c, x + 4, y + 4);
    }
}
