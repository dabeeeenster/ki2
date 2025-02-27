package com.valterc.ki2.karoo.overlay.position;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.valterc.ki2.data.preferences.PreferencesView;

public class PositionManager {

    private final View overlayView;

    private final int x;
    private final int y;

    private final int parentWidth;
    private final int parentHeight;

    private int lastX;
    private int lastY;

    private int lastWidth;
    private int lastHeight;

    public PositionManager(Context context, PreferencesView preferencesView, View overlayView) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        parentWidth = displayMetrics.widthPixels;
        parentHeight = displayMetrics.heightPixels;

        x = preferencesView.getOverlayPositionX(context);
        y = preferencesView.getOverlayPositionY(context);
        this.overlayView = overlayView;
    }

    public void updatePosition() {
        if (overlayView == null || parentHeight == 0 || parentWidth == 0) {
            return;
        }

        overlayView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        int viewWidth = overlayView.getMeasuredWidth() + overlayView.getPaddingStart() + overlayView.getPaddingEnd();
        int viewHeight = overlayView.getMeasuredHeight() + overlayView.getPaddingTop() + overlayView.getPaddingBottom();

        if ((lastWidth == viewWidth && lastHeight == viewHeight) || overlayView.getMeasuredWidth() == 0 || overlayView.getMeasuredHeight() == 0) {
            return;
        }

        lastWidth = viewWidth;
        lastHeight = viewHeight;

        int xValue = x;
        int yValue = y;

        if (xValue < 0) {
            xValue = 0;
        } else if (xValue + viewWidth > parentWidth) {
            xValue = parentWidth - viewWidth;
        }

        if (yValue < 0) {
            yValue = 0;
        } else if (yValue + viewHeight > parentHeight) {
            yValue = parentHeight - viewHeight;
        }

        if (lastX == xValue && lastY == yValue) {
            return;
        }

        ViewGroup.LayoutParams layoutParams = overlayView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParamsRelativeLayout = (RelativeLayout.LayoutParams) layoutParams;

        if (layoutParamsRelativeLayout.width != ViewGroup.LayoutParams.MATCH_PARENT) {
            layoutParamsRelativeLayout.leftMargin = xValue;
        }

        if (layoutParamsRelativeLayout.height != ViewGroup.LayoutParams.MATCH_PARENT) {
            layoutParamsRelativeLayout.topMargin = yValue;
        }

        lastX = xValue;
        lastY = yValue;

        overlayView.setLayoutParams(layoutParamsRelativeLayout);
    }
}
