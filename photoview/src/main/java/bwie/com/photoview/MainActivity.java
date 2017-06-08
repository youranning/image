package bwie.com.photoview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.vp);
        setImage();
        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                PhotoView imageView = new PhotoView(getApplicationContext());
                imageView.setImageResource(list.get(position));
                container.addView(imageView);
                imageView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        PhotoView photo = (PhotoView) v;
                            Bitmap bitmap=photo.getDrawingCache();
                        setLongMethod(bitmap);
                        return true;
                    }
                });
                return imageView;
            }
        };
        vp.setAdapter(adapter);
    }

    private void setLongMethod(final Bitmap photo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("保存");
        builder.setMessage("是否保存到相册");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveImageToGallery(getApplication(),photo);

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();

    }


    public void saveImageToGallery(Context context, Bitmap bmp) {

        // 首先保存图片

        String fileName = System.currentTimeMillis() + ".jpg";
        System.out.println(Environment.getDataDirectory().getAbsolutePath());
        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        // 最后通知图库更新
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(file);
        intent.setData(uri);
        context.sendBroadcast(intent);
        Toast.makeText(context, "保存成功", Toast.LENGTH_LONG).show();
    }

    private void setImage() {

        list = new ArrayList<>();
        list.add(R.drawable.yff3);
        list.add(R.drawable.yff5);
        list.add(R.drawable.zqq3);
        list.add(R.drawable.zqq4);

    }
}
