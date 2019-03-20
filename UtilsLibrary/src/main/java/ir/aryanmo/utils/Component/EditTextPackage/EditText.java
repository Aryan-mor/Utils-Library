package ir.aryanmo.utils.Component.EditTextPackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;

import ir.aryanmo.utils.R;

import static ir.aryanmo.utils.utils.UtilsKt.dpToPx;

public class EditText extends android.support.v7.widget.AppCompatEditText {

    final static String ANDROIDXML = "http://schemas.android.com/apk/res/android";
    protected int minWidth;
    protected int minHeight;
    protected int background = R.drawable.edittext_style;
    protected int backgroundColor = Color.TRANSPARENT;
    protected float cornerRadius[] = {0, 0, 0, 0, 0, 0, 0, 0};
    protected int borderColor = Color.TRANSPARENT;
    protected int borderWidth = 0;

    public EditText(Context context) {
        super(context);
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        borderColor = ir.aryanmo.utils.utils.GetUtilsKt.getAccentColor(getContext());
        init(attrs);
    }

    protected void init(AttributeSet attrs) {
        setDefaultProperties();
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
            setText(ir.aryanmo.utils.utils.GetUtilsKt.getSpanned(getContext(), t.toString()));

        } catch (Exception e) {
            logError("setTextFromAttr", e);
        }
    }

    protected void setBackgroundFromAttr(AttributeSet attr) {
        try {
            int backgroundColor = attr.getAttributeResourceValue(ANDROIDXML, "background", -1);
            if (backgroundColor != -1) {
                setBackgroundColor(getResources().getColor(backgroundColor));
            } else {
                background = attr.getAttributeIntValue(ANDROIDXML, "background", -1);
                if (background != -1) {
                    setBackgroundColor(background);
                }
            }
        } catch (Exception e) {
            logError("setBackgroundFromAttr", e);
        }
    }

    protected void setCornerRadiusFromAttr(AttributeSet attr) {
        try {
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
        } catch (Exception e) {
            logError("setCornerRadiusFromAttr", e);
        }
    }

    protected void setBorderFromAttr(AttributeSet attr) {
        try {
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
        } catch (Exception e) {
            logError("setBorderFromAttr", e);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Log.e("Eris","onDraw id -> " + getId());
//
//        float[] values = getBackgroundShape().getCornerRadii();
//        Log.e("Eris","corner rippleRadius " + values[0]);

//        canvas.drawBitmap(makeRippleCircle(),0,0,null);
//        invalidate();
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

    public float[] getCornerRadiusTopLeft() {
        return new float[]{cornerRadius[0], cornerRadius[1]};
    }

    public void setCornerRadiusTopLeft(int cornerRadius) {
        this.cornerRadius[0] = cornerRadius;
        this.cornerRadius[1] = cornerRadius;
        setShapeCornerRadius();
    }

    public float[] getCornerRadiusTopRight() {
        return new float[]{cornerRadius[2], cornerRadius[3]};
    }

    public void setCornerRadiusTopRight(int cornerRadius) {
        this.cornerRadius[2] = cornerRadius;
        this.cornerRadius[3] = cornerRadius;
        setShapeCornerRadius();
    }

    public float[] getCornerRadiusBottomRight() {
        return new float[]{cornerRadius[4], cornerRadius[5]};
    }

    public void setCornerRadiusBottomRight(int cornerRadius) {
        this.cornerRadius[4] = cornerRadius;
        this.cornerRadius[5] = cornerRadius;
        setShapeCornerRadius();
    }

    public float[] getCornerRadiusBottomLeft() {
        return new float[]{cornerRadius[6], cornerRadius[7]};
    }

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

    private void logError(String s, Exception e) {
        ir.aryanmo.utils.utils.log.LogUtilsKt.logError("SimpleEditText::" + s, e);
    }
}
