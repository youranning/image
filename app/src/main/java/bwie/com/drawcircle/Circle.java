package bwie.com.drawcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by $USER_NAME on 2017/6/6.
 */

public class Circle extends View {

    float x = 100;
    float y = 100;
    private Paint paint;
    private Rect rect = new Rect();
    ;

    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);


    }

    public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x, y, 100, paint);
        rect.set((int) (x - 100), (int) (y - 100), (int) (x + 100), (int) (y + 100));

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:

                x = event.getX();
                y = event.getY();


                System.out.println("x=" + x);
                System.out.println("y=" + y);
                if (x > rect.left && x < rect.right && y > rect.top && y < rect.bottom) {
                    invalidate();
                }


                break;


        }


        return true;


    }


}
