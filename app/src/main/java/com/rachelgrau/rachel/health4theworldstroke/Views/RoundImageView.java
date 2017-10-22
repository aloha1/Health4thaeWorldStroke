package com.rachelgrau.rachel.health4theworldstroke.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

/**
 * Created by garyg on 10/12/2017.
 * <a href="http://www.jianshu.com/p/626dbd93207d></a>
 */
public class RoundImageView extends AppCompatImageView {

    private static final String TAG = RoundImageView.class.getSimpleName();
    private static final int radius = 15;//dp
    private float mWidth, mHeight;
    private Path path;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        path = new Path();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mWidth = getWidth();
        mHeight = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (mWidth > dpToPx(radius) && mHeight > dpToPx(radius)) {
            path.moveTo(dpToPx(radius), 0);
            path.lineTo(mWidth - dpToPx(radius), 0);
            path.quadTo(mWidth, 0, mWidth, dpToPx(radius));
            path.lineTo(mWidth, mHeight - dpToPx(radius));
            path.quadTo(mWidth, mHeight, mWidth - dpToPx(radius), mHeight);
            path.lineTo(dpToPx(radius), mHeight);
            path.quadTo(0, mHeight, 0, mHeight - dpToPx(radius));
            path.lineTo(0, dpToPx(radius));
            path.quadTo(0, 0, dpToPx(radius), 0);
            canvas.clipPath(path);
        }

        super.onDraw(canvas);
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
}