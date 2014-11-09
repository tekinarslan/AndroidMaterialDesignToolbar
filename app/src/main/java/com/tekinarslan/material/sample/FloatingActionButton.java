package com.tekinarslan.material.sample;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FloatingActionButton extends Button {

    int sizeIcon = 24;
    int sizeRadius = 28;
    ImageView icon; // Icon of float button
    Drawable drawableIcon;

    public FloatingActionButton(Context context, AttributeSet attributes) {
        super(context, attributes);
        setBackgroundResource(R.drawable.fab);
        sizeRadius = 28;
        setDefaultProperties();
        icon = new ImageView(context);
        if (drawableIcon != null) {
            try {
                icon.setBackground(drawableIcon);
            } catch (NoSuchMethodError e) {
                icon.setBackgroundDrawable(drawableIcon);
            }
        }
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(dpToPx(sizeIcon, getResources()), dpToPx(sizeIcon, getResources()));
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        icon.setLayoutParams(params);
        addView(icon);
    }

    protected void setDefaultProperties() {
        rippleSpeed = dpToPx(2, getResources());
        rippleSize = dpToPx(5, getResources());
        super.minWidth = sizeRadius * 2;
        super.minHeight = sizeRadius * 2;
        super.background = R.drawable.fab;
        super.setDefaultProperties();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (x != -1) {
            Rect src = new Rect(0, 0, getWidth(), getHeight());
            Rect dst = new Rect(dpToPx(1, getResources()), dpToPx(2, getResources()), getWidth() - dpToPx(1, getResources()), getHeight() - dpToPx(2, getResources()));
            canvas.drawBitmap(cropCircle(makeCircle()), src, dst, null);
        }
        invalidate();
    }

    public int dpToPx(float dp, Resources resources) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
        return (int) px;
    }

    public ImageView getIcon() {
        return icon;
    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }

    public Drawable getDrawableIcon() {
        return drawableIcon;
    }

    public void setDrawableIcon(Drawable drawableIcon) {
        this.drawableIcon = drawableIcon;
        try {
            icon.setBackground(drawableIcon);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
    }

    public Bitmap cropCircle(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
                bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    @Override
    public TextView getTextView() {
        return null;
    }
}
