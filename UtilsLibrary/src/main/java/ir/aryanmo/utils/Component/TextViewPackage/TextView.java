package ir.aryanmo.utils.Component.TextViewPackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import ir.aryanmo.utils.R;

public class TextView extends android.support.v7.widget.AppCompatTextView {
    final static String ANDROIDXML = "http://schemas.android.com/apk/res/android";
    int minWidth;
    int minHeight;
    int background = R.drawable.edittext_style;
    int backgroundColor = Color.TRANSPARENT;
    float cornerRadius[] = {0, 0, 0, 0, 0, 0, 0, 0};
    int borderColor = Color.TRANSPARENT;
    int borderWidth = 0;
    OnClickListener onClickListener;
    boolean animRotate = false;
    int animationType = -1;
    int animDuration = 900;
    public static int ANIM_ROTATE = 1000;

    public TextView(Context context) {
        super(context);
        init();
    }

    public TextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    protected void init() {
        setDefaultProperties();
    }

    protected void init(AttributeSet attrs) {
        init();
        setAttributes(attrs);
    }

    protected void setDefaultProperties() {
        // Min size
        setMinimumHeight(ir.aryanmo.utils.utils.UtilsKt.dpToPx(minHeight, getResources()));
        setMinimumWidth(ir.aryanmo.utils.utils.UtilsKt.dpToPx(minWidth, getResources()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(new GradientDrawable());
        }
        setBackgroundColor(backgroundColor);
        setCornerRadius(0);
        setBorderWidth(borderWidth);
        setBorderColor(borderColor);
    }

    protected void setAttributes(AttributeSet attrs) {
        setTextFromAttr(attrs);
        setBackgroundFromAttr(attrs);
        setBorderFromAttr(attrs);
        setCornerRadiusFromAttr(attrs);
    }

    protected void setTextFromAttr(AttributeSet attr) {
        try {
            int[] set = {
                    android.R.attr.text
            };

            TypedArray a = getContext().obtainStyledAttributes(attr, set);
            CharSequence t = a.getText(0);
            a.recycle();
            if (t != null) {
                setText(ir.aryanmo.utils.utils.GetUtilsKt.getSpanned(getContext(), t.toString()));
            }
        } catch (Exception e) {
            logError("setTextFromAttr", e);
        }
    }



    protected void setBackgroundFromAttr(AttributeSet attr) {
        int backgroundColor = attr.getAttributeResourceValue(ANDROIDXML, "background", -1);
        if (backgroundColor != -1) {
            setBackgroundColor(getResources().getColor(backgroundColor));
        } else {
            backgroundColor = attr.getAttributeIntValue(ANDROIDXML, "background", -1);
            if (backgroundColor != -1) {
                setBackgroundColor(backgroundColor);
            }
        }
    }

    protected void setCornerRadiusFromAttr(AttributeSet attr) {

        TypedArray a = getStyledAttributes(attr);
        int b = a.getDimensionPixelSize(R.styleable.ArGlobal_ar_cornerRadius, -1);
        if (b != -1) {
            setCornerRadius(b);
        }
        b = a.getDimensionPixelSize(R.styleable.ArGlobal_ar_cornerRadiusLeft, -1);
        if (b != -1) {
            setCornerRadiusLeft(b);
        }
        b = a.getDimensionPixelSize(R.styleable.ArGlobal_ar_cornerRadiusTop, -1);
        if (b != -1) {
            setCornerRadiusTop(b);
        }
        b = a.getDimensionPixelSize(R.styleable.ArGlobal_ar_cornerRadiusRight, -1);
        if (b != -1) {
            setCornerRadiusRight(b);
        }
        b = a.getDimensionPixelSize(R.styleable.ArGlobal_ar_cornerRadiusBottom, -1);
        if (b != -1) {
            setCornerRadiusBottom(b);
        }
        b = a.getDimensionPixelSize(R.styleable.ArGlobal_ar_cornerRadiusTopLeft, -1);
        if (b != -1) {
            setCornerRadiusTopLeft(b);
        }
        b = a.getDimensionPixelSize(R.styleable.ArGlobal_ar_cornerRadiusTopRight, -1);
        if (b != -1) {
            setCornerRadiusTopRight(b);
        }
        b = a.getDimensionPixelSize(R.styleable.ArGlobal_ar_cornerRadiusBottomLeft, -1);
        if (b != -1) {
            setCornerRadiusBottomLeft(b);
        }
        b = a.getDimensionPixelSize(R.styleable.ArGlobal_ar_cornerRadiusBottomRight, -1);
        if (b != -1) {
            setCornerRadiusBottomRight(b);
        }

        a.recycle();
    }

    protected void setBorderFromAttr(AttributeSet attr) {
        TypedArray a = getStyledAttributes(attr);
        borderWidth = a.getDimensionPixelSize(R.styleable.ArGlobal_ar_itemBorderWidth, -1);
        if (borderWidth != -1) {
            borderWidth = ir.aryanmo.utils.utils.UtilsKt.dpToPx(borderWidth, getResources());
        } else {
            borderWidth = a.getInt(R.styleable.ArGlobal_ar_itemBorderWidth, -1);
        }
        borderColor = a.getColor(R.styleable.ArGlobal_ar_itemBorderColor, -1);
        if (borderColor == -1) {
            borderColor = ir.aryanmo.utils.utils.GetUtilsKt.getAccentColor(getContext());
        }
        setBorder(borderWidth, borderColor);
        a.recycle();
    }


    protected GradientDrawable getBackgroundShape() {
//        LayerDrawable layer = (LayerDrawable) getBackground();
//        return (GradientDrawable) layer.findDrawableByLayerId(R.id.shape_background);
        return (GradientDrawable) getBackground();
    }

    protected TypedArray getStyledAttributes(AttributeSet attr) {
        return getContext().getTheme().obtainStyledAttributes(
                attr, R.styleable.ArGlobal, 0, 0);
    }

    protected void startAnim() {
        try {
            if (!isAnimRotate()) {
                clearAnimation();
                return;
            }

            Animation animation = null;
            if (getAnimationType() == ANIM_ROTATE) {
                animation = new RotateAnimation(
                        0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                );

                animation.setDuration(getAnimDuration());
                animation.setRepeatCount(Animation.INFINITE);
            }

            if (animation != null)
                startAnimation(animation);
        } catch (Exception e) {
            logError("startAnim", e);
        }
    }
    //Override

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        this.onClickListener = l;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        invalidate();
        if (isEnabled()) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //aasas
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
//                if (!((event.getX() <= getWidth() && event.getX() >= 0) && (event
//                        .getY() <= getHeight() && event.getY() >= 0))) {
//
//                }
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                if ((event.getX() <= getWidth() && event.getX() >= 0)
                        && (event.getY() <= getHeight() && event.getY() >= 0)) {
                    if (onClickListener != null) {
                        onClickListener.onClick(this);
                    }
                }
            } else if (event.getAction() == MotionEvent.ACTION_CANCEL) {

            }
        }
        return super.onTouchEvent(event);

    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        LogUtils.log("ErisTextView::dispatchTouchEvent");
//        return super.dispatchTouchEvent(ev);
//    }

    // Getter And Setter

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int color) {
        this.backgroundColor = color;
        try {
            getBackgroundShape().setColor(backgroundColor);
        } catch (Exception ex) {
            Log.e("ERROR", ex.getMessage());
        }
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = new float[]{cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius};
        setShapeCornerRadius();
    }

    public void setCornerRadius(float[] floats) {
        //        {TopLeft,TopLeft,TopRight,TopRight,BottomRight,BottomRight,BottomLeft,BottomLeft}

        try {
            if (floats.length < 8)
                throw new Exception("floats must be 8 value");
            this.cornerRadius = floats;
            setShapeCornerRadius();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCornerRadiusLeft(int cornerRadius) {
        this.cornerRadius[0] = cornerRadius;
        this.cornerRadius[1] = cornerRadius;
        this.cornerRadius[6] = cornerRadius;
        this.cornerRadius[7] = cornerRadius;
        setShapeCornerRadius();
    }

    public void setCornerRadiusTop(int cornerRadius) {
        this.cornerRadius[0] = cornerRadius;
        this.cornerRadius[1] = cornerRadius;
        this.cornerRadius[2] = cornerRadius;
        this.cornerRadius[3] = cornerRadius;
        setShapeCornerRadius();
    }

    public void setCornerRadiusRight(int cornerRadius) {
        this.cornerRadius[2] = cornerRadius;
        this.cornerRadius[3] = cornerRadius;
        this.cornerRadius[4] = cornerRadius;
        this.cornerRadius[5] = cornerRadius;
        setShapeCornerRadius();
    }

    public void setCornerRadiusBottom(int cornerRadius) {
        this.cornerRadius[4] = cornerRadius;
        this.cornerRadius[5] = cornerRadius;
        this.cornerRadius[6] = cornerRadius;
        this.cornerRadius[7] = cornerRadius;
        setShapeCornerRadius();
    }


//    public int getCornerRadiusTopLeft() {
//        return cornerRadiusTopLeft;
//    }

    public void setCornerRadiusTopLeft(int cornerRadius) {
        this.cornerRadius[0] = cornerRadius;
        this.cornerRadius[1] = cornerRadius;
        setShapeCornerRadius();
    }

//    public int getCornerRadiusTopRight() {
//        return cornerRadiusTopRight;
//    }

    public void setCornerRadiusTopRight(int cornerRadius) {
        this.cornerRadius[2] = cornerRadius;
        this.cornerRadius[3] = cornerRadius;
        setShapeCornerRadius();
    }


//    public int getCornerRadiusBottomRight() {
//        return cornerRadiusBottomRight;
//    }

    public void setCornerRadiusBottomRight(int cornerRadius) {
        this.cornerRadius[4] = cornerRadius;
        this.cornerRadius[5] = cornerRadius;
        setShapeCornerRadius();
    }

//    public int getCornerRadiusBottomLeft() {
//        return cornerRadiusBottomLeft;
//    }

    public void setCornerRadiusBottomLeft(int cornerRadius) {
        this.cornerRadius[6] = cornerRadius;
        this.cornerRadius[7] = cornerRadius;
        setShapeCornerRadius();
    }

    private void setShapeCornerRadius() {
//        {TopLeft,TopLeft,TopRight,TopRight,BottomRight,BottomRight,BottomLeft,BottomLeft}
        getBackgroundShape().setCornerRadii(cornerRadius);

    }

    public int getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(int borderColor) {
        setBorder(borderWidth, borderColor);
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        setBorder(borderWidth, borderColor);
    }

    public void setBorder(int borderWidth, int borderColor) {
        getBackgroundShape().setStroke(borderWidth, borderColor);
    }

    public boolean isAnimRotate() {
        return animRotate;
    }

    public int getAnimDuration() {
        return animDuration;
    }

    public void setAnimDuration(int animDuration) {
        this.animDuration = animDuration;
    }

    public int getAnimationType() {
        return animationType;
    }

    public void setAnimationType(int animationType) {
        this.animationType = animationType;
    }

    public void setAnim(boolean animRotate) {
        this.animRotate = animRotate;
        startAnim();
    }

    public void setAnim(boolean animRotate, int anim) {
        this.animRotate = animRotate;
        this.animationType = anim;
        startAnim();
    }

    public void setAnim(boolean animRotate, int animType, int animDuration) {
        this.animRotate = animRotate;
        this.animationType = animType;
        this.animDuration = animDuration;
        startAnim();
    }

    public OnClickListener getOnClickListener() {
        return onClickListener;
    }

    private void logError(String s, Exception e) {
        ir.aryanmo.utils.utils.log.LogUtilsKt.logError("TextView::" + s, e);
    }
}
