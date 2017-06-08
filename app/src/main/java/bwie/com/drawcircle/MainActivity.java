package bwie.com.drawcircle;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

//    private Circle circle;
//    private ImageView imageView;
//
//    private Matrix matrix = new Matrix();
//    private Matrix savedMatrix = new Matrix();
//
//    private static final int NONE = 0;
//    private static final int DRAG = 1;
//    private static final int ZOOM = 2;
//    private int mode = NONE;
//    private PointF startPoint = new PointF();
//    // 两个按下的手指的触摸点的中点
//    private PointF midPoint = new PointF();
//    // 初始的两个手指按下的触摸点的距离
//    private float oriDis = 1f;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////        circle = (Circle) findViewById(R.id.cc);
//        imageView = (ImageView) findViewById(R.id.iv);
//        imageView.setOnTouchListener(this);
//    }
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        imageView = (ImageView) v;
//
//        // 可以处理处理多点触摸
////        http://blog.csdn.net/fobdddf/article/details/19479153
////        http://blog.sina.com.cn/s/blog_60e96a410100mjd2.html
////        https://my.oschina.net/qianjia/blog/109282
//        switch (event.getAction() & MotionEvent.ACTION_MASK) {
//            case MotionEvent.ACTION_DOWN:
//                // 第一个手指按下事件
//                matrix.set(imageView.getImageMatrix());
//                savedMatrix.set(matrix);
//                startPoint.set(event.getX(), event.getY());
//                //拖动
//                mode = DRAG;
//                break;
//            case MotionEvent.ACTION_POINTER_DOWN:
////            event.getX(012)
//                // 第二个手指按下事件
//                oriDis = distance(event);
//                if (oriDis > 10f) {
//                    savedMatrix.set(matrix);
//                    midPoint = middle(event);
//                    //标记成缩放状态
//                    mode = ZOOM;
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_POINTER_UP:
//                // 手指放开事件
//
//                mode = NONE;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                // 手指滑动事件
//                if (mode == DRAG) {
//                    // 是一个手指拖动
//                    matrix.set(savedMatrix);
//                    //移动图片
//                    matrix.postTranslate(event.getX() - startPoint.x, event.getY()
//                            - startPoint.y);
//                } else if (mode == ZOOM) {
//                    // 两个手指滑动
//                    float newDist = distance(event);
//                    if (newDist > 10f) {
//                        matrix.set(savedMatrix);
//                        float scale = newDist / oriDis;
//                        //图片的缩放
//                        matrix.postScale(scale, scale, midPoint.x, midPoint.y);
//                    }
//                }
//                break;
//        }
//
//        // 设置ImageView的Matrix
//        imageView.setImageMatrix(matrix);
//        return true;
//    }
//
//    // 计算两个触摸点之间的距离
//    private float distance(MotionEvent event) {
//        //获取第0跟手指和第一根手指的坐标
//        float x = event.getX(0) - event.getX(1);
//        float y = event.getY(0) - event.getY(1);
//        return (float) Math.sqrt(x * x + y * y);
//    }
//
//    // 计算两个触摸点的中点
//    private PointF middle(MotionEvent event) {
//        float x = event.getX(0) + event.getX(1);
//        float y = event.getY(0) + event.getY(1);
//        return new PointF(x / 2, y / 2);
//    }
/*
View view;
    public static final int DRAG = 1;
    public static final int SCALE = 2;
    int mode = 1;

    int height = 10, width = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.iv);
    }

    float length = 1;

    // 重写
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        // 多指触控
        switch (event.getAction() & event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mode = DRAG;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.e("TAG", "多指移动");
                mode = SCALE;
                // 两个手指开始的长度是多少呢？
                length = calc(event);
                break;
            case MotionEvent.ACTION_UP:
                length = 1;
                break;
            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG) {
                    // 1. 单个手指
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                            width, height);
                    params.setMargins(x, y, 0, 0);
                    view.setLayoutParams(params);
                } else {
                    // 2. 两个手指
                    float beilv = calc(event) / length;
                    width = (int) (view.getWidth() * beilv);
                    height = (int) (view.getHeight() * beilv);
                    Log.e("TAG", beilv + "  " + width + "  " + height);


                    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view
                            .getLayoutParams();
                    params.width = width;
                    params.height = height;
                    view.setLayoutParams(params);
                }
                break;
        }
        return true;
    }

    // 类 Ponint
    public float calc(MotionEvent event) {
        float x1 = event.getX();
        float y1 = event.getY();
        float x2 = event.getX(1);
        float y2 = event.getY(1);
        return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));


    }
*/








    private ImageView mImageView;

    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();

    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;

    // 第一个按下的手指的点
    private PointF startPoint = new PointF();
    // 两个按下的手指的触摸点的中点
    private PointF midPoint = new PointF();
    // 初始的两个手指按下的触摸点的距离
    private float oriDis = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView= (ImageView) findViewById(R.id.iv);
//        mImageView = (ImageView) findViewById(R.id.iv);
        mImageView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;

        // 可以处理处理多点触摸
//        http://blog.csdn.net/fobdddf/article/details/19479153
//        http://blog.sina.com.cn/s/blog_60e96a410100mjd2.html
//        https://my.oschina.net/qianjia/blog/109282
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                // 第一个手指按下事件
                matrix.set(view.getImageMatrix());
                savedMatrix.set(matrix);
                startPoint.set(event.getX(), event.getY());
                //拖动
                mode = DRAG;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
//            event.getX(012)
                // 第二个手指按下事件
                oriDis = distance(event);
                if (oriDis > 10f) {
                    savedMatrix.set(matrix);
                    midPoint = middle(event);
                    //标记成缩放状态
                    mode = ZOOM;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                // 手指放开事件
                mode = NONE;
                break;
            case MotionEvent.ACTION_MOVE:
                // 手指滑动事件
                if (mode == DRAG) {
                    // 是一个手指拖动
                    matrix.set(savedMatrix);
                    //移动图片
                    matrix.postTranslate(event.getX() - startPoint.x, event.getY()
                            - startPoint.y);
                } else if (mode == ZOOM) {
                    // 两个手指滑动
                    float newDist = distance(event);
                    if (newDist > 10f) {
                        matrix.set(savedMatrix);
                        float scale = newDist / oriDis;
                        //图片的缩放
                        matrix.postScale(scale, scale, midPoint.x, midPoint.y);
                    }
                }
                break;
        }

        // 设置ImageView的Matrix
        view.setImageMatrix(matrix);
        return true;
    }

    // 计算两个触摸点之间的距离
    private float distance(MotionEvent event) {
        //获取第0跟手指和第一根手指的坐标
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    // 计算两个触摸点的中点
    private PointF middle(MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        return new PointF(x / 2, y / 2);
    }
}
