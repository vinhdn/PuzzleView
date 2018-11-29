package com.xiaopo.flying.puzzle;

import android.content.Context;
import android.util.AttributeSet;

/**
 * @author wupanjie
 */
public class SquareDrawPuzzleView extends PuzzleView {
  public SquareDrawPuzzleView(Context context) {
    super(context);
  }

  public SquareDrawPuzzleView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public SquareDrawPuzzleView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    int width = getMeasuredWidth();
    int height = getMeasuredHeight();
    int length = width > height ? height : width;

    setMeasuredDimension(length, length);
  }
}
